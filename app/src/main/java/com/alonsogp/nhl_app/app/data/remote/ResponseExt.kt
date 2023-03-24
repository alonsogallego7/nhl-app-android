package com.alonsogp.nhl_app.app.data.remote

import com.alonsogp.nhl_app.app.domain.ErrorApp
import com.alonsogp.nhl_app.app.domain.functional.Either
import com.alonsogp.nhl_app.app.domain.functional.left
import com.alonsogp.nhl_app.app.domain.functional.right
import retrofit2.Response
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

suspend fun <T : Any> apiCall(call: suspend () -> Response<T>): Either<ErrorApp, T> {
    val response: Response<T>
    try {
        response = call.invoke()
    } catch (exception: Throwable) {
        return when (exception) {
            is ConnectException -> ErrorApp.NoInternetError.left()
            is UnknownHostException -> ErrorApp.NoInternetError.left()
            is SocketTimeoutException -> ErrorApp.TimeOutError.left()
            else -> ErrorApp.UnKnowError.left()
        }
    }
    if (!response.isSuccessful) {
        return ErrorApp.UnKnowError.left()
    }
    return response.body()!!.right()
}