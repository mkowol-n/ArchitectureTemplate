plugins {
    id("base-android-library-conventions")
    id("base-compose-conventions")
}

android {
    namespace = "pl.nepapp.coreui"
}

dependencies {
    implementation(libs.androidx.ui)
    implementation(libs.androidx.material3)
    implementation(project(":core:state-management"))
}