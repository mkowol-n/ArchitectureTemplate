plugins {
    alias(libs.plugins.android.library)
    id("base-android-conventions")
}

android {
    namespace = "pl.nepapp.data.todo.local.impl"
}

dependencies {
    implementation(libs.androidx.room.runtime)
    ksp(libs.androidx.room.compiler)
    implementation(libs.androidx.room.ktx)
    implementation(project(":data:todo:local"))
}