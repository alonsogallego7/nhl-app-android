package com.alonsogp.nhl_app.features.teams.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.alonsogp.nhl_app.databinding.FragmentConferencesBinding
import com.faltenreich.skeletonlayout.Skeleton
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConferencesFragment : Fragment() {

    private var conferencesFragmentBinding: FragmentConferencesBinding? = null
    private val viewModel by viewModels<ConferencesViewModel>()
    private var skeleton: Skeleton? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        conferencesFragmentBinding = FragmentConferencesBinding.inflate(inflater)
        return conferencesFragmentBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        viewModel.getConferences()
    }

    private fun setupObservers() {
        val newsFeedSubscriber =
            Observer<ConferencesViewModel.UiState> { uiState ->
                uiState.error?.let { error ->
                    Log.d("@dev", "Error: $error")
                } ?: run {
                    uiState.conferences?.let { conferences ->
                        Log.d("@dev", "Conferences: $conferences")
                    }
                }
            }
        viewModel.uiState.observe(viewLifecycleOwner, newsFeedSubscriber)
    }
}