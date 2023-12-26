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
            implementation(projects.coreAuth)

            implementation(libs.sql.delight.runtime)
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.cio)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.serialization.kotlinx.json)
            implementation(libs.kotlinx.serialization)
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
        minSdk = 24
    }
}

sqldelight {
    databases {
        create("BooksDatabase") {
            packageName.set("")
        }
    }
}