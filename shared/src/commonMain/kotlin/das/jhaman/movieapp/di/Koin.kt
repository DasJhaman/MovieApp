package das.jhaman.movieapp.di

import das.jhaman.moviedbapp.BuildKonfig
import io.ktor.client.HttpClient
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import das.jhaman.movieapp.data.MoviesApi
import das.jhaman.movieapp.data.repo.MoviesRepository
import das.jhaman.movieapp.domain.DiscoverMoviesUseCase
import das.jhaman.movieapp.domain.PopularMoviesUseCase
import org.koin.core.module.dsl.factoryOf
import das.jhaman.movieapp.ui.home.HomeViewModel

fun initKoin(additionalModules: List<Module>): KoinApplication {
    return startKoin {
        modules(
            additionalModules
                    + coreModule
                    + platformModule
                    + viewModelModule
                    + useCaseModule
                    + apiModule
                    + repositoryModule
        )
    }
}

private val coreModule = module {
    single {
        HttpClient(engine = get()) {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                })
            }
            defaultRequest {
                url(BuildKonfig.API_BASE_URL)
            }

            install(Auth) {
                bearer {
                    loadTokens {
                        BearerTokens(BuildKonfig.AUTH_TOKEN, "")
                    }
                }
            }

            install(Logging) {
                level = LogLevel.ALL
                logger = object : Logger {
                    override fun log(message: String) {
                        co.touchlab.kermit.Logger.i { message }
                    }
                }
            }
        }
    }

}

private val viewModelModule = module {
    factoryOf(::HomeViewModel)
}

private val useCaseModule = module {
    singleOf(::DiscoverMoviesUseCase)
    singleOf(::PopularMoviesUseCase)
}

private val repositoryModule = module {
    singleOf(::MoviesRepository)
}

private val apiModule = module {
    singleOf(::MoviesApi)
}

expect val platformModule: Module