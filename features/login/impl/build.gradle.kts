plugins {
    id("base-feature-impl-conventions")
}

android {
    namespace = "pl.nepapp.features.login.impl"
}

dependencies {
    implementation(project(":features:login"))
}