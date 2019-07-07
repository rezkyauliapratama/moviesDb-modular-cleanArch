package id.co.rezkyauliapratama.featurehome.data.datasource.source.mock

import id.co.rezkyauliapratama.featurehome.domain.model.MovieModel
import io.reactivex.Single

interface MovieMockDataSource {
    fun getPopularMovies() : Single<List<MovieModel>>
}