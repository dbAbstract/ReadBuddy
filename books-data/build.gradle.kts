plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinSerialization)
    alias(libs.plugins.sql.delight)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "books-data"
            isStatic = true
        }
    }

    sourceSets {
        iosMain.dependencies {
            implementation(libs.sql.delight.ios)
        }

        commonMain.dependencies {
            //put your multiplatform dependencies here
            implementation(projects.booksDomain)
            implementation(projects.shared)

            implementation(libs.sql.delight.coroutines)
            implementation(libs.kotlinx.localdatetime)
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.cio)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.serialization.kotlinx.json)
            implementation(libs.kotlinx.serialization)
            implementation(libs.russhwolf.settings)
        }

        androidMain.dependencies {
            implementation(libs.sql.delight.android)
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "com.arcanium.books_data"
    compileSdk = 34
    defaultConfig {
        minSdk = libs.versions.android.min.sdk.get().toInt()
    }
}

sqldelight {
    databases {
        create("BooksDatabase") {
            packageName.set("com.arcanium.readbuddy.db")
        }
    }
}