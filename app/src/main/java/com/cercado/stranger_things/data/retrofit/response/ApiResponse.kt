package com.cercado.stranger_things.data.retrofit.response

sealed class ApiResponse<T>(data: T? = null, exception: java.lang.Exception? = null) {
    data class  Success<T>(val data: T): ApiResponse<T>(data)
    data class Error<T>(val exception: Exception): ApiResponse<T>(null,exception)
}
