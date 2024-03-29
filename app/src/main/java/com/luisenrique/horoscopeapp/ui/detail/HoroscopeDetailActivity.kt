package com.luisenrique.horoscopeapp.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import com.luisenrique.horoscopeapp.R
import com.luisenrique.horoscopeapp.databinding.ActivityHoroscopeDetailBinding
import com.luisenrique.horoscopeapp.domain.model.HoroscopeModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHoroscopeDetailBinding
    private val horoscopeDetailViewModel: HoroscopeDetailViewModel by viewModels()

    private val args: HoroscopeDetailActivityArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHoroscopeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        horoscopeDetailViewModel.getHoroscope(args.type)
        initLoadAds()
        initUI()
    }

    private fun initUI() {
        initListeners()
        initUIState()
    }

    private fun initLoadAds() {
        val adRequest = com.google.android.gms.ads.AdRequest.Builder().build()
        binding.bannerDetail.loadAd(adRequest)
    }

    private fun initListeners() {
        binding.ivBack.setOnClickListener { onBackPressed() }
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                horoscopeDetailViewModel.state.collect {
                    when (it) {
                        HoroscopeDetailState.Loading -> loadingState()
                        is HoroscopeDetailState.Error -> errorState()
                        is HoroscopeDetailState.Success -> successState(it)
                    }
                }
            }
        }
    }

    private fun loadingState() {
        binding.pb.isVisible = true
    }

    private fun errorState() {
        binding.pb.isVisible = false
    }

    private fun successState(state: HoroscopeDetailState.Success) {
        binding.pb.isVisible = false
        binding.tvTitle.text = state.sign
        binding.tvBody.text = state.prediction

        val image = when (state.horoscopeModel) {
            HoroscopeModel.Aquarius -> R.drawable.detail_aquarius
            HoroscopeModel.Aries -> R.drawable.detail_aries
            HoroscopeModel.Cancer -> R.drawable.detail_cancer
            HoroscopeModel.Capricorn -> R.drawable.detail_capricorn
            HoroscopeModel.Gemini -> R.drawable.detail_gemini
            HoroscopeModel.Leo -> R.drawable.detail_leo
            HoroscopeModel.Libra -> R.drawable.detail_libra
            HoroscopeModel.Pisces -> R.drawable.detail_pisces
            HoroscopeModel.Sagittarius -> R.drawable.detail_sagittarius
            HoroscopeModel.Scorpio -> R.drawable.detail_scorpio
            HoroscopeModel.Taurus -> R.drawable.detail_taurus
            HoroscopeModel.Virgo -> R.drawable.detail_virgo
        }
        binding.ivDetail.setImageResource(image)
    }
}