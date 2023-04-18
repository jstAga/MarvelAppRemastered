package com.example.marvelappremastered.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.example.data.local.room.dao.ComicsDao
import com.example.data.local.room.db.ComicDataBase
import com.example.data.remote.apiServices.MarvelApi
import com.example.data.repository.ShopRepositoryImpl
import com.example.data.repository.RoomRepositoryImpl
import com.example.domain.repository.ShopRepository
import com.example.domain.repository.RoomRepository
import com.example.marvelappremastered.presentation.core.Constants.Companion.BASE_URL_MARVEL
import com.example.marvelappremastered.presentation.core.Constants.Companion.MARVEL_APP_SHARED_PREFERENCES
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
object AppModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): ComicDataBase {
        return Room.databaseBuilder(context, ComicDataBase::class.java, "comic").build()
    }

    @Singleton
    @Provides
    fun provideComicDao(appDataBase: ComicDataBase) = appDataBase.comicDao()

    @Singleton
    @Provides
    fun provideComicsRepository(marvelApi: MarvelApi): ShopRepository = ShopRepositoryImpl(marvelApi)

    @Singleton
    @Provides
    fun provideRoomRepository(comicsDao: ComicsDao): RoomRepository = RoomRepositoryImpl(comicsDao)

    @Provides
    fun provideMarvelApi(): MarvelApi {
        return Retrofit.Builder().baseUrl(BASE_URL_MARVEL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(MarvelApi::class.java)
    }

    @Singleton
    @Provides
    fun provideSharedPref(@ApplicationContext context: Context): SharedPreferences =
        context.getSharedPreferences(
            MARVEL_APP_SHARED_PREFERENCES,
            Context.MODE_PRIVATE
        )
}