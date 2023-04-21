package com.alonsogp.nhl_app.features.stats.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.alonsogp.nhl_app.databinding.FragmentStatsBinding
import com.alonsogp.nhl_app.features.home.presentation.DivisionsFragmentDirections
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StatsFragment: Fragment() {

    private var binding: FragmentStatsBinding? = null
    private val viewModel by viewModels<StatsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStatsBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        viewModel.getStats()
    }

    /*private fun setupView() {
        binding?.apply {
            layoutToolbar.sectionToolbar.apply {
                title = "Stats"
                setNavigationOnClickListener {
                    findNavController().navigateUp()
                }
            }
        }
    }*/

    private fun setupObservers() {
        val newsFeedSubscriber =
            Observer<StatsViewModel.UiState> { uiState ->
                uiState.error?.let { error ->
                    Log.d("@dev", "Error: $error")
                } ?: run {
                    uiState.playersWithStats?.let { playersWithStats ->
                        playersWithStats.map { playerWithStats ->
                            Log.d("@dev", "Player: $playerWithStats")
                        }
                    }
                }
            }
        viewModel.uiState.observe(viewLifecycleOwner, newsFeedSubscriber)
    }

    private fun navigateToTeams(divisionId: Int) {
        findNavController().navigate(
            DivisionsFragmentDirections.actionToTeamsFragment(divisionId)
        )
    }
}