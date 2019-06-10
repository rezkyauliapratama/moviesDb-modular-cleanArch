package id.co.rezkyauliapratama.featurehome.data.repository

import id.co.rezkyauliapratama.featurehome.data.datasource.source.datasource.MovieRemoteDataSource
import id.co.rezkyauliapratama.featurehome.domain.model.MovieModel
import id.co.rezkyauliapratama.featurehome.domain.repository.MovieRepository
import io.reactivex.Single

class MovieRepositoryImpl (
    private val apiKey: String,
    private val remoteSource: MovieRemoteDataSource
): MovieRepository {

    override fun getPopularMovies(pageNum: Int): Single<List<MovieModel>> =
            remoteSource.getPopularMovies(apiKey, pageNum)
}
