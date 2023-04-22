package com.alonsogp.nhl_app.features.stats.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.alonsogp.nhl_app.databinding.FragmentStatsBinding
import com.alonsogp.nhl_app.databinding.FragmentStatsTypesBinding
import com.alonsogp.nhl_app.features.home.presentation.DivisionsFragmentDirections
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StatsTypesFragment : Fragment() {

    private var binding: FragmentStatsTypesBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStatsTypesBinding.inflate(inflater)
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
        }
    }

    private fun navigateToStats(typeId: Int) {

    }
}