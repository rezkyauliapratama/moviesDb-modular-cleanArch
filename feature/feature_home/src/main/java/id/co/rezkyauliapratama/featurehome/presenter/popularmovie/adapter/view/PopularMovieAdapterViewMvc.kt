package id.co.rezkyauliapratama.featurehome.presenter.popularmovie.adapter.view

import id.co.rezkyauliapratama.featurehome.presenter.model.PopularMovieResult
import id.co.rezkyauliapratama.libcore.presenter.views.ObservableViewMvc

interface PopularMovieAdapterViewMvc : ObservableViewMvc<PopularMovieAdapterViewMvc.Listener> {

    interface Listener {
        fun onMovieItemClicked(position: Int)
    }

    fun bindMovies(popularMoveResult: PopularMovieResult, position: Int)
}
