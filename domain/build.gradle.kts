plugins {
    id (Plugins.Kotlin.kotlin_jvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies{

    //coroutines
    api(Deps.Coroutines.core)

    //paging
    implementation(Deps.Paging3.common)
}