package id.co.rezkyauliapratama.feature_home.domain.viewmodel

import id.co.rezkyauliapratama.feature_home.domain.usecase.GetPopularMovie
import id.co.rezkyauliapratama.feature_home.presenter.model.PopularMovieView
import id.co.rezkyauliapratama.lib_presenter.presenter.common.*
import id.co.rezkyauliapratama.lib_presenter.presenter.viewmodels.BaseViewModelState
import id.co.rezkyauliapratama.lib_presenter.presenter.viewmodels.SingleLiveEvent


class PopularMovieViewModel constructor(
    private val getPopularMovie: GetPopularMovie
) : BaseViewModelState<PopularMovieState>() {

    private val popularMovieLiveData = SingleLiveEvent<Resource<List<PopularMovieView>>>()

    private val movieList: MutableList<PopularMovieView> = mutableListOf()
    private var initialPage: Int = 0
    private var isDataAvailable: Boolean = true

    init {

        stateLiveData.addLiveData(popularMovieLiveData) {
            PopularMovieState.MovieListState(it)
        }

    }

    override fun loadPage(multipleTimes: Boolean?) {
        super.loadPage(multipleTimes)
        if (initialPage > 0) initialPage = 0
        fetchPopularMovies()
    }

    private fun fetchPopularMovies() {
        if (isDataAvailable) {
            initialPage++
            popularMovieLiveData.setLoading()

            getPopularMovie
                .execute(
                    mapOf(
                        GetPopularMovie.pageNum to initialPage
                    )
                )
                .subscribe(::handlePopularMovies, ::handlePopularMoviesError).track()
        }
    }

    private fun handlePopularMoviesError(throwable: Throwable) = popularMovieLiveData.setError(throwable)

    private fun handlePopularMovies(popularMovies: List<PopularMovieView>) {
        if (popularMovies.isNotEmpty()) popularMovieLiveData.setSuccess(popularMovies).also {
            movieList.addAll(
                popularMovies
            )
        } else popularMovieLiveData.setEmpty().also { isDataAvailable = false }
    }
}

sealed class PopularMovieState {
    data class MovieListState(val resources: Resource<List<PopularMovieView>>) : PopularMovieState()
}