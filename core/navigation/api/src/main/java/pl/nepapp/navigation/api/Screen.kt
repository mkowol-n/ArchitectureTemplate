package pl.nepapp.navigation.api

interface Screen {
    val screenName: String get() = this::class.java.canonicalName!!
}