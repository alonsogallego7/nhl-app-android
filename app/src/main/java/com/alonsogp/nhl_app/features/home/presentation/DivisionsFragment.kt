package com.alonsogp.nhl_app.features.home.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.alonsogp.nhl_app.databinding.FragmentDivisionsBinding
import com.faltenreich.skeletonlayout.Skeleton
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DivisionsFragment: Fragment() {

    private var divisionsFragmentBinding: FragmentDivisionsBinding? = null
    private val viewModel by viewModels<DivisionsViewModel>()
    private var skeleton: Skeleton? = null
    private val args: DivisionsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        divisionsFragmentBinding = FragmentDivisionsBinding.inflate(inflater)
        return divisionsFragmentBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        viewModel.getDivisions(args.conferenceId)
    }

    private fun setupObservers() {
        val newsFeedSubscriber =
            Observer<DivisionsViewModel.UiState> { uiState ->
                uiState.error?.let { error ->
                    Log.d("@dev", "Error: $error")
                } ?: run {
                    uiState.divisions?.let { divisions ->
                        Log.d("@dev", "Divisions: $divisions")
                    }
                }
            }
        viewModel.uiState.observe(viewLifecycleOwner, newsFeedSubscriber)
    }
}