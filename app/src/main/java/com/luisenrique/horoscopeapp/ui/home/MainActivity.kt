package com.luisenrique.horoscopeapp.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.luisenrique.horoscopeapp.R
import com.luisenrique.horoscopeapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initLoadAds()
        initUI()
    }

    private fun initUI() {
        initNavigation()
    }

    private fun initLoadAds() {
        val adRequest = com.google.android.gms.ads.AdRequest.Builder().build()
        binding.bannerMain.loadAd(adRequest)
    }

    private fun initNavigation() {
        val navHost = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHost.navController
        binding.bottomNavView.setupWithNavController(navController)
    }
}