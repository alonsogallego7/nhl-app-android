package com.alonsogp.nhl_app.features.standings.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.alonsogp.nhl_app.databinding.FragmentStandingsTypesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StandingsTypesFragment : Fragment() {

    private var binding: FragmentStandingsTypesBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStandingsTypesBinding.inflate(inflater)
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
                navigateToConferences(1)
            }
            cardview2.setOnClickListener {
                navigateToConferences(2)
            }
            cardview3.setOnClickListener {
                navigateToStandings(3)
            }
        }
    }

    private fun navigateToConferences(typeId: Int) {
        findNavController().navigate(
            StandingsTypesFragmentDirections.actionToStandingsConferenceFragment(typeId)
        )
    }

    private fun navigateToStandings(typeId: Int) {
        findNavController().navigate(
            StandingsTypesFragmentDirections.actionToStandingsFragment(typeId, 0)
        )
    }
}