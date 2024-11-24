plugins {
    id("base-usecase-android-conventions")
}

android {
    namespace = "pl.nepapp.usecases.emailvalidator.impl"
}

dependencies {
    implementation(project(":usecases:emailvalidator"))
}