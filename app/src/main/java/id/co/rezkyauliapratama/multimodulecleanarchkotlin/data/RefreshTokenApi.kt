package id.co.rezkyauliapratama.multimodulecleanarchkotlin.data

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RefreshTokenApi {

    @GET("/authentication/token/new")
    fun getPopularMovies(
        @Query("api_key") pageNum: Int?
    ): Single<RefreshTokenApi>

}
