package data.network

import io.ktor.client.HttpClient

abstract class BaseApi(
    protected val client: HttpClient
)