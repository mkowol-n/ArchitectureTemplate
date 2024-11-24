plugins {
    alias(libs.plugins.android.library)
    id("base-android-conventions")
    id("base-compose-conventions")
}

android {
    namespace = "pl.nepapp.coreui"
}

dependencies {
    implementation(libs.androidx.ui)
    implementation(libs.androidx.material3)
    implementation(libs.immutableList)
    implementation(project(":core:state-management"))
}