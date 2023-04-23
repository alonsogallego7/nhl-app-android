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
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.alonsogp.nhl_app.R
import com.alonsogp.nhl_app.app.presentation.error.AppErrorHandler
import com.alonsogp.nhl_app.databinding.FragmentStatsBinding
import com.alonsogp.nhl_app.features.stats.presentation.adapter.StatsAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class StatsFragment : Fragment() {

    private var binding: FragmentStatsBinding? = null
    private val viewModel by viewModels<StatsViewModel>()
    private val args: StatsFragmentArgs by navArgs()
    private val statsAdapter = StatsAdapter()

    @Inject
    lateinit var appErrorHandler: AppErrorHandler

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStatsBinding.inflate(inflater)
        setupView()
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()

        if (args.typeId == 1) {
            viewModel.getGoalsPerGame()
        } else if (args.typeId == 2) {
            viewModel.getShotsPerGame()
        } else viewModel.getShootingPctgPerGame()
    }

    private fun setupView() {
        binding?.apply {
            layoutToolbar.sectionToolbar.apply {
                if (args.typeId == 1) {
                    title = "Goals per game"
                } else if (args.typeId == 2) {
                    title = "Shots per game"
                } else {
                    title = "Shooting %"
                }
                setNavigationIcon(R.drawable.ic_back)
                setNavigationOnClickListener {
                    findNavController().navigateUp()
                }
            }
            listStats.apply {
                adapter = statsAdapter
                layoutManager = LinearLayoutManager(
                    requireContext(),
                    LinearLayoutManager.VERTICAL,
                    false
                )
            }
        }
    }

    private fun setupObservers() {
        val newsFeedSubscriber =
            Observer<StatsViewModel.UiState> { uiState ->
                uiState.error?.let { error ->
                    appErrorHandler.navigateToError(error)
                } ?: run {
                    if (uiState.isLoading) {
                        showLoading()
                    } else {
                        hideLoading()
                        uiState.teams?.let { teams ->
                            statsAdapter.setDataItems(teams)
                        }
                    }
                }
            }
        viewModel.uiState.observe(viewLifecycleOwner, newsFeedSubscriber)
    }

    private fun showLoading() {
        binding?.loadingView?.show()
    }

    private fun hideLoading() {
        binding?.loadingView?.hide()
    }
}