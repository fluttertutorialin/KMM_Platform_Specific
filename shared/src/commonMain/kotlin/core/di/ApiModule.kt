package core.di

import data.network.BaseApi
import data.network.products.ProductsApi
import org.koin.dsl.bind
import org.koin.dsl.module

val apiModule = module {
    factory { ProductsApi(get()) } bind BaseApi::class
}