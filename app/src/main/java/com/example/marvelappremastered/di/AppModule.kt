package com.example.marvelappremastered.di

import android.content.Context
import androidx.room.Room
import com.example.data.local.room.AppDataBase
import com.example.data.local.room.ComicsDao
import com.example.data.remote.Constants
import com.example.data.remote.apiServices.MarvelApi
import com.example.data.repository.ComicsRepositoryImpl
import com.example.domain.repository.ComicsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, AppDataBase::class.java, "note_db").fallbackToDestructiveMigration()
            .allowMainThreadQueries().build()

    @Singleton
    @Provides
    fun provideComicDao(appDataBase: AppDataBase) = appDataBase.comicDao()

    @Singleton
    @Provides
    fun provideComicsRepository(marvelApi: MarvelApi, comicsDao: ComicsDao): ComicsRepository =
        ComicsRepositoryImpl(marvelApi, comicsDao)

    @Provides
    fun marvelApiProvide(): MarvelApi {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL_MARVEL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(MarvelApi::class.java)
    }
}