package id.co.rezkyauliapratama.feature_home.presenter.popularmovie.controller

import androidx.lifecycle.Lifecycle
import id.co.rezkyauliapratama.feature_home.domain.viewmodel.PopularMovieViewModel
import id.co.rezkyauliapratama.feature_home.presenter.popularmovie.view.PopularMovieViewMvc
import id.co.rezkyauliapratama.lib_presenter.presenter.controllers.BaseController

class PopularMovieController : BaseController<PopularMovieViewMvc, PopularMovieViewModel>(), PopularMovieViewMvc.Listener {

    override fun onClickItemMovie() {

    }

    override fun bind(viewMvc: PopularMovieViewMvc, viewModel: PopularMovieViewModel, lifecycle: Lifecycle) {
        mViewMvc = viewMvc
        mViewModel = mViewModel
        mLifecycle = lifecycle
        mLifecycle.addObserver(this)
    }

    override fun registerListener() {
        super.registerListener()
        mViewMvc.registerListener(this)
    }

    override fun unRegisterListener() {
        super.unRegisterListener()
        mViewMvc.unregisterListener(this)
    }
}