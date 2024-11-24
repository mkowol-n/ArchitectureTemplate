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
        release {
            signingConfig = signingConfigs.getByName("debug")
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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
    implementation(libs.androidx.activity.compose)

    implementation(project(":core:common:impl"))
    implementation(project(":core:config:http:impl"))
    implementation(project(":core:config:database"))
    implementation(project(":core:config:shared"))
    implementation(project(":core:settings:local-impl"))
    implementation(project(":core:settings"))

    implementation(project(":features:main"))
    implementation(project(":features:login:impl"))
    implementation(project(":features:dashboard:impl"))
    implementation(project(":features:todo-details:impl"))
    implementation(project(":features:todo-list:impl"))
    implementation(project(":features:account:impl"))

    implementation(project(":core:navigation:impl"))

    implementation(project(":data:authorization:impl"))
    implementation(project(":data:todo:impl"))

    implementation(libs.timber)

    implementation(libs.koin.android)
    implementation(libs.koin.compose)

}