package com.example.data.core

//import com.example.data.remote.Constants
//import com.example.data.remote.apiServices.MarvelApi
//import okhttp3.OkHttpClient
//import okhttp3.logging.HttpLoggingInterceptor
//import org.koin.core.module.Module
//import org.koin.dsl.module
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//import java.util.concurrent.TimeUnit
//
//
//val networkModules: Module = module {
//    factory { provideOkHttpClient() }
//    single { provideRetrofit(get()) }
//    factory { provideApi(get()) }
//}
//
//fun provideOkHttpClient(): OkHttpClient {
//    val interceptor = HttpLoggingInterceptor()
//    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
//
//    return OkHttpClient.Builder().writeTimeout(20, TimeUnit.SECONDS)
//        .readTimeout(20, TimeUnit.SECONDS).addInterceptor(interceptor)
//        .connectTimeout(20, TimeUnit.SECONDS).build()
//}
//
//fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
//    return Retrofit.Builder()
//        .baseUrl(Constants.BASE_URL_MARVEL)
//        .addConverterFactory(GsonConverterFactory.create())
//        .client(okHttpClient)
//        .build()
//}
//
//fun provideApi(retrofit: Retrofit): MarvelApi = retrofit.create(MarvelApi::class.java)