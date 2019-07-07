package id.co.rezkyauliapratama.featurehome.data.datasource

import id.co.rezkyauliapratama.featurehome.data.datasource.source.mock.MovieMockDataSource
import id.co.rezkyauliapratama.featurehome.domain.model.MovieModel
import io.reactivex.Single

class MovieDataSourceManager(
    val movieMockDataSource: MovieMockDataSource
) : MovieDataSource {

    override fun getPopularMovies(): Single<List<MovieModel>> {
        return movieMockDataSource.getPopularMovies()
    }

}