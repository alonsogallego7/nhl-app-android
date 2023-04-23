package com.alonsogp.nhl_app.features.stats.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.alonsogp.nhl_app.databinding.FragmentStatsTypesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StatsTypesFragment : Fragment() {

    private var binding: FragmentStatsTypesBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStatsTypesBinding.inflate(inflater)
        setupView()
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setupView() {
        binding?.apply {
            layoutToolbar.sectionToolbar.apply {
                title = "Stats"
                setNavigationOnClickListener {
                    findNavController().navigateUp()
                }
            }
            cardview1.setOnClickListener {
                navigateToStats(1)
            }
            cardview2.setOnClickListener {
                navigateToStats(2)
            }
            cardview3.setOnClickListener {
                navigateToStats(3)
            }
        }
    }

    private fun navigateToStats(typeId: Int) {
        findNavController().navigate(
            StatsTypesFragmentDirections.actionToStatsFragment(typeId)
        )
    }
}