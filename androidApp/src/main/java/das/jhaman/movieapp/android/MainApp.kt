package das.jhaman.movieapp.android

import android.app.Application
import android.content.Context
import das.jhaman.movieapp.di.initKoin
import org.koin.dsl.module

class MainApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin(
            additionalModules = listOf(
                module {
                    single<Context> { this@MainApp }
                }
            )
        )
    }
}