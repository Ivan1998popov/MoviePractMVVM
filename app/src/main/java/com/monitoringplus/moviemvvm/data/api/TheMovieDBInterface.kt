package com.monitoringplus.moviemvvm.data.api

import com.monitoringplus.moviemvvm.data.vo.MovieDetails
import com.monitoringplus.moviemvvm.data.vo.MovieResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TheMovieDBInterface {

    //https://api.themoviedb.org/3/movie/popular?api_key=22481f635e97b40e7a45bf3bccf9d11f&language=RU-ru&page=1
    //https://api.themoviedb.org/3/movie/299534?api_key=22481f635e97b40e7a45bf3bccf9d11f&language=RU-ru
    //https://api.themoviedb.org/3/

    @GET("movie/popular")
    fun getPopularMovie(@Query("page") page: Int): Single<MovieResponse>

    @GET("movie/{movie_id}")
    fun getMovieDetails(@Path("movie_id") id: Int): Single<MovieDetails>
}