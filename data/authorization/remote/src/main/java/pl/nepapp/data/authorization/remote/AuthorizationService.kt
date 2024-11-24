package pl.nepapp.data.authorization.remote

import pl.nepapp.data.authorization.remote.models.TokenDto
import retrofit2.Call
import retrofit2.http.POST

interface AuthorizationService {
    @POST(".")
    suspend fun login(): TokenDto

    @POST("refresh")
    suspend fun refreshToken(refreshToken: String): Call<TokenDto>
}