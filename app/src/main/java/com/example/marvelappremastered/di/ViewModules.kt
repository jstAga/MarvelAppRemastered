package com.example.marvelappremastered.di

import com.example.marvelappremastered.ui.fragments.auth.AuthViewModel
import com.example.marvelappremastered.ui.fragments.comics.ComicsViewModel
import com.example.marvelappremastered.ui.fragments.creditCard.CreditCardViewModel
import com.example.marvelappremastered.ui.fragments.filmDetail.FilmDetailViewModel
import com.example.marvelappremastered.ui.fragments.home.HomeViewModel
import com.example.marvelappremastered.ui.fragments.onBoarding.OnBoardingViewModel
import com.example.marvelappremastered.ui.fragments.shop.ShopViewModel
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