package id.co.rezkyauliapratama.featurehome.domain.repository

import id.co.rezkyauliapratama.featurehome.domain.model.MovieModel
import io.reactivex.Single

interface MovieRepository {
    fun getPopularMovies(pageNum: Int): Single<List<MovieModel>>
}
