package com.alonsogp.nhl_app.app.domain

sealed class ErrorApp {
    object DataError : ErrorApp()
    object NoInternetError : ErrorApp()
    object TimeOutError : ErrorApp()
    object UnKnowError : ErrorApp()
}