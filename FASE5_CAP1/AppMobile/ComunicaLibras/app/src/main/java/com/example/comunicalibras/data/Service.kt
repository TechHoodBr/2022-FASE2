package com.example.comunicalibras.data

import com.example.comunicalibras.BuildConfig
import com.example.comunicalibras.data.models.Aula
import com.example.comunicalibras.data.models.Credentials
import com.example.comunicalibras.data.models.Professor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class Service {

    private val interceptor = run {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.apply {
            if(BuildConfig.DEBUG)  httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            else httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE)
        }
    }

    private val okHttpClient = OkHttpClient.Builder()
        .addNetworkInterceptor(interceptor)
        .connectTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .build()

    private val api: ApiService = Retrofit.Builder()
        .baseUrl("http://msolutions.com.br:8080")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)

    suspend fun login(credentials : Credentials): Response<Professor> = api.login(credentials)

    suspend fun getClasses(): Response<List<Aula>> = api.getClasses()

}