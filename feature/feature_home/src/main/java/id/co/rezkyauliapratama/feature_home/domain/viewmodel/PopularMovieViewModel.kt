package id.co.rezkyauliapratama.feature_home.domain.viewmodel

import id.co.rezkyauliapratama.feature_home.domain.usecase.GetPopularMovie
import id.co.rezkyauliapratama.feature_home.presenter.model.PopularMovieResult
import id.co.rezkyauliapratama.lib_core.presenter.common.*
import id.co.rezkyauliapratama.lib_core.presenter.viewmodels.BaseViewModel
import id.co.rezkyauliapratama.lib_core.presenter.viewmodels.SingleLiveEvent
import javax.inject.Inject

class PopularMovieViewModel @Inject constructor(
    private val getPopularMovie: GetPopularMovie
) : BaseViewModel() {

    val popularMovieLiveData = SingleLiveEvent<Resource<List<PopularMovieResult>>>()

    private val movieList: MutableList<PopularMovieResult> = mutableListOf()
    private var initialPage: Int = 0
    private var isDataAvailable: Boolean = true

    override fun loadPage(multipleTimes: Boolean?) {
        super.loadPage(multipleTimes)
        if (initialPage > 0) initialPage = 0
        popularMovieLiveData.setLoading()
        fetchPopularMovies()
    }

    private fun fetchPopularMovies() {
        if (isDataAvailable) {
            initialPage++

            getPopularMovie
                .execute(
                    mapOf(
                        GetPopularMovie.pageNum to initialPage
                    )
                )
                .subscribe(::handlePopularMovies, ::handlePopularMoviesError).track()
        }
    }

    private fun handlePopularMoviesError(throwable: Throwable) {
        popularMovieLiveData.setError(throwable)
    }

    private fun handlePopularMovies(popularMovies: List<PopularMovieResult>) {
        if (popularMovies.isNotEmpty()) {
            popularMovieLiveData.setSuccess(popularMovies)
            movieList.addAll(
                popularMovies
            )

        } else {
            popularMovieLiveData.setEmpty()
            isDataAvailable = false
        }
    }
}
