package com.example.marvelappremastered.di

import com.example.marvelappremastered.presentation.ui.fragments.sign.auth.AuthViewModel
import com.example.marvelappremastered.presentation.ui.fragments.main.comics.ComicsViewModel
import com.example.marvelappremastered.presentation.ui.fragments.main.creditCard.CreditCardViewModel
import com.example.marvelappremastered.presentation.ui.fragments.main.filmDetail.FilmDetailViewModel
import com.example.marvelappremastered.presentation.ui.fragments.main.home.HomeViewModel
import com.example.marvelappremastered.presentation.ui.fragments.main.onBoarding.OnBoardingViewModel
import com.example.marvelappremastered.presentation.ui.fragments.main.shop.ShopViewModel
import com.example.marvelappremastered.presentation.ui.fragments.splashScreen.SplashScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModules = module {
    viewModel { AuthViewModel() }
    viewModel { ComicsViewModel(get()) }
    viewModel { CreditCardViewModel() }
    viewModel { FilmDetailViewModel() }
    viewModel { HomeViewModel() }
    viewModel { OnBoardingViewModel() }
    viewModel { ShopViewModel() }
    viewModel { SplashScreenViewModel() }
}