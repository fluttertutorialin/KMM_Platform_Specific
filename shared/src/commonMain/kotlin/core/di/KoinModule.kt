package core.di

import getPlatform
import org.koin.core.context.startKoin
import repository.repositoryModule

fun initKoin() = startKoin {
    modules(
        listOf(
            networkModule,
            apiModule,
            repositoryModule,
            useCaseModule,
            mapperModule,
            *getPlatform().module.toTypedArray()
        )
    )
}