package com.android.wedyne.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.android.wedyne.R
import com.android.wedyne.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setUpFields()
        setUpNavigation()

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.foodFragment -> binding.bottomNavigationView.visibility = View.GONE
                R.id.sign_up -> binding.bottomNavigationView.visibility = View.GONE
                R.id.log_in -> binding.bottomNavigationView.visibility = View.GONE
                R.id.otp-> binding.bottomNavigationView.visibility = View.GONE
                else -> binding.bottomNavigationView.visibility = View.VISIBLE
            }
        }

    }

    private fun setUpFields() {
        bottomNavigationView = binding.bottomNavigationView
        navController = this.findNavController(R.id.nav_host_fragment)
    }

    private fun setUpNavigation() {
        bottomNavigationView.setupWithNavController(navController)
    }

}
