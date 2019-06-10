package id.co.rezkyauliapratama.featurehome.presenter.model

data class PopularMovieResult (
    val genreIds: List<Int>,
    val originalTitle: String,
    val popularity: Double,
    val posterPath: String,
    val backdropPath: String,
    val releaseDate: String,
    val voteAverage: Double,
    val voteCount: Int
)