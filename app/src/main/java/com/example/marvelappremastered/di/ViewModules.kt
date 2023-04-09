package com.example.marvelappremastered.di

import com.example.marvelappremastered.ui.fragments.sign.auth.AuthViewModel
import com.example.marvelappremastered.ui.fragments.main.comics.ComicsViewModel
import com.example.marvelappremastered.ui.fragments.main.creditCard.CreditCardViewModel
import com.example.marvelappremastered.ui.fragments.main.filmDetail.FilmDetailViewModel
import com.example.marvelappremastered.ui.fragments.main.home.HomeViewModel
import com.example.marvelappremastered.ui.fragments.main.onBoarding.OnBoardingViewModel
import com.example.marvelappremastered.ui.fragments.main.shop.ShopViewModel
import com.example.marvelappremastered.ui.fragments.splashScreen.SplashScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModules = module {
    viewModel { AuthViewModel() }
    viewModel { ComicsViewModel() }
    viewModel { CreditCardViewModel() }
    viewModel { FilmDetailViewModel() }
    viewModel { HomeViewModel() }
    viewModel { OnBoardingViewModel() }
    viewModel { ShopViewModel() }
    viewModel { SplashScreenViewModel() }
}