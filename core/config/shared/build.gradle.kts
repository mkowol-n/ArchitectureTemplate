plugins {
    id("base-kotlin-conventions")
}

dependencies {
    implementation(platform(libs.koin.bom))
    implementation(libs.koin.core)
    implementation(libs.moshi)
}