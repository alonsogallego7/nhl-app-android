package com.alonsogp.nhl_app.app.presentation.error

import android.os.Bundle
import android.view.View
import com.alonsogp.nhl_app.R
import com.alonsogp.nhl_app.app.presentation.error.ErrorAppFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoInternetErrorFragment : ErrorAppFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val errorDescription = "Oops! It seems like you do not have internet connection. Please, check your connection and try again."
        val errorTitle = "Error: No Internet"

        setErrorDescription(errorDescription)
        setErrorTitle(errorTitle)
    }
}