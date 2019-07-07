package id.co.rezkyauliapratama.featurehome.data.repository

import id.co.rezkyauliapratama.featurehome.data.datasource.MovieDataSource
import id.co.rezkyauliapratama.featurehome.domain.model.MovieModel
import id.co.rezkyauliapratama.featurehome.domain.repository.MovieRepository
import io.reactivex.Single

class MovieRepositoryImpl(
    private val dataSourceManager: MovieDataSource
) : MovieRepository {

    override fun getPopularMovies(): Single<List<MovieModel>> =
        dataSourceManager.getPopularMovies()
}
