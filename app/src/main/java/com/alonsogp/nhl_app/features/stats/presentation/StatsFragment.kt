package com.alonsogp.nhl_app.features.stats.presentation

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
import com.alonsogp.nhl_app.features.home.presentation.DivisionsFragmentArgs
import com.alonsogp.nhl_app.features.home.presentation.DivisionsFragmentDirections
import com.alonsogp.nhl_app.features.home.presentation.DivisionsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StatsFragment: Fragment() {

    private var binding: FragmentDivisionsBinding? = null
    private val viewModel by viewModels<StatsViewModel>()

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
    }

    private fun setupView() {
        binding?.apply {
            layoutToolbar.sectionToolbar.apply {
                title = "Stats"
                setNavigationOnClickListener {
                    findNavController().navigateUp()
                }
            }
        }
    }

    private fun setupObservers() {
        val newsFeedSubscriber =
            Observer<StatsViewModel.UiState> { uiState ->
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