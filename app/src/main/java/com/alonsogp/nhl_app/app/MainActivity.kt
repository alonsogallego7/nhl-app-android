package com.alonsogp.nhl_app.app

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.transition.Fade
import androidx.transition.TransitionManager
import com.alonsogp.nhl_app.NavGraphDirections
import com.alonsogp.nhl_app.R
import com.alonsogp.nhl_app.databinding.ActivityMainBinding
import com.alonsogp.nhl_app.features.home.presentation.ConferencesFragmentDirections
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity: AppCompatActivity() {
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        setupNavigation()
    }

    private fun setupBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
    }

    private fun setupNavigation() {
        binding!!.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.conferences_button -> {
                    navigateToConferencesFragment()
                    true
                }
                R.id.standings_button -> {
                    navigateToStandingTypesFragment()
                    true
                }
                else -> false
            }
        }
    }

    private fun navigateToConferencesFragment() {
        findNavController(R.id.nav_host_fragment).navigate(
            NavGraphDirections.actionToConferencesSection()
        )
    }

    private fun navigateToStandingTypesFragment() {
        findNavController(R.id.nav_host_fragment).navigate(
            NavGraphDirections.actionToStandingsTypesSection()
        )
    }
}