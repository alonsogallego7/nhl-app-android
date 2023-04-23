package com.alonsogp.nhl_app.app.presentation.error

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.alonsogp.nhl_app.databinding.FragmentErrorBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
open class ErrorAppFragment @Inject constructor() : Fragment() {

    private var binding: FragmentErrorBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentErrorBinding.inflate(inflater)
        buttonNavigate()
        return binding?.root
    }

    protected fun setErrorTitle(title: String) {
        binding?.apply {
            errorTitle.text = title
        }
    }

    protected fun setErrorDescription(description: String) {
        binding?.apply {
            errorText.text = description
        }
    }

    private fun buttonNavigate() {
        binding?.apply {
            errorButton.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }
}