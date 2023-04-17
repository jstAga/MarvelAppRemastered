package com.example.marvelappremastered.di

import android.content.Context
import androidx.room.Room
import com.example.data.local.room.dao.ComicsDao
import com.example.data.local.room.db.ComicDataBase
import com.example.data.utils.Constants
import com.example.data.remote.apiServices.MarvelApi
import com.example.data.repository.ComicsRepositoryImpl
import com.example.data.repository.RoomRepositoryImpl
import com.example.domain.repository.ComicsRepository
import com.example.domain.repository.RoomRepository
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
        return Room.databaseBuilder(context, ComicDataBase::class.java, "comic").build()}

    @Singleton
    @Provides
    fun provideComicDao(appDataBase: ComicDataBase) = appDataBase.comicDao()

    @Singleton
    @Provides
    fun provideComicsRepository(marvelApi: MarvelApi) : ComicsRepository= ComicsRepositoryImpl(marvelApi)

    @Singleton
    @Provides
    fun provideRoomRepository(comicsDao: ComicsDao): RoomRepository = RoomRepositoryImpl(comicsDao)

    @Provides
    fun marvelApiProvide(): MarvelApi {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL_MARVEL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(MarvelApi::class.java)
    }
}