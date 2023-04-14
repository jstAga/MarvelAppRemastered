object Versions {

    const val AGP = "7.4.1"
    const val kotlin = "1.7.20"
    const val androidCore = "1.9.0"
    const val appcompat = "1.6.1"
    const val material = "1.8.0"
    const val constraint = "2.1.4"
    const val junit = "4.13.2"
    const val extJunit = "1.1.5"
    const val espresso = "3.5.1"
    const val fragment = "1.5.5"
    const val viewpager = "1.0.0"
    const val navigation = "2.5.3"
    const val coroutines = "1.6.4"
    const val koin_version = "2.2.3"
    const val paging = "3.1.1"
    const val retrofit = "2.9.0"
    const val room = "2.4.3"
    const val daggerHilt = "2.44"
}

object Deps {

    object Ui {
        const val androidCore = "androidx.core:core-ktx:${Versions.androidCore}"
        const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
        const val material = "com.google.android.material:material:${Versions.material}"
        const val constraint = "androidx.constraintlayout:constraintlayout:${Versions.constraint}"
        const val junit = "junit:junit:${Versions.junit}"
        const val extJunit = "androidx.test.ext:junit:${Versions.extJunit}"
        const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
        const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragment}"
        const val viewPager2 = "androidx.viewpager2:viewpager2:${Versions.viewpager}"
    }

    object Coroutines {
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    }

    object Navigation {
        const val fragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
        const val ui = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    }

    object ViewBindingDelegate {
        const val delegate = "com.github.kirich1409:viewbindingpropertydelegate-full:1.5.8"
    }

    object Javax {
        const val inject = "javax.inject:javax.inject:1"
    }

//    object Koin{
//        const val koin =  "io.insert-koin:koin-android:${Versions.koin_version}"
//        const val scope =  "io.insert-koin:koin-androidx-scope:${Versions.koin_version}"
//        const val viewModel =  "io.insert-koin:koin-androidx-viewmodel:${Versions.koin_version}"
//        const val fragment =  "io.insert-koin:koin-androidx-fragment:${Versions.koin_version}"
//    }

    object Coil{
        const val coil = "io.coil-kt:coil:2.2.2"
    }

    object Retrofit{
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val converterGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    }

    object Okhttp{
        const val okhttp3  = "com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.2"
    }

    object Paging3{
        const val common = "androidx.paging:paging-common:${Versions.paging}"
        const val paging = "androidx.paging:paging-runtime-ktx:${Versions.paging}"
    }

    object Room {
        const val room = "androidx.room:room-ktx:${Versions.room}"
        const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
        const val compiler = "androidx.room:room-compiler:${Versions.room}"
    }

    object DaggerHilt {
        const val android = "com.google.dagger:hilt-android:${Versions.daggerHilt}"
        const val compiler = "com.google.dagger:hilt-compiler:${Versions.daggerHilt}"
    }
}

object Plugins {

    object AGP {
        const val application = "com.android.application"
        const val library = "com.android.library"
        const val java = "java-library"
    }

    object Kotlin {
        const val kotlin_jvm = "org.jetbrains.kotlin.jvm"
        const val kotlin = "org.jetbrains.kotlin.android"
        const val kapt = "kotlin-kapt"
    }

    object DaggerHilt {
        const val android = "com.google.dagger.hilt.android"
    }
}