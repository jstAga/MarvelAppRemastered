plugins {
    id(Plugins.AGP.application)
    id(Plugins.Kotlin.kapt)
    id(Plugins.Kotlin.kotlin)
    id(Plugins.DaggerHilt.android)
//    id ("kotlin-android")
}

android {
    namespace = "com.example.marvelappremastered"
    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        applicationId = "com.example.marvelappremastered"
        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    // Module
    implementation(project(":data"))
    implementation(project(":domain"))

    // UI
    implementation(Deps.Ui.androidCore)
    implementation(Deps.Ui.appcompat)
    implementation(Deps.Ui.material)
    implementation(Deps.Ui.constraint)
    testImplementation(Deps.Ui.junit)
    androidTestImplementation(Deps.Ui.extJunit)
    androidTestImplementation(Deps.Ui.espresso)
    implementation(Deps.Ui.fragment)
    implementation(Deps.Ui.viewPager2)

    // Coroutines
    implementation(Deps.Coroutines.android)

    // Hilt
    implementation(Deps.DaggerHilt.android)
    kapt(Deps.DaggerHilt.compiler)

    // Retrofit
    implementation(Deps.Retrofit.retrofit)
    implementation(Deps.Retrofit.converterGson)

    // Room
    implementation(Deps.Room.room)
    annotationProcessor(Deps.Room.compiler)
//    kapt(Deps.Room.compiler)

    // Navigation
    implementation(Deps.Navigation.ui)
    implementation(Deps.Navigation.fragment)

    // Binding delegate
    implementation(Deps.ViewBindingDelegate.delegate)

    // Coil
    implementation(Deps.Coil.coil)

    // Lifecycle
    val lifecycleVersion = "2.5.1"
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion")
}