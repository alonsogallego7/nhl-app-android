package com.alonsogp.nhl_app.features.standings.presentation

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
import com.alonsogp.nhl_app.databinding.FragmentStandingsBinding
import com.alonsogp.nhl_app.features.standings.presentation.adapter.StandingsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StandingsFragment : Fragment() {

    private var binding: FragmentStandingsBinding? = null
    private val viewModel by viewModels<StandingsViewModel>()
    private val args: StandingsFragmentArgs by navArgs()
    private val standingsAdapter = StandingsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStandingsBinding.inflate(inflater)
        setupView()
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        viewModel.getStandings(args.typeId)
    }

    private fun setupView() {
        binding?.apply {
            layoutToolbar.sectionToolbar.apply {
                if (args.typeId == 1) {
                    if (args.conferenceId == 5) {
                        title = "Western Conf."
                    } else {
                        title = "Eastern Conf."
                    }
                } else if (args.typeId == 2) {
                    if (args.conferenceId == 5) {
                        title = "Wild Card(West)"
                    } else {
                        title = "Wild Card(East)"
                    }
                } else {
                    title = "League"
                }
                setNavigationIcon(R.drawable.ic_back)
                setNavigationOnClickListener {
                    findNavController().navigateUp()
                }
            }
            listStandings.apply {
                adapter = standingsAdapter
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
            Observer<StandingsViewModel.UiState> { uiState ->
                uiState.error?.let { error ->
                    Log.d("@dev", "Error: $error")
                } ?: run {
                    uiState.records?.let { records ->
                        if (args.typeId == 1 || args.typeId == 2) {
                            if (args.conferenceId == 5) {
                                standingsAdapter.setDataItems(
                                    records[1].teamRecords
                                )
                            } else {
                                standingsAdapter.setDataItems(
                                    records[0].teamRecords
                                )
                            }
                        } else {
                            standingsAdapter.setDataItems(
                                records.first().teamRecords
                            )
                        }
                    }
                }
            }
        viewModel.uiState.observe(viewLifecycleOwner, newsFeedSubscriber)
    }
}