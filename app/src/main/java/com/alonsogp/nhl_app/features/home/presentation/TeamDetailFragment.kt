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
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.alonsogp.nhl_app.R
import com.alonsogp.nhl_app.databinding.FragmentTeamDetailBinding
import com.alonsogp.nhl_app.features.home.domain.DivisionModel
import com.alonsogp.nhl_app.features.home.domain.TeamDetailModel
import com.alonsogp.nhl_app.features.home.domain.TeamDetailWithRosterModel
import com.alonsogp.nhl_app.features.home.presentation.adapter.PlayersAdapter
import com.alonsogp.nhl_app.features.home.presentation.adapter.TeamsAdapter
import com.faltenreich.skeletonlayout.Skeleton
import com.faltenreich.skeletonlayout.applySkeleton
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TeamDetailFragment: Fragment() {

    private var binding: FragmentTeamDetailBinding? = null
    private val viewModel by viewModels<TeamDetailViewModel>()
    private val args: TeamDetailFragmentArgs by navArgs()
    private val playersAdapter = PlayersAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTeamDetailBinding.inflate(inflater)
        setupView()
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        viewModel.getTeamDetail(args.teamId)
    }

    private fun setupView() {
        binding?.apply {
            layoutToolbar.sectionToolbar.apply {
                title = "Teams & Players"
                setNavigationOnClickListener {
                    findNavController().navigateUp()
                }
            }
            listPlayers.apply {
                adapter = playersAdapter
                layoutManager = LinearLayoutManager(
                    requireContext(),
                    LinearLayoutManager.VERTICAL,
                    false
                )
            }
        }
    }

    private fun bind(teamDetail: TeamDetailWithRosterModel) {
        binding?.apply {
            teamName.text = teamDetail.name
            teamAbbreviation.text = teamDetail.abbreviation
            teamArena.text = teamDetail.venue.name
            teamCity.text = teamDetail.venue.city
            foundationYear.text = teamDetail.firstYearOfPlay
        }
    }

    private fun setupObservers() {
        val teamSubscriber =
            Observer<TeamDetailViewModel.UiState> { uiState ->
                uiState.error?.let { error ->
                    Log.d("@dev", "Error: $error")
                } ?: run {
                    uiState.teamDetail?.let { team ->
                        bind(team)
                        playersAdapter.setDataItems(team.roster)
                    }
                }
            }
        viewModel.uiState.observe(viewLifecycleOwner, teamSubscriber)
    }
}
