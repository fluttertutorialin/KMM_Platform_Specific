package viewmodel

import com.rickclephas.kmm.viewmodel.coroutineScope
import data.mapper.ProductsSectionMapper
import domain.usecase.GetProductsUseCase
import event.ProductsEvent
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import navigationargs.ProductViewArgs
import state.BaseUiState
import state.ProductsUiState

open class ProductsViewModel(
    private val getProductsUseCase: GetProductsUseCase,
    private val productsSectionMapper: ProductsSectionMapper
) : BaseViewModel<ProductsUiState, ProductsEvent>() {
    init {
        getProducts()
    }

    private fun getProducts() {
        viewModelScope.coroutineScope.launch {
            _uiState.update { BaseUiState.LoadingUiState() }
            try {
                getProductsUseCase.invoke(Unit).getOrThrow().also { result ->
                    _uiState.update {
                        BaseUiState.SuccessUiState(
                            ProductsUiState(
                                products = productsSectionMapper.map(result)
                            )
                        )
                    }
                }
            } catch (e: Exception) {
                _uiState.update { BaseUiState.ErrorUiState(e) { getProducts() } }
            }

        }
    }

    fun onProductComponentClicked(data: ProductViewArgs) {
        viewModelScope.coroutineScope.launch {
            _events.emit(ProductsEvent.NavigateToProductViewScreen(data))
        }
    }
}