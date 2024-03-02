package repository.products

import kotlinx.coroutines.CoroutineDispatcher
import data.network.products.ProductsApi
import data.model.ProductResponse
import repository.BaseRepository

abstract class ProductsRepository(
    coroutineDispatcher: CoroutineDispatcher,
) : BaseRepository(coroutineDispatcher) {
    abstract suspend fun getProducts(): Result<List<ProductResponse>>
}

class ProductRepositoryImpl(
    coroutineDispatcher: CoroutineDispatcher,
    private val productsApi: ProductsApi
) : ProductsRepository(coroutineDispatcher) {
    override suspend fun getProducts(): Result<List<ProductResponse>> =
        toResult(productsApi.getProducts())
}

