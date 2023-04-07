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
import com.alonsogp.nhl_app.R
import com.alonsogp.nhl_app.databinding.FragmentConferencesBinding
import com.alonsogp.nhl_app.features.home.domain.ConferenceModel
import com.faltenreich.skeletonlayout.Skeleton
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConferencesFragment : Fragment() {

    private var binding: FragmentConferencesBinding? = null
    private val viewModel by viewModels<ConferencesViewModel>()
    private var skeleton: Skeleton? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentConferencesBinding.inflate(inflater)
        setupView()
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        viewModel.getConferences()
    }

    private fun setupView() {
        binding?.apply {
            layoutToolbar.sectionToolbar.apply {
                title = "Teams & Players"
                setNavigationOnClickListener {
                    findNavController().navigateUp()
                }
            }
            westernCard.setOnClickListener {
                navigateToDivisions(5)
            }
            easternCard.setOnClickListener {
                navigateToDivisions(6)
            }
        }
    }

    private fun bind(conference: ConferenceModel) {
        binding?.apply {
            if (conference.name == "Western") {
                cardview1Text.text = conference.name + " Conference"
            } else {
                cardview2Text.text = conference.name + " Conference"
            }
            layoutToolbar.sectionToolbar.apply {
                title = "Teams & Players"
            }
        }

    }

    private fun setupObservers() {
        val newsFeedSubscriber =
            Observer<ConferencesViewModel.UiState> { uiState ->
                uiState.error?.let { error ->
                    Log.d("@dev", "Error: $error")
                } ?: run {
                    uiState.conferences?.let { conferences ->
                        conferences.map { conference ->
                            bind(conference)
                        }
                    }
                }
            }
        viewModel.uiState.observe(viewLifecycleOwner, newsFeedSubscriber)
    }

    private fun navigateToDivisions(conferenceId: Int) {
        findNavController().navigate(
            ConferencesFragmentDirections.actionToDivisionsFragment(conferenceId)
        )
    }
}