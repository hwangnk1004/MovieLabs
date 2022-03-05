package com.example.movieinfo.repository

import com.example.movieinfo.model.movielist.MovieListResponseData
import com.example.movieinfo.model.moviestarlist.MovieStarListResponseData
import com.example.movieinfo.network.ApiUrls
import com.example.movieinfo.network.ApiUrls.KEY
import com.example.movieinfo.network.MovieApiService
import com.example.movieinfo.source.MovieDataSource
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.await
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

    private var movieApi: MovieApiService = retrofit.create(MovieApiService::class.java)

    override suspend fun fetchMovieList(): MovieListResponseData? {
        return runCatching { movieApi.fetchMovieList(KEY).await() }.getOrNull()
    }

    override suspend fun fetchMovieStarList(): MovieStarListResponseData? {
        return runCatching { movieApi.fetchMovieStarList(KEY).await() }.getOrNull()
    }
}