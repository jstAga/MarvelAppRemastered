plugins {
    id(Plugins.AGP.java)
    id(Plugins.Kotlin.kotlin_jvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {

    // Coroutines
    api(Deps.Coroutines.core)

    // Paging
    implementation(Deps.Paging3.common)

    // Inject
    implementation(Deps.Javax.inject)
}