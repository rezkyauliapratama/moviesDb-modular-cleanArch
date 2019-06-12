package id.co.rezkyauliapratama.featurehome.presenter.popularmovie.view

import androidx.paging.PagedList
import id.co.rezkyauliapratama.featurehome.presenter.model.PopularMovieResult
import id.co.rezkyauliapratama.libcore.presenter.common.Resource
import id.co.rezkyauliapratama.libcore.presenter.views.ObservableViewMvc

interface PopularMovieViewMvc : ObservableViewMvc<PopularMovieViewMvc.Listener> {

    interface Listener {
        fun onClickItemMovie()
    }

    fun showProgressBarPage()
    fun hideProgressBarPage()
    fun submitList(pagedList: PagedList<PopularMovieResult>)
    fun submitState(resourceState: Resource<List<PopularMovieResult>>)
    fun displayError(throwable: Throwable?)
}
