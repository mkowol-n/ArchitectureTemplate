package pl.nepapp.data.authorization.remote

import retrofit2.http.GET

interface AuthorizationService {
    @GET(".")
    suspend fun login()
}