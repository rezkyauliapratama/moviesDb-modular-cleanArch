package id.co.rezkyauliapratama.featurehome.presenter.popularmovie.adapter.model

import id.co.rezkyauliapratama.featurehome.BuildConfig
import id.co.rezkyauliapratama.featurehome.presenter.model.PopularMovieResult
import javax.inject.Inject

class RowPopularMovieResult(private val popularMovieResult: PopularMovieResult) {
    fun getOriginalTitle() = popularMovieResult.originalTitle
    fun getVoteAverage() = popularMovieResult.voteAverage.toString()
    fun getThumnailImage() =
        StringBuilder().append(BuildConfig.IMAGE_BASE_URL).append(popularMovieResult.backdropPath).toString()

    class Factory @Inject constructor() {
        fun create(popularMovieResult: PopularMovieResult): RowPopularMovieResult {
            return RowPopularMovieResult(popularMovieResult)
        }
    }
}
