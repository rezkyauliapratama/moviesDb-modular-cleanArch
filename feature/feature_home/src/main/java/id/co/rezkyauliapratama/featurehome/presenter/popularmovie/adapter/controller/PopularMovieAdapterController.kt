package id.co.rezkyauliapratama.featurehome.presenter.popularmovie.adapter.controller

import id.co.rezkyauliapratama.featurehome.presenter.popularmovie.adapter.model.RowPopularMovieResult
import id.co.rezkyauliapratama.featurehome.presenter.popularmovie.adapter.view.PopularMovieAdapterViewMvc
import id.co.rezkyauliapratama.libcore.presenter.controllers.adapter.BaseAdapterController
import timber.log.Timber

class PopularMovieAdapterController : BaseAdapterController<PopularMovieAdapterViewMvc>(),
    PopularMovieAdapterViewMvc.Listener {

    override fun bindViewAndRegistenerListener(viewMvc: PopularMovieAdapterViewMvc) {
        mViewMvc = viewMvc
        mViewMvc.registerListener(this)
    }

    fun bindData(rowPopularMovieResult: RowPopularMovieResult, position: Int) {
        mViewMvc.bindMovies(rowPopularMovieResult, position)
    }

    override fun onMovieItemClicked(position: Int) {
        Timber.e("onMovieItemClicked $position")
    }


}