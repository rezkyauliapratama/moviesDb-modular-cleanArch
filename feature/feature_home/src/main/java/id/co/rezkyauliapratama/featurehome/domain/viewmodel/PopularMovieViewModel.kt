package id.co.rezkyauliapratama.featurehome.domain.viewmodel

import id.co.rezkyauliapratama.libcore.presenter.common.Resource
import id.co.rezkyauliapratama.featurehome.domain.usecase.GetPopularMovie
import id.co.rezkyauliapratama.featurehome.presenter.model.PopularMovieResult
import id.co.rezkyauliapratama.libcore.presenter.common.setError
import id.co.rezkyauliapratama.libcore.presenter.common.setLoading
import id.co.rezkyauliapratama.libcore.presenter.common.setSuccess
import id.co.rezkyauliapratama.libcore.presenter.viewmodels.BaseViewModel
import id.co.rezkyauliapratama.libcore.presenter.viewmodels.SingleLiveEvent
import javax.inject.Inject

class PopularMovieViewModel @Inject constructor(
    val getPopularMovie: GetPopularMovie
) : BaseViewModel() {

    val moviesList: SingleLiveEvent<Resource<List<PopularMovieResult>>> = SingleLiveEvent()

    override fun loadPage(multipleTimes: Boolean?) {
        super.loadPage(multipleTimes)
        moviesList.setLoading()
        getPopularMovie.execute().subscribe(
            {
                moviesList.setSuccess(it)
            },
            {
                moviesList.setError(it)
            }
        ).track()
    }

}
