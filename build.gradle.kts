// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(Plugins.AGP.application) version Versions.AGP apply false
    id(Plugins.AGP.library) version Versions.AGP apply false
    id(Plugins.Kotlin.kotlin) version Versions.kotlin apply false
    id(Plugins.DaggerHilt.android) version Versions.daggerHilt apply false
}