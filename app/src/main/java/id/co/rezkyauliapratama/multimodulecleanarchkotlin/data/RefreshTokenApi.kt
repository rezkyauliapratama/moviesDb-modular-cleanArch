package id.co.rezkyauliapratama.multi_module_cleanarch_kotlin.data

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RefreshTokenApi {

    @GET("/authentication/token/new")
    fun getPopularMovies(
        @Query("api_key") pageNum: Int?
    ): Single<RefreshTokenApi>
}