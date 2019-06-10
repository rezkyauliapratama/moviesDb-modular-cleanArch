package id.co.rezkyauliapratama.featurehome.presenter.popularmovie.view

import id.co.rezkyauliapratama.featurehome.presenter.model.PopularMovieResult
import id.co.rezkyauliapratama.libcore.presenter.views.ObservableViewMvc

interface PopularMovieViewMvc : ObservableViewMvc<PopularMovieViewMvc.Listener> {

    interface Listener {
        fun onClickItemMovie()
    }

    fun bindPopularMovies(movies: List<PopularMovieResult>)
    fun showProgressBarPage()
    fun hideProgressBarPage()
}
