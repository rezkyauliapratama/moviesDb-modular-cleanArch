package id.co.rezkyauliapratama.feature_home.data.datasource.source.datasource

import id.co.rezkyauliapratama.feature_home.domain.model.MovieModel
import io.reactivex.Single

interface MovieRemoteDataSource {
    fun getPopularMovies(apiKey: String, pageNumber: Int): Single<List<MovieModel>>
}