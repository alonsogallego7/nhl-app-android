package com.alonsogp.nhl_app.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.alonsogp.nhl_app.NavGraphDirections
import com.alonsogp.nhl_app.R
import com.alonsogp.nhl_app.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
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
                R.id.stats_button -> {
                    navigateToStatsTypesFragment()
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

    private fun navigateToStatsTypesFragment() {
        findNavController(R.id.nav_host_fragment).navigate(
            NavGraphDirections.actionToStatsTypesSection()
        )
    }
}