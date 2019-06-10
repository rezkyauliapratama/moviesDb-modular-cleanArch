package id.co.rezkyauliapratama.featurehome.data.datasource.source.datasource

import id.co.rezkyauliapratama.featurehome.domain.model.MovieModel
import io.reactivex.Single

interface MovieRemoteDataSource {
    fun getPopularMovies(apiKey: String, pageNumber: Int): Single<List<MovieModel>>
}
