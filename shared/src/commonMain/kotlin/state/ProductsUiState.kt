package state

import data.componentdata.ProductComponentData

data class ProductsUiState(
    val products: List<ProductComponentData> = listOf()
)
