plugins {
    id("base-feature-impl-conventions")
}

android {
    namespace = "pl.nepapp.features.main"
}

dependencies {
    implementation(project(":features:login"))
    implementation(project(":core:navigation"))
}