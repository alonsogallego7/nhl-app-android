package com.alonsogp.nhl_app.features.standings.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.alonsogp.nhl_app.databinding.FragmentStandingsBinding
import com.alonsogp.nhl_app.features.home.presentation.DivisionsViewModel
import com.alonsogp.nhl_app.features.home.presentation.TeamDetailViewModel
import com.alonsogp.nhl_app.features.home.presentation.TeamsFragmentArgs
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StandingsFragment: Fragment() {

    private var binding: FragmentStandingsBinding? = null
    private val viewModel by viewModels<StandingsViewModel>()
    private val args: StandingsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStandingsBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        viewModel.getStandings(args.typeId, args.conferenceId)
    }

    private fun setupObservers() {
        val newsFeedSubscriber =
            Observer<StandingsViewModel.UiState> { uiState ->
                uiState.error?.let { error ->
                    Log.d("@dev", "Error: $error")
                } ?: run {
                    uiState.records?.let { records ->
                        Log.d("@dev", "Records: $records")
                    }
                }
            }
        viewModel.uiState.observe(viewLifecycleOwner, newsFeedSubscriber)
    }
}