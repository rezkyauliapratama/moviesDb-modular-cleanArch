package id.co.rezkyauliapratama.featurehome.data.datasource

import id.co.rezkyauliapratama.featurehome.data.datasource.model.mapToDomain
import id.co.rezkyauliapratama.featurehome.data.datasource.source.api.MoviesApi
import id.co.rezkyauliapratama.featurehome.data.datasource.source.datasource.MovieRemoteDataSource
import id.co.rezkyauliapratama.featurehome.domain.model.MovieModel
import io.reactivex.Single

class MovieDataSourceImpl(private val api: MoviesApi) : MovieRemoteDataSource {

    override fun getPopularMovies(apiKey: String, pageNumber: Int): Single<List<MovieModel>> =
        api.getPopularMovies(apiKey, pageNumber)
            .map {
                it.moviesDto.mapToDomain()
            }

}
