plugins {
    id("base-feature-api-conventions")
}

android {
    namespace = "pl.nepapp.features.tododetails"
}

dependencies {
    implementation(project(":data:todo"))
}