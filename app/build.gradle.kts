plugins {
    alias(libs.plugins.android.application)
    id("base-compose-conventions")
    id("base-android-conventions")
}

android {
    namespace = "pl.nepapp.architecturetemplate"

    defaultConfig {
        applicationId = "pl.nepapp.architecturetemplate"
        targetSdk = 35
        versionCode = 1
        versionName = "0.0.1"
    }

    buildTypes {
        val release by getting {
            signingConfig = signingConfigs.getByName("debug")
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        val internal by creating {
            initWith(release)
        }
    }

    flavorDimensions.add("environment")

    productFlavors {
        //TODO replace with actual url
        val dev by creating {
            dimension = "environment"
            buildConfigField(
                "String",
                "BASE_URL",
                "\"https://www.google.com/\""
            )
        }
        val qa by creating {
            dimension = "environment"
            buildConfigField(
                "String",
                "BASE_URL",
                "\"https://www.google.com/\""
            )
        }
        val prod by creating {
            dimension = "environment"
            buildConfigField(
                "String",
                "BASE_URL",
                "\"https://www.google.com/\""
            )
        }
    }

    buildFeatures {
        buildConfig = true
    }

}

dependencies {
    val internalImplementation by configurations

    internalImplementation(libs.chucker)

    implementation(libs.androidx.activity.compose)

    implementation(project(":core:common:impl"))
    implementation(project(":core:config:http:impl"))
    implementation(project(":core:third-party"))
    implementation(project(":core:settings:local-impl"))
    implementation(project(":core:settings"))

    implementation(project(":core:navigation:impl"))

    implementation(project(":data:authorization:impl"))
    implementation(project(":data:authorization:remote:impl"))
    implementation(project(":data:todo:impl"))
    implementation(project(":data:todo:local:impl"))
    implementation(project(":features:main"))

    implementation(project(":usecases:combined:impl"))
    implementation(project(":usecases:emailvalidator:impl"))
    implementation(project(":core:state-management"))

    implementation(libs.timber)

    implementation(libs.koin.android)
    implementation(libs.koin.compose)
    implementation(libs.androidx.core.splashscreen)
    implementation(project(":features"))
    implementation(project(":features:impl"))

}