package id.co.rezkyauliapratama.feature_home.domain.repository

import id.co.rezkyauliapratama.feature_home.domain.model.MovieModel
import io.reactivex.Single

interface MovieRepository {

    fun getPopularMovies(pageNum: Int): Single<List<MovieModel>>
}