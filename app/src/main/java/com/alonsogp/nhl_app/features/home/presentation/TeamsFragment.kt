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
import com.alonsogp.nhl_app.app.presentation.error.AppErrorHandler
import com.alonsogp.nhl_app.databinding.FragmentTeamsBinding
import com.alonsogp.nhl_app.features.home.presentation.adapter.TeamsAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class TeamsFragment : Fragment() {

    private var binding: FragmentTeamsBinding? = null
    private val viewModel by viewModels<TeamsViewModel>()
    private val args: TeamsFragmentArgs by navArgs()
    private val teamsAdapter = TeamsAdapter()

    @Inject
    lateinit var appErrorHandler: AppErrorHandler

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
                if (args.divisionId == 17) {
                    title = "Atlantic Div."
                } else if (args.divisionId == 16) {
                    title = "Central Div."
                } else if (args.divisionId == 18) {
                    title = "Metropolitan Div."
                } else {
                    title = "Pacific Div."
                }
                setNavigationIcon(R.drawable.ic_back)
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
                    appErrorHandler.navigateToError(error)
                } ?: run {
                    if (uiState.isLoading) {
                        showLoading()
                    } else {
                        hideLoading()
                        uiState.teams?.let { teams ->
                            teamsAdapter.setDataItems(teams)
                        }
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

    private fun showLoading() {
        binding?.loadingView?.show()
    }

    private fun hideLoading() {
        binding?.loadingView?.hide()
    }
}
