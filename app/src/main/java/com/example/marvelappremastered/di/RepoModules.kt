package com.example.marvelappremastered.di

import com.example.data.repository.ComicsRepositoryImpl
import com.example.domain.repository.ComicsRepository
import org.koin.dsl.module

val repoModules = module {
    single<ComicsRepository> { ComicsRepositoryImpl(get())}
}