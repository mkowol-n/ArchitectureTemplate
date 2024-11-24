plugins {
    id("base-feature-impl-conventions")
}

android {
    namespace = "pl.nepapp.features.login.impl"
}

dependencies {
    implementation(project(":features:login"))
    implementation(project(":features:dashboard"))
    implementation(project(":data:authorization"))
    implementation(project(":core:settings"))
    implementation(project(":usecases:emailvalidator"))
    implementation(project(":usecases:combined"))
}