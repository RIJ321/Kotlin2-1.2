package com.example.kotlin2_12.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.kotlin2_12.R
import com.example.kotlin2_12.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setTheme(R.style.Theme_Kotlin212)
        setContentView(binding.root)
        binding.menuBottom.itemIconTintList = null

        initNavigation()
        setNavTitle()
    }

    private fun initNavigation() {
/*
        navController = Navigation.findNavController(this, R.id.nav_host)
        NavigationUI.setupWithNavController(binding.menuBottom, navController)
*/
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        navController = navHostFragment.navController
        NavigationUI.setupWithNavController(binding.menuBottom, navController)

    }

    private fun setNavTitle() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.mainFragment -> {
                    binding.actionBar.text = "Quiz"
                }
                R.id.settingsFragment -> {
                    binding.actionBar.text = "Settings"
                }
                R.id.historyFragment -> {
                    binding.actionBar.text = "History"
                }
            }
        }
    }
}