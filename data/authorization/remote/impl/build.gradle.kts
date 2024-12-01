plugins {
    id("base-remote-source-impl-conventions")
}

android {
    namespace = "pl.nepapp.data.authorization.remote.impl"
}

dependencies {
    implementation(project(":data:authorization:remote"))
}