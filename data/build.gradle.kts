plugins {
    id(Plugins.AGP.library)
    id(Plugins.Kotlin.kotlin)
    id(Plugins.Kotlin.kapt)
}

android {
    namespace = "com.example.data"
    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    // Module
    implementation(project(":domain"))

    // Retrofit 2
    implementation(Deps.Retrofit.retrofit)
    implementation(Deps.Retrofit.converterGson)

    // OkHttp
    implementation(Deps.Okhttp.okhttp3)

    // Coroutines
    implementation(Deps.Coroutines.android)


    // Paging
    api(Deps.Paging3.paging)

    // Room
    implementation(Deps.Room.room)
    implementation(Deps.Room.roomRuntime)
    implementation(Deps.Room.compiler)

    // Inject
    implementation(Deps.Javax.inject)
}