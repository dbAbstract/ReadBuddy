plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
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
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            //put your multiplatform dependencies here
            implementation(libs.kotlinx.localdatetime)
            implementation(libs.russhwolf.settings)
            api(libs.kermit)
            implementation(libs.sql.delight.coroutines)
        }
        iosMain.dependencies {
            implementation(libs.sql.delight.ios)
        }
        androidMain.dependencies {
            implementation(libs.sql.delight.android)
            api(libs.compose.navigation)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "com.arcanium.readbuddy"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
}

sqldelight {
    databases {
        create("AuthDatabase") {
            packageName.set("com.arcanium.readybuddy.db")
        }
    }
}
