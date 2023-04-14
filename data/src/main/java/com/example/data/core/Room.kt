package com.example.data.core

//import android.app.Application
//import androidx.room.Room
//import com.example.data.local.room.AppDataBase
//import com.example.data.local.room.ComicsDao
//import org.koin.android.ext.koin.androidApplication
//import org.koin.core.KoinApplication
//import org.koin.dsl.module
//
//val roomModules = module {
////    single { providesDatabase(get()) }
////    single { providesDao(get()) }
//    single {
//        Room.databaseBuilder(
//            androidApplication(),
//            AppDataBase::class.java,
//            "appDatabase"
//        ).build()
//    }
//    single<ComicsDao> {
//        val db = get<AppDataBase>()
//        db.comicDao()
//    }
//}
//
//fun providesDatabase(application: Application): AppDataBase =
//    Room.databaseBuilder(
//        application,
//        AppDataBase::class.java,
//        "appDatabase"
//    )
////        .fallbackToDestructiveMigration()
////        .allowMainThreadQueries()
//        .build()
//
//fun providesDao(db: AppDataBase) = db.comicDao()