package das.jhaman.movieapp.ui.util

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.AnimationState
import androidx.compose.animation.core.DecayAnimationSpec
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDecay
import androidx.compose.animation.core.animateTo
import androidx.compose.animation.core.spring
import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.Velocity
import androidx.compose.ui.unit.dp
import kotlin.math.abs

@Stable
interface BottomBarScrollBehavior {
    val state: BottomBarState
    val isPinned: Boolean
    val snapAnimationSpec: AnimationSpec<Float>?
    val flingAnimationSpec: DecayAnimationSpec<Float>?
    val nestedScrollConnection: NestedScrollConnection

    companion object {
        @Composable
        fun enterAlwaysScrollBehavior(
            state: BottomBarState = rememberBottomBarState(),
            canScroll: () -> Boolean = { true },
            snapAnimationSpec: AnimationSpec<Float>? = spring(stiffness = Spring.StiffnessMediumLow),
            flingAnimationSpec: DecayAnimationSpec<Float>? = rememberSplineBasedDecay()
        ): BottomBarScrollBehavior = EnterAlwaysScrollBehavior(
            state = state,
            snapAnimationSpec = snapAnimationSpec,
            flingAnimationSpec = flingAnimationSpec,
            canScroll = canScroll
        )
    }
}

class EnterAlwaysScrollBehavior(
    override val state: BottomBarState,
    override val snapAnimationSpec: AnimationSpec<Float>?,
    override val flingAnimationSpec: DecayAnimationSpec<Float>?,
    val canScroll: () -> Boolean = { true }
) : BottomBarScrollBehavior {
    override val isPinned: Boolean = false
    override var nestedScrollConnection = object : NestedScrollConnection {
        override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
            if (!canScroll()) return Offset.Zero
            state.heightOffset -= available.y
            return Offset.Zero
        }

        override fun onPostScroll(
            consumed: Offset,
            available: Offset,
            source: NestedScrollSource
        ): Offset {
            if (!canScroll()) return Offset.Zero
            state.contentOffset += consumed.y
            if (state.heightOffset == 0f || state.heightOffset == state.heightOffsetLimit) {
                if (consumed.y == 0f && available.y > 0f) {
                    // Reset the total content offset to zero when scrolling all the way down.
                    // This will eliminate some float precision inaccuracies.
                    state.contentOffset = 0f
                }
            }
            state.heightOffset -= consumed.y
            return Offset.Zero
        }

        override suspend fun onPostFling(consumed: Velocity, available: Velocity): Velocity {
            val superConsumed = super.onPostFling(consumed, available)
            return superConsumed + settleBottomBar(
                state = state,
                velocity = available.y,
                flingAnimationSpec = flingAnimationSpec,
                snapAnimationSpec = snapAnimationSpec
            )
        }
    }
}

private suspend fun settleBottomBar(
    state: BottomBarState,
    velocity: Float,
    flingAnimationSpec: DecayAnimationSpec<Float>?,
    snapAnimationSpec: AnimationSpec<Float>?
): Velocity {
    // Check if the bottom bar is completely collapsed/expanded. If so, no need to settle the bottom bar,
    // and just return Zero Velocity.
    // Note that we don't check for 0f due to float precision with the collapsedFraction
    // calculation.
    if (state.collapsedFraction < 0.01f || state.collapsedFraction == 1f) {
        return Velocity.Zero
    }
    var remainingVelocity = velocity
    // In case there is an initial velocity that was left after a previous user fling, animate to
    // continue the motion to expand or collapse the bottom bar.
    if (flingAnimationSpec != null && abs(velocity) > 1f) {
        var lastValue = 0f
        AnimationState(
            initialValue = 0f,
            initialVelocity = velocity,
        )
            .animateDecay(flingAnimationSpec) {
                val delta = value - lastValue
                val initialHeightOffset = state.heightOffset
                state.heightOffset = initialHeightOffset - delta
                val consumed = abs(initialHeightOffset - state.heightOffset)
                lastValue = value
                remainingVelocity = this.velocity
                // avoid rounding errors and stop if anything is unconsumed
                if (abs(delta - consumed) > 0.5f) this.cancelAnimation()
            }
    }
    // Snap if animation specs were provided.
    if (snapAnimationSpec != null) {
        if (state.heightOffset > 0 &&
            state.heightOffset < state.heightOffsetLimit
        ) {
            AnimationState(initialValue = state.heightOffset).animateTo(
                if (state.collapsedFraction < 0.5f) {
                    0f
                } else {
                    state.heightOffsetLimit
                },
                animationSpec = snapAnimationSpec
            ) { state.heightOffset = value }
        }
    }

    return Velocity(0f, remainingVelocity)
}

private val navBottomBarHeight = 80.dp

@Composable
fun rememberEdgeToEdgeBottomBarState(density: Density): EdgeToEdgeBottomBarState {
    val navBarsBottomInsets = with(density) {
        WindowInsets.navigationBars.getBottom(this).toDp()
    }
    val initialOffsetLimit = with(density) {
        navBottomBarHeight.toPx() + navBarsBottomInsets.toPx()
    }

    return EdgeToEdgeBottomBarState(
        navBarHeight = navBottomBarHeight + navBarsBottomInsets,
        initialOffsetLimitPx = initialOffsetLimit,
        bottomBarState = rememberBottomBarState(initialOffsetLimit),
    )
}

@Stable
class EdgeToEdgeBottomBarState(
    val navBarHeight: Dp,
    val initialOffsetLimitPx: Float,
    val bottomBarState: BottomBarState,
)

@Composable
fun rememberBottomBarState(
    initialHeightOffsetLimit: Float = Float.MAX_VALUE,
    initialHeightOffset: Float = 0f,
    initialContentOffset: Float = 0f
) = rememberSaveable(saver = BottomBarState.Saver) {
    BottomBarState(initialHeightOffsetLimit, initialHeightOffset, initialContentOffset)
}

@Stable
class BottomBarState(
    initialHeightOffsetLimit: Float,
    initialHeightOffset: Float,
    initialContentOffset: Float
) {

    var heightOffsetLimit by mutableStateOf(initialHeightOffsetLimit)
    var heightOffset: Float
        get() = _heightOffset.value
        set(newOffset) {
            _heightOffset.value = newOffset.coerceIn(
                minimumValue = 0f,
                maximumValue = heightOffsetLimit
            )
        }

    var contentOffset by mutableStateOf(initialContentOffset)
    val collapsedFraction: Float
        get() = if (heightOffsetLimit != 0f) {
            heightOffset / heightOffsetLimit
        } else {
            0f
        }

    companion object {
        val Saver: Saver<BottomBarState, *> = listSaver(
            save = { listOf(it.heightOffsetLimit, it.heightOffset, it.contentOffset) },
            restore = {
                BottomBarState(
                    initialHeightOffsetLimit = it[0],
                    initialHeightOffset = it[1],
                    initialContentOffset = it[2]
                )
            }
        )
    }

    private var _heightOffset = mutableStateOf(initialHeightOffset)
}
