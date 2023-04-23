package com.alonsogp.nhl_app.app.extensions

import android.app.Activity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.alonsogp.nhl_app.R

fun Activity.navController(): NavController =
    Navigation.findNavController(this, R.id.nav_host_fragment)