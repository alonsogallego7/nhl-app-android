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
import com.alonsogp.nhl_app.databinding.FragmentDivisionsBinding
import com.alonsogp.nhl_app.features.home.domain.DivisionModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DivisionsFragment: Fragment() {

    private var binding: FragmentDivisionsBinding? = null
    private val viewModel by viewModels<DivisionsViewModel>()
    private val args: DivisionsFragmentArgs by navArgs()
    private var divisions: List<DivisionModel>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDivisionsBinding.inflate(inflater)
        setupView()
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        viewModel.getDivisions(args.conferenceId)
    }

    private fun setupView() {
        binding?.apply {
            layoutToolbar.sectionToolbar.apply {
                title = "Teams & Players"
                setNavigationOnClickListener {
                    findNavController().navigateUp()
                }
            }
            cardview1.setOnClickListener {
                divisions?.map { division ->
                    if (division.name == "Pacific") {
                        navigateToTeams(15)
                    } else navigateToTeams(16)
                }
            }
            cardview2.setOnClickListener {
                divisions?.map { division ->
                    if (division.name == "Atlantic") {
                        navigateToTeams(17)
                    } else navigateToTeams(18)
                }
            }
        }
    }

    private fun bind(division: DivisionModel) {
        binding?.apply {
            if (division.name == "Pacific" || division.name == "Central") {
                cardview1Text.text = division.name + " Division"
            }
            if (division.name == "Atlantic" || division.name == "Metropolitan") {
                cardview2Text.text = division.name + " Division"
            }
            layoutToolbar.sectionToolbar.apply {
                title = "Teams & Players"
            }
        }
    }

    private fun setupObservers() {
        val newsFeedSubscriber =
            Observer<DivisionsViewModel.UiState> { uiState ->
                uiState.error?.let { error ->
                    Log.d("@dev", "Error: $error")
                } ?: run {
                    uiState.divisions?.let { divisions ->
                        divisions.map { division ->
                            bind(division)
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