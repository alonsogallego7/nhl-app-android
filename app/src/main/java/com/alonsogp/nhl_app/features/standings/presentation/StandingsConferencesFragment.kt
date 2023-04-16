package com.alonsogp.nhl_app.features.standings.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.alonsogp.nhl_app.databinding.FragmentConferencesBinding
import com.alonsogp.nhl_app.features.home.presentation.ConferencesFragmentDirections

class StandingsConferencesFragment : Fragment() {

    private var binding: FragmentConferencesBinding? = null

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
    }

    private fun setupView() {
        binding?.apply {
            layoutToolbar.sectionToolbar.apply {
                title = "Standings"
                setNavigationOnClickListener {
                    findNavController().navigateUp()
                }
            }
            cardview1.setOnClickListener {
                navigateToStandings(5)
            }
            cardview2.setOnClickListener {
                navigateToStandings(6)
            }
        }
    }

    private fun navigateToStandings(conferenceId: Int) {
        findNavController().navigate(
            StandingsConferencesFragmentDirections.actionToStandingsFragment(1, conferenceId)
        )
    }
}