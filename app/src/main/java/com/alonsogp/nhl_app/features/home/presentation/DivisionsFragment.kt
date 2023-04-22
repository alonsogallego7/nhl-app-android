package com.alonsogp.nhl_app.features.home.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.alonsogp.nhl_app.R
import com.alonsogp.nhl_app.databinding.FragmentDivisionsBinding
import com.alonsogp.nhl_app.features.home.domain.DivisionModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DivisionsFragment: Fragment() {

    private var binding: FragmentDivisionsBinding? = null
    private val viewModel by viewModels<DivisionsViewModel>()
    private val args: DivisionsFragmentArgs by navArgs()

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
            if (args.conferenceId == 5) {
                cardview1.setOnClickListener {
                    navigateToTeams(15)
                }
                cardview2.setOnClickListener {
                    navigateToTeams(16)
                }
            } else {
                cardview1.setOnClickListener {
                    navigateToTeams(17)
                }
                cardview2.setOnClickListener {
                    navigateToTeams(18)
                }
            }
        }
    }

    private fun bind(division: DivisionModel) {
        binding?.apply {
            if (division.name == "Pacific" || division.name == "Atlantic") {
                cardview1Text.text = division.name + " Division"
            }
            if (division.name == "Central" || division.name == "Metropolitan") {
                cardview2Text.text = division.name + " Division"
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
                            Log.d("@dev", "Division: $division")
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