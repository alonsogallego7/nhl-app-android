package com.alonsogp.nhl_app.features.home.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.alonsogp.nhl_app.databinding.FragmentTeamDetailBinding
import com.faltenreich.skeletonlayout.Skeleton
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TeamDetailFragment: Fragment() {

    private var teamDetailFragmentBinding: FragmentTeamDetailBinding? = null
    private val viewModel by viewModels<TeamDetailViewModel>()
    private var skeleton: Skeleton? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        teamDetailFragmentBinding = FragmentTeamDetailBinding.inflate(inflater)
        return teamDetailFragmentBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        viewModel.getTeamDetail(12)
    }

    private fun setupObservers() {
        val teamSubscriber =
            Observer<TeamDetailViewModel.UiState> { uiState ->
                uiState.error?.let { error ->
                    Log.d("@dev", "Error: $error")
                } ?: run {
                    uiState.teamDetail?.let { team ->
                        Log.d("@dev", "Team: $team")
                    }
                }
            }
        viewModel.uiState.observe(viewLifecycleOwner, teamSubscriber)
    }
}
