plugins {
    id("base-data-impl-conventions")
}

dependencies {
    implementation(project(":data:authorization"))
    implementation(project(":data:authorization:remote"))
    implementation(project(":core:config:http"))
}