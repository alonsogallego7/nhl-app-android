package com.alonsogp.nhl_app.app.presentation.error

import android.os.Bundle
import android.view.View
import com.alonsogp.nhl_app.R
import com.alonsogp.nhl_app.app.presentation.error.ErrorAppFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UnknownErrorFragment : ErrorAppFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val errorDescription = "Oops! It seems like an unknown error has occurred. Please, restart the app or try again later."
        val errorTitle = "Error: Unknown"

        setErrorDescription(errorDescription)
        setErrorTitle(errorTitle)
    }
}