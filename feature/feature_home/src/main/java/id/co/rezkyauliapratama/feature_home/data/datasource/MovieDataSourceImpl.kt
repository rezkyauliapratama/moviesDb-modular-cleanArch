package id.co.rezkyauliapratama.feature_home.data.datasource

import id.co.rezkyauliapratama.feature_home.data.datasource.model.mapToDomain
import id.co.rezkyauliapratama.feature_home.data.datasource.source.api.MoviesApi
import id.co.rezkyauliapratama.feature_home.data.datasource.source.datasource.MovieRemoteDataSource
import id.co.rezkyauliapratama.feature_home.domain.model.MovieModel
import io.reactivex.Single

class MovieDataSourceImpl(private val api: MoviesApi) : MovieRemoteDataSource {

    override fun getPopularMovies(apiKey: String, pageNumber: Int): Single<List<MovieModel>> =
        api.getPopularMovies(apiKey, pageNumber).map {
            it.moviesDto.mapToDomain()
        }

}