package id.co.rezkyauliapratama.featurehome.data.datasource.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import id.co.rezkyauliapratama.featurehome.domain.model.MovieModel

@JsonClass(generateAdapter = true)
class ListMoviesDto(
    @Json(name = "page") val page: Int,
    @Json(name = "results") val moviesDto: List<MovieDtoBean>,
    @Json(name = "total_pages") val totalPages: Int,
    @Json(name = "total_results") val totalResults: Int
)

class MovieDtoBean(
    @Json(name = "adult")
    val adult: Boolean,
    @Json(name = "backdrop_path")
    val backdropPath: String,
    @Json(name = "genre_ids")
    val genreIds: List<Int>,
    @Json(name = "id")
    val id: Int,
    @Json(name = "original_language")
    val originalLanguage: String,
    @Json(name = "original_title")
    val originalTitle: String,
    @Json(name = "overview")
    val overview: String,
    @Json(name = "popularity")
    val popularity: Double,
    @Json(name = "poster_path")
    val posterPath: String,
    @Json(name = "release_date")
    val releaseDate: String,
    @Json(name = "title")
    val title: String,
    @Json(name = "video")
    val video: Boolean,
    @Json(name = "vote_average")
    val voteAverage: Double,
    @Json(name = "vote_count")
    val voteCount: Int
)


fun MovieDtoBean.mapToDomain(): MovieModel = MovieModel(
    backdropPath = backdropPath,
    genreIds = genreIds,
    originalTitle = originalTitle,
    overview = overview,
    popularity = popularity,
    posterPath = posterPath,
    releaseDate = releaseDate,
    video = video,
    voteAverage = voteAverage,
    voteCount = voteCount
)

fun List<MovieDtoBean>.mapToDomain(): List<MovieModel> = map { it.mapToDomain() }
