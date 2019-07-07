package id.co.rezkyauliapratama.featurehome.data.datasource.model

import com.squareup.moshi.Json
import id.co.rezkyauliapratama.featurehome.domain.model.MovieModel

class ListMoviesDto(
    @Json(name = "results") val moviesDto: List<MovieDtoBean>
)

class MovieDtoBean(
    val id: Int,
    val overview: String,
    val popularity: Double,
    val posterPath: Int,
    val releaseDate: String,
    val title: String
)


fun MovieDtoBean.mapToDomain(): MovieModel = MovieModel(
    id = id.toLong(),
    title = title,
    overview = overview,
    popularity = popularity,
    posterPath = posterPath,
    releaseDate = releaseDate
)

fun List<MovieDtoBean>.mapToDomain(): List<MovieModel> = map { it.mapToDomain() }
