plugins {
    id("base-feature-impl-conventions")
}

android {
    namespace = "pl.nepapp.features.account.impl"
}

dependencies {
    implementation(project(":features:account"))
}