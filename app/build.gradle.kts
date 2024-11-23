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
}

dependencies {
    implementation(libs.androidx.activity.compose)

//    implementation(libs.androidx.core.ktx)
//    implementation(libs.androidx.lifecycle.runtime.ktx)
//    implementation(platform(libs.androidx.compose.bom))
//    implementation(libs.androidx.ui)
//    implementation(libs.androidx.ui.graphics)
//    implementation(libs.androidx.ui.tooling.preview)
//    implementation(libs.androidx.material3)
    implementation(project(":features:login:impl"))
    implementation(project(":core:navigation:graphs"))
}