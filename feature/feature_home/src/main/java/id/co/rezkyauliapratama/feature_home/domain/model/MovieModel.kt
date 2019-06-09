package id.co.rezkyauliapratama.feature_home.domain.model

import id.co.rezkyauliapratama.feature_home.presenter.model.PopularMovieResult

data class MovieModel(
    val backdropPath: String,
    val genreIds: List<Int>,
    val originalTitle: String,
    val popularity: Double,
    val overview: String,
    val posterPath: String,
    val releaseDate: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int
)

fun MovieModel.mapToPopularMovie(): PopularMovieResult =
    PopularMovieResult(
        genreIds = genreIds,
        originalTitle = originalTitle,
        voteCount = voteCount,
        voteAverage = voteAverage,
        releaseDate = releaseDate,
        posterPath = posterPath,
        backdropPath = backdropPath,
        popularity = popularity
    )

fun List<MovieModel>.mapToPopularMovieList() : List<PopularMovieResult> = map { it.mapToPopularMovie() }

