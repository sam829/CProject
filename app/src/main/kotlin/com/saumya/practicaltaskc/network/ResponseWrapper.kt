package com.saumya.practicaltaskc.network

import retrofit2.Response

sealed class ResponseWrapper<T> {
    data class Success<T>(val data: T) : ResponseWrapper<T>()
    data class Failure<T>(val message: String?) : ResponseWrapper<T>()
}

@Suppress("REDUNDANT_INLINE_SUSPEND_FUNCTION_TYPE")
suspend inline fun <reified T> safeNetworkCall(networkCall: suspend () -> Response<T>): ResponseWrapper<T> {
    return try {
        val response = networkCall()
        if (response.isSuccessful && response.body() != null) {
            ResponseWrapper.Success(data = response.body()!!)
        } else {
            ResponseWrapper.Failure(message = "Something went wrong")
        }
    } catch (e: Throwable) {
        ResponseWrapper.Failure(message = e.message)
    }
}

suspend inline fun <T> ResponseWrapper<T>.suspendOnSuccess(
    crossinline onResult: suspend ResponseWrapper.Success<T>.() -> Unit
): ResponseWrapper<T> {
    if (this is ResponseWrapper.Success<T>) {
        onResult(this)
    }
    return this
}

suspend inline fun <T> ResponseWrapper<T>.suspendOnFailure(
    crossinline onResult: suspend ResponseWrapper.Failure<T>.() -> Unit
): ResponseWrapper<T> {
    if (this is ResponseWrapper.Failure<T>) {
        onResult(this)
    }
    return this
}