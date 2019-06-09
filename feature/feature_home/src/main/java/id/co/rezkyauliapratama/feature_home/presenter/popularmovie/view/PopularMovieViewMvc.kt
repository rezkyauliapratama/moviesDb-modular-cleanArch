package id.co.rezkyauliapratama.feature_home.presenter.popularmovie.view

import id.co.rezkyauliapratama.feature_home.presenter.model.PopularMovieResult
import id.co.rezkyauliapratama.lib_core.presenter.views.ObservableViewMvc

interface PopularMovieViewMvc : ObservableViewMvc<PopularMovieViewMvc.Listener> {

    interface Listener {
        fun onClickItemMovie()
    }

    fun bindPopularMovies(movies: List<PopularMovieResult>)
    fun showProgressBarPage()
    fun hideProgressBarPage()
}