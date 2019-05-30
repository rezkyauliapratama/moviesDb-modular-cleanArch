package id.co.rezkyauliapratama.feature_home.data.repository

import id.co.rezkyauliapratama.feature_home.data.datasource.source.datasource.MovieRemoteDataSource
import id.co.rezkyauliapratama.feature_home.domain.model.MovieModel
import id.co.rezkyauliapratama.feature_home.domain.repository.MovieRepository
import io.reactivex.Single

class MovieRepositoryImpl (
    private val apiKey: String,
    private val remoteSource: MovieRemoteDataSource
): MovieRepository {

    override fun getPopularMovies(pageNum: Int): Single<List<MovieModel>> =
            remoteSource.getPopularMovies(apiKey, pageNum)
}