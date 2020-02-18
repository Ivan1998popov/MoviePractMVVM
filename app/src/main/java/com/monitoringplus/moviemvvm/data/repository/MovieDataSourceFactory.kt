package com.monitoringplus.moviemvvm.data.repository

import androidx.lifecycle.MutableLiveData
import com.monitoringplus.moviemvvm.data.vo.Movie
import androidx.paging.DataSource
import com.monitoringplus.moviemvvm.data.api.TheMovieDBInterface
import io.reactivex.disposables.CompositeDisposable
import java.util.concurrent.ScheduledExecutorService

class MovieDataSourceFactory(
    private val apiService: TheMovieDBInterface,
    private val compositeDisposable: CompositeDisposable
) : DataSource.Factory<Int, Movie>() {

    val movieLiveDataSource = MutableLiveData<MovieDataSource>()

    override fun create(): DataSource<Int, Movie> {
        val movieDataSource = MovieDataSource(apiService, compositeDisposable)

        movieLiveDataSource.postValue(movieDataSource)
        return movieDataSource
    }
}