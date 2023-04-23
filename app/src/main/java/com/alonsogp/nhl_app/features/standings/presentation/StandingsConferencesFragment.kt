package com.alonsogp.nhl_app.features.standings.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.alonsogp.nhl_app.R
import com.alonsogp.nhl_app.databinding.FragmentConferencesBinding

class StandingsConferencesFragment : Fragment() {

    private var binding: FragmentConferencesBinding? = null
    private val args: StandingsConferencesFragmentArgs by navArgs()

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
                if (args.typeId == 1) {
                    title = "By Conference"
                } else if (args.typeId == 2) {
                    title = "Wild Card"
                }
                setNavigationIcon(R.drawable.ic_back)
                setNavigationOnClickListener {
                    findNavController().navigateUp()
                }
            }
            cardview1.setOnClickListener {
                navigateToStandings(args.typeId, 5)
            }
            cardview2.setOnClickListener {
                navigateToStandings(args.typeId, 6)
            }
        }
    }

    private fun navigateToStandings(typeId: Int, conferenceId: Int) {
        findNavController().navigate(
            StandingsConferencesFragmentDirections.actionToStandingsFragment(typeId, conferenceId)
        )
    }
}