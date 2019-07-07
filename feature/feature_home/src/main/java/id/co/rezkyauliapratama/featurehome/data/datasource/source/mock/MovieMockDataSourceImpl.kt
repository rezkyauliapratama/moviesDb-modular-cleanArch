package id.co.rezkyauliapratama.featurehome.data.datasource.source.mock

import id.co.rezkyauliapratama.featurehome.data.datasource.model.mapToDomain
import id.co.rezkyauliapratama.featurehome.domain.model.MovieModel
import io.reactivex.Single
import java.util.concurrent.TimeUnit

class MovieMockDataSourceImpl () : MovieMockDataSource {
    override fun getPopularMovies(): Single<List<MovieModel>> {
        return Single.just(
            MovieMockDataFactory.create()
        ).map {
            it.moviesDto.mapToDomain()
        }.delay(3, TimeUnit.SECONDS)
    }

}