package id.co.rezkyauliapratama.feature_home.data.source

import id.co.rezkyauliapratama.feature_home.data.model.ListMoviesDto
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {

    @GET("/movie/popular")
    fun getPopularMovies(
        @Query("pageNum") pageNum: Int?,
        @Query("pageSize") pageSize: Int?,
        @Query("month") month: Int?,
        @Query("year") year: Int?,
        @Query("status") status: String?
    ): Single<ListMoviesDto>

}