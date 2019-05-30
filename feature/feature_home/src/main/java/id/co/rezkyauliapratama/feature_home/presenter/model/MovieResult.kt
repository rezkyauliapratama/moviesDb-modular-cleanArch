package id.co.rezkyauliapratama.feature_home.presenter.model

data class PopularMovieView (
    val genreIds: List<Int>,
    val originalTitle: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
    val voteAverage: Double,
    val voteCount: Int
)