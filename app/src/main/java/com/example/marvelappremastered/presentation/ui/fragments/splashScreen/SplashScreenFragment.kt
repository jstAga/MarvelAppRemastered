package com.example.marvelappremastered.presentation.ui.fragments.splashScreen

import android.annotation.SuppressLint
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.load
import com.example.marvelappremastered.R
import com.example.marvelappremastered.databinding.FragmentSplashScreenBinding
import com.example.marvelappremastered.presentation.core.base.BaseFragment
import com.example.marvelappremastered.presentation.core.navigateSafely
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@SuppressLint("CustomSplashScreen")
class SplashScreenFragment :
    BaseFragment<FragmentSplashScreenBinding, SplashScreenViewModel>(R.layout.fragment_splash_screen) {

    override val binding by viewBinding(FragmentSplashScreenBinding::bind)
    override val viewModel : SplashScreenViewModel by viewModels()

    override fun initialize() {
        binding.ivLogo.load(R.drawable.ic_marvel_logo) {
            crossfade(750)
            build()
        }
        afterSplash()
    }

    private fun afterSplash() {
        Handler(Looper.getMainLooper()).postDelayed({
            //            if (auth.currentUser?.uid != null) {
            findNavController().navigateSafely(R.id.action_splashScreenFragment_to_mainFlowFragment)
            //            } else {
            //                findNavController().navigate(R.id.boardingFragment)
            //            }
        }, 3000)
    }
}