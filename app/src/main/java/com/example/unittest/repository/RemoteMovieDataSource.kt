package com.example.unittest.repository

import com.example.unittest.model.MovieListResponseData
import com.example.unittest.model.MovieStarListResponseData
import com.example.unittest.network.ApiUrls
import com.example.unittest.network.ApiUrls.KEY
import com.example.unittest.network.MovieApi
import com.example.unittest.source.MovieDataSource
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory

class RemoteMovieDataSource : MovieDataSource {
    private val retrofit = Retrofit.Builder()
        .baseUrl(ApiUrls.BASE_URL)
        .client(
            OkHttpClient()
                .newBuilder()
                .addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
                .build()
        )
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private var movieApi: MovieApi = retrofit.create(MovieApi::class.java)

    override suspend fun fetchMovieList(): MovieListResponseData? {
        return kotlin.runCatching { movieApi.fetchMovieList(KEY).awaitResponse() }.getOrNull()
            ?.body()
    }

    override suspend fun fetchMovieStarList(): MovieStarListResponseData? {
        return kotlin.runCatching { movieApi.fetchMovieStarList(KEY).awaitResponse() }.getOrNull()
            ?.body()
    }
}