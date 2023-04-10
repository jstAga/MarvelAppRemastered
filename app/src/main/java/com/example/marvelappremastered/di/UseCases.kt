package com.example.marvelappremastered.di

import com.example.domain.usecases.GetComicsUseCase
import org.koin.dsl.module

val useCases = module {
    factory { GetComicsUseCase(get()) }
}