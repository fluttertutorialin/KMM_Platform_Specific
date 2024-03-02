package di

import data.mapper.ProductsSectionMapper
import org.koin.dsl.module

val mapperModule = module {
    factory { ProductsSectionMapper() }
}