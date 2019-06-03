package id.co.rezkyauliapratama.feature_home.domain.viewmodel

import androidx.lifecycle.MutableLiveData
import id.co.rezkyauliapratama.feature_home.domain.usecase.GetPopularMovie
import id.co.rezkyauliapratama.feature_home.presenter.model.PopularMovieView
import id.co.rezkyauliapratama.lib_uicomponent.presenter.common.Resource
import id.co.rezkyauliapratama.lib_uicomponent.presenter.common.ResourceState
import id.co.rezkyauliapratama.lib_uicomponent.presenter.viewmodels.BaseViewModel
import javax.inject.Inject

class PopularMovieViewModel @Inject constructor(
    private val getPopularMovie: GetPopularMovie
) : BaseViewModel() {

    val popularMovieLiveData = MutableLiveData<Resource<List<PopularMovieView>>>()

    private val movieList: MutableList<PopularMovieView> = mutableListOf()
    private var initialPage: Int = 0
    private var isDataAvailable: Boolean = true

    override fun loadPage(multipleTimes: Boolean?) {
        super.loadPage(multipleTimes)
        if (initialPage > 0) initialPage = 0
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
        popularMovieLiveData.value = Resource(ResourceState.ERROR, throwable = throwable)
    }

    private fun handlePopularMovies(popularMovies: List<PopularMovieView>) {
        if (popularMovies.isNotEmpty()) {
            popularMovieLiveData.value = Resource(ResourceState.SUCCESS, popularMovies)
            movieList.addAll(
                popularMovies
            )

        } else {
            popularMovieLiveData.value = Resource(ResourceState.SUCCESS)
            isDataAvailable = false
        }
    }
}
