package id.co.rezkyauliapratama.featurehome.presenter.popularmovie.adapter.controller

import id.co.rezkyauliapratama.featurehome.presenter.popularmovie.adapter.model.RowPopularMovieResult
import id.co.rezkyauliapratama.featurehome.presenter.popularmovie.adapter.view.PopularMovieAdapterViewMvc
import id.co.rezkyauliapratama.libcore.presenter.controllers.adapter.BaseAdapterController
import timber.log.Timber

class PopularMovieAdapterController
    : BaseAdapterController<PopularMovieAdapterViewMvc, RowPopularMovieResult>(),
    PopularMovieAdapterViewMvc.Listener {

    override fun bind(viewMvc: PopularMovieAdapterViewMvc, itemData: RowPopularMovieResult?, position: Int) {
        mViewMvc = viewMvc
        mViewMvc.registerListener(this)

        if (itemData != null)
            mViewMvc.bindMovies(itemData, position)
    }


    override fun onMovieItemClicked(position: Int) {
        Timber.e("onMovieItemClicked $position")
    }

}