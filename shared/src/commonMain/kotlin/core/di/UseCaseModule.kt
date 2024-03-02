package core.di

import domain.usecase.GetProductsUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory {
        GetProductsUseCase(
            repository = get()
        )
    }
}