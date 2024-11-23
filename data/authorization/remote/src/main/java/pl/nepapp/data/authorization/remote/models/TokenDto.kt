package pl.nepapp.data.authorization.remote.models

data class TokenDto(
    val accessToken: String,
    val refreshToken: String
)
