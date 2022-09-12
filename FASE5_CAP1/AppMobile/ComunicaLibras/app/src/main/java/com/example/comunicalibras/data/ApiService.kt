package com.example.comunicalibras.data

import com.example.comunicalibras.data.models.Aula
import com.example.comunicalibras.data.models.Credentials
import com.example.comunicalibras.data.models.Professor
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Part

interface ApiService {
    @GET("/aula")
    suspend fun getClasses(): Response<List<Aula>>

    @POST("/login")
    suspend fun login(
        @Body credentials : Credentials
    ): Response<Professor>

}