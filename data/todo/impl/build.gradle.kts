plugins {
    id("base-data-impl-conventions")
}

dependencies {
    implementation(project(":data:todo"))
    implementation(project(":data:todo:local"))
}