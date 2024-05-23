package com.example.prepopulateddb.Utils

sealed class DataHandler<T>(
    val data: T? = null, val message: String? = null
) {
    class Success<T>(data: T) : DataHandler<T>(data)
    class Error<T>(message: String?, data: T? = null) : DataHandler<T>(data, message)
    class Loading<T> : DataHandler<T>()

}
