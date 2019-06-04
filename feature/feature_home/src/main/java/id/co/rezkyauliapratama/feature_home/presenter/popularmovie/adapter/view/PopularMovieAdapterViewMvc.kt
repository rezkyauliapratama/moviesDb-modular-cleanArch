package id.co.rezkyauliapratama.feature_home.presenter.popularmovie.adapter.view

import id.co.rezkyauliapratama.feature_home.presenter.model.PopularMovieView
import id.co.rezkyauliapratama.lib_core.presenter.views.ObservableViewMvc

interface PopularMovieAdapterViewMvc : ObservableViewMvc<PopularMovieAdapterViewMvc.Listener> {

    interface Listener {
        fun onMovieItemClicked(position: Int)
    }

    fun bindMovies(popularMoveView: PopularMovieView, position: Int)
}
