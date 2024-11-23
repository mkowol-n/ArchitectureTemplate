package pl.nepapp.data.authorization.remote

import pl.nepapp.data.authorization.remote.models.TokenDto
import retrofit2.Call
import retrofit2.http.GET

interface AuthorizationService {
    @GET(".")
    suspend fun login(): TokenDto

    suspend fun refreshToken(refreshToken: String): Call<TokenDto>
}