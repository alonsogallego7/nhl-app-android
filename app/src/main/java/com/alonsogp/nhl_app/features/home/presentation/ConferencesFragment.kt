package com.alonsogp.nhl_app.features.home.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.alonsogp.nhl_app.databinding.FragmentConferencesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConferencesFragment : Fragment() {

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
                title = "Teams & Players"
                setNavigationOnClickListener {
                    findNavController().navigateUp()
                }
            }
            cardview1.setOnClickListener {
                navigateToDivisions(5)
            }
            cardview2.setOnClickListener {
                navigateToDivisions(6)
            }
        }
    }

    private fun navigateToDivisions(conferenceId: Int) {
        findNavController().navigate(
            ConferencesFragmentDirections.actionToDivisionsFragment(conferenceId)
        )
    }
}