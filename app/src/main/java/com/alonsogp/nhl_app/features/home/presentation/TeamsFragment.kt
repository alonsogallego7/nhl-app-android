package com.alonsogp.nhl_app.features.home.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.alonsogp.nhl_app.R
import com.alonsogp.nhl_app.databinding.FragmentTeamsBinding
import com.alonsogp.nhl_app.features.home.presentation.adapter.TeamsAdapter
import com.faltenreich.skeletonlayout.Skeleton
import com.faltenreich.skeletonlayout.applySkeleton
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TeamsFragment: Fragment() {

    private var binding: FragmentTeamsBinding? = null
    private val viewModel by viewModels<TeamsViewModel>()
    private val args: TeamsFragmentArgs by navArgs()
    private val teamsAdapter = TeamsAdapter()
    private var skeleton: Skeleton? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTeamsBinding.inflate(inflater)
        setupView()
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        viewModel.getTeams(args.divisionId)
    }

    private fun setupView() {
        binding?.apply {
            layoutToolbar.sectionToolbar.apply {
                title = "Teams & Players"
                setNavigationOnClickListener {
                    findNavController().navigateUp()
                }
            }
            listTeams.apply {
                adapter = teamsAdapter
                layoutManager = LinearLayoutManager(
                    requireContext(),
                    LinearLayoutManager.VERTICAL,
                    false
                )
                skeleton = applySkeleton(R.layout.view_item_teams, 10)
            }
            teamsAdapter.setOnClickItem { teamId ->
                navigateToTeamDetail(teamId)
            }
        }
    }

    private fun setupObservers() {
        val newsFeedSubscriber =
            Observer<TeamsViewModel.UiState> { uiState ->
                uiState.error?.let { error ->
                    Log.d("@dev", "Error: $error")
                } ?: run {
                    uiState.teams?.let { teams ->
                        teamsAdapter.setDataItems(teams)
                    }
                }
            }
        viewModel.uiState.observe(viewLifecycleOwner, newsFeedSubscriber)
    }

    private fun navigateToTeamDetail(teamId: Int) {
        findNavController().navigate(
            TeamsFragmentDirections.actionToTeamDetailFragment(teamId)
        )
    }
}
