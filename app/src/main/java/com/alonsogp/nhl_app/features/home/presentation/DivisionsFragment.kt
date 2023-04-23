package com.alonsogp.nhl_app.features.home.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.alonsogp.nhl_app.R
import com.alonsogp.nhl_app.databinding.FragmentDivisionsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DivisionsFragment: Fragment() {

    private var binding: FragmentDivisionsBinding? = null
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
        bind()
    }

    private fun setupView() {
        binding?.apply {
            layoutToolbar.sectionToolbar.apply {
                if (args.conferenceId == 5) {
                    layoutToolbar.sectionToolbar.apply {
                        title = "Western Conf."
                    }
                } else {
                    layoutToolbar.sectionToolbar.apply {
                        title = "Eastern Conf."
                    }
                }
                setNavigationIcon(R.drawable.ic_back)
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

    private fun bind() {
        binding?.apply {
            if (args.conferenceId == 5) {
                cardview1Image.setImageResource(R.drawable.img_pacific_division)
                cardview1Text.text = "Pacific Division"
                cardview2Image.setImageResource(R.drawable.img_central_division)
                cardview2Text.text = "Central Division"
            } else {
                cardview1Image.setImageResource(R.drawable.img_atlantic_division)
                cardview1Text.text = "Atlantic Division"
                cardview2Image.setImageResource(R.drawable.img_metropolitan_division)
                cardview2Text.text = "Metropolitan Division"
            }
        }
    }

    private fun navigateToTeams(divisionId: Int) {
        findNavController().navigate(
            DivisionsFragmentDirections.actionToTeamsFragment(divisionId)
        )
    }
}