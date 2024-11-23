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

    buildFeatures {
        buildConfig = true
    }

}

dependencies {
    implementation(libs.androidx.activity.compose)

//    implementation(libs.androidx.lifecycle.runtime.ktx)
//    implementation(platform(libs.androidx.compose.bom))
//    implementation(libs.androidx.ui)
//    implementation(libs.androidx.ui.graphics)
//    implementation(libs.androidx.ui.tooling.preview)
//    implementation(libs.androidx.material3)
    implementation(project(":features:login"))
    implementation(project(":features:dashboard"))
    implementation(project(":core:config:http"))
    implementation(project(":core:config:shared"))

    implementation(project(":features:account"))
    implementation(project(":features:main"))
    implementation(project(":features:todo-details"))
    implementation(project(":features:todo_list"))

    implementation(project(":features:login:impl"))
    implementation(project(":features:dashboard:impl"))
    implementation(project(":features:todo-details:impl"))
    implementation(project(":features:todo_list:impl"))
    implementation(project(":features:account:impl"))
    implementation(project(":core:graphapi"))
    implementation(project(":core:graphapi:impl"))

    implementation(libs.timber)


    implementation(platform(libs.koin.bom))
    implementation(libs.koin.android)
    implementation(libs.koin.compose)
    implementation(libs.koin.core)
    implementation(project(":data:authorization:impl"))
}