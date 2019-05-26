package id.co.rezkyauliapratama.feature_home.data.model

import com.squareup.moshi.Json
import id.co.rezkyauliapratama.feature_home.domain.model.Movie

class ListMoviesDto(
    @field:Json(name = "page") var page: Int,
    @field:Json(name = "results") val moviesDto: List<MovieDtoBean>,
    @field:Json(name = "total_pages") val totalPages: Int,
    @field:Json(name = "total_results") val totalResults: Int
)

class MovieDtoBean(
    @field:Json(name = "adult")
    val adult: Boolean,
    @field:Json(name = "backdrop_path")
    val backdropPath: String,
    @field:Json(name = "genre_ids")
    val genreIds: List<Int>,
    @field:Json(name = "id")
    val id: Int,
    @field:Json(name = "original_language")
    val originalLanguage: String,
    @field:Json(name = "original_title")
    val originalTitle: String,
    @field:Json(name = "overview")
    val overview: String,
    @field:Json(name = "popularity")
    val popularity: Double,
    @field:Json(name = "poster_path")
    val posterPath: String,
    @field:Json(name = "release_date")
    val releaseDate: String,
    @field:Json(name = "title")
    val title: String,
    @field:Json(name = "video")
    val video: Boolean,
    @field:Json(name = "vote_average")
    val voteAverage: Double,
    @field:Json(name = "vote_count")
    val voteCount: Int
)


fun MovieDtoBean.mapToDomain(): Movie = Movie(
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

fun List<MovieDtoBean>.mapToDomain(): List<Movie> = map { it.mapToDomain() }