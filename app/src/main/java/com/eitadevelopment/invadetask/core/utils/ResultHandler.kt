package com.eitadevelopment.invadetask.core.utils

sealed class ResultHandler<out T> {
    data class Success<out R>(val data: R) : ResultHandler<R>()
    data class Failure(val exception: Exception) : ResultHandler<Nothing>()
}

inline fun <reified T> ResultHandler<T>.doIfFailure(callback: (error: Exception) -> Unit) {
    if (this is ResultHandler.Failure) {
        callback(exception)
    }
}

inline fun <reified T> ResultHandler<T>.doIfSuccess(callback: (data: T) -> Unit) {
    if (this is ResultHandler.Success) {
        callback(data)
    }
}