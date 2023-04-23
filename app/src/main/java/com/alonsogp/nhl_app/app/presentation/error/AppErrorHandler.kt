package com.alonsogp.nhl_app.app.presentation.error

import android.content.Context
import com.alonsogp.nhl_app.NavGraphDirections
import com.alonsogp.nhl_app.app.MainActivity
import com.alonsogp.nhl_app.app.domain.ErrorApp
import com.alonsogp.nhl_app.app.extensions.navController
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

class AppErrorHandler @Inject constructor(@ActivityContext private val context: Context) {

    fun navigateToError(errorApp: ErrorApp) {
        when (errorApp) {
            is ErrorApp.DataError -> (context as MainActivity).navController()
                .navigate(NavGraphDirections.actionToDataError())
            is ErrorApp.NoInternetError -> (context as MainActivity).navController()
                .navigate(NavGraphDirections.actionToNoInternetError())
            else -> (context as MainActivity).navController()
                .navigate(NavGraphDirections.actionToUnknownError())
        }
    }
}