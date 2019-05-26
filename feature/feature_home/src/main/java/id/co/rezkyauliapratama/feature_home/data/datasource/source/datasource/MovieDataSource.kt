package id.co.rezkyauliapratama.feature_home.data.source.datasource

import id.co.rezkyauliapratama.feature_home.domain.model.Movie
import io.reactivex.Single

interface MovieRemoteSource {
    fun getPopularMovies(): Single<List<Movie>>
}