package id.co.rezkyauliapratama.feature_home.data.datasource.source.api

import id.co.rezkyauliapratama.feature_home.data.datasource.model.ListMoviesDto
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {

    @GET("/movie/popular")
    fun getPopularMovies(
        @Query("api_key") apiKey: String,
        @Query("page") pageNumber: Int?
    ): Single<ListMoviesDto>

}