package data.network.products

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.http.ContentType
import io.ktor.http.contentType
import data.network.BaseApi
import data.model.ProductResponse

class ProductsApi(httpClient: HttpClient) : BaseApi(httpClient) {

    suspend fun getProducts(): List<ProductResponse> = client.post(
        "/api/giveaways?platform=steam&type=loot&sort-by=popularity"
    ) {
        contentType(ContentType.Application.Json)
    }.body()

}