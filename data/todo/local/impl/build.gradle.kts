import org.gradle.android.Versions.android

plugins {
    id("base-local-source-impl-conventions")
}

android {
    namespace = "pl.nepapp.data.todo.local.impl"
}

dependencies {
    implementation(project(":data:todo:local"))
}