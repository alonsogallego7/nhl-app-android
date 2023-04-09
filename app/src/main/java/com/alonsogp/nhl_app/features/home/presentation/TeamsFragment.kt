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
import com.alonsogp.nhl_app.databinding.FragmentTeamsBinding
import com.faltenreich.skeletonlayout.Skeleton
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TeamsFragment: Fragment() {

    private var teamsFragmentBinding: FragmentTeamsBinding? = null
    private val viewModel by viewModels<TeamsViewModel>()
    private val args: TeamsFragmentArgs by navArgs()
    private var skeleton: Skeleton? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        teamsFragmentBinding = FragmentTeamsBinding.inflate(inflater)
        return teamsFragmentBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        viewModel.getTeams(args.divisionId)
    }

    private fun setupObservers() {
        val newsFeedSubscriber =
            Observer<TeamsViewModel.UiState> { uiState ->
                uiState.error?.let { error ->
                    Log.d("@dev", "Error: $error")
                } ?: run {
                    uiState.teams?.let { teams ->
                        Log.d("@dev", "Teams: $teams")
                    }
                }
            }
        viewModel.uiState.observe(viewLifecycleOwner, newsFeedSubscriber)
    }
}
