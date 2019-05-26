package id.co.rezkyauliapratama.feature_home.domain.viewmodel

import id.co.rezkyauliapratama.feature_home.domain.usecase.GetPopularMovie
import id.co.rezkyauliapratama.feature_home.presenter.model.PopularMovieView
import id.co.rezkyauliapratama.lib_presenter.presenter.common.Resource
import id.co.rezkyauliapratama.lib_presenter.presenter.common.setEmpty
import id.co.rezkyauliapratama.lib_presenter.presenter.common.setLoading
import id.co.rezkyauliapratama.lib_presenter.presenter.common.setSuccess
import id.co.rezkyauliapratama.lib_presenter.presenter.viewmodels.BaseViewModel
import id.co.rezkyauliapratama.lib_presenter.presenter.viewmodels.SingleLiveEvent


class PopularMovieViewModel constructor(
    val getPopularMovie: GetPopularMovie
) : BaseViewModel() {

    internal val popularMovieLiveData = SingleLiveEvent<Resource<List<PopularMovieView>>>()

    override fun loadPage() {
        super.loadPage()

    }

    private fun fetchPopularMovies(pageNumber: Int) {
        popularMovieLiveData.setLoading()

        val map = mapOf(
            GetPopularMovie.pageNum to pageNumber
        )

        getPopularMovie
            .execute(map)
            .subscribe({
                if (it.isNotEmpty()) popularMovieLiveData.setSuccess(it) else popularMovieLiveData.setEmpty()
            }, {

            }).track()
    }

}