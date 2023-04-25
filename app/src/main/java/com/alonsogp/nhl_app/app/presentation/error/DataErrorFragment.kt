package com.alonsogp.nhl_app.app.presentation.error

import android.os.Bundle
import android.view.View
import com.alonsogp.nhl_app.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DataErrorFragment : ErrorAppFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val errorDescription = "Oops! It seems like an unknown error has occurred. Please, try again or restart the app."
        val errorTitle = "Error: Unknown"

        setErrorDescription(errorDescription)
        setErrorTitle(errorTitle)
    }
}