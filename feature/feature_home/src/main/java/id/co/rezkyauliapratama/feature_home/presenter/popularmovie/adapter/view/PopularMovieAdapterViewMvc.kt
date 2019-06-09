package id.co.rezkyauliapratama.feature_home.presenter.popularmovie.adapter.view

import id.co.rezkyauliapratama.feature_home.presenter.popularmovie.adapter.model.RowPopularMovieResult
import id.co.rezkyauliapratama.lib_core.presenter.views.ObservableViewMvc

interface PopularMovieAdapterViewMvc : ObservableViewMvc<PopularMovieAdapterViewMvc.Listener> {

    interface Listener {
        fun onMovieItemClicked(position: Int)
    }

    fun bindMovies(popularMoveResult: RowPopularMovieResult, position: Int)
}
