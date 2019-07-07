package id.co.rezkyauliapratama.featurehome.presenter.popularmovie.view

import androidx.paging.PagedList
import id.co.rezkyauliapratama.featurehome.presenter.model.PopularMovieResult
import id.co.rezkyauliapratama.libcore.presenter.common.Resource
import id.co.rezkyauliapratama.libcore.presenter.views.ObservableViewMvc

interface PopularMovieViewMvc : ObservableViewMvc<PopularMovieViewMvc.Listener> {

    interface Listener

    fun showProgressBarPage()
    fun hideProgressBarPage()
    fun submitList(items: List<PopularMovieResult>)
    fun displayError(throwable: Throwable?)
}
