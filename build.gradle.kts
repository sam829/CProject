// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    val hiltVersion by extra("2.44")
    dependencies {
        classpath("com.google.dagger:hilt-android-gradle-plugin:$hiltVersion")
    }
}

plugins {
    id("com.android.application") version("8.0.0") apply false
    id("org.jetbrains.kotlin.android") version("1.8.10") apply false
}