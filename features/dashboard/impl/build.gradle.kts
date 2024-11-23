plugins {
    id("base-feature-impl-conventions")
}

android {
    namespace = "pl.nepapp.features.dashboard.impl"
}

dependencies {
    implementation(project(":features:login"))
    implementation(project(":features:dashboard"))
}