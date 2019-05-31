package id.co.rezkyauliapratama.feature_home.presenter.popularmovie.controller

import androidx.lifecycle.LifecycleOwner
import id.co.rezkyauliapratama.feature_home.domain.viewmodel.PopularMovieState
import id.co.rezkyauliapratama.feature_home.domain.viewmodel.PopularMovieState.MovieListState
import id.co.rezkyauliapratama.feature_home.domain.viewmodel.PopularMovieViewModel
import id.co.rezkyauliapratama.feature_home.presenter.model.PopularMovieView
import id.co.rezkyauliapratama.feature_home.presenter.popularmovie.view.PopularMovieViewMvc
import id.co.rezkyauliapratama.lib_uicomponent.presenter.common.ResourceState
import id.co.rezkyauliapratama.lib_uicomponent.presenter.common.SafeObserver
import id.co.rezkyauliapratama.lib_uicomponent.presenter.controllers.BaseController

class PopularMovieController : BaseController<PopularMovieViewMvc, PopularMovieViewModel>(),
    PopularMovieViewMvc.Listener {

    override fun bind(viewMvc: PopularMovieViewMvc, viewModel: PopularMovieViewModel, lifecycle: LifecycleOwner) {
        mViewMvc = viewMvc
        mViewModel = viewModel
        mLifecycle = lifecycle
    }

    override fun initLiveDataObservers() {
        mViewModel.stateLiveData.observe(mLifecycle, SafeObserver(this::handleState))
    }

    override fun onStart() {
        super.onStart()
        mViewMvc.registerListener(this)
    }

    override fun onStop() {
        super.onStop()
        mViewMvc.unregisterListener(this)
    }

    private fun handleState(popularMovieState: PopularMovieState) {
        when (popularMovieState) {
            is MovieListState -> handleMovieList(popularMovieState)
        }
    }

    private fun handleMovieList(movieListState: MovieListState) {
        movieListState.resources.apply {
            when (state) {
                ResourceState.LOADING -> mViewMvc.showProgressBarPage()
                ResourceState.SUCCESS -> mViewMvc.hideProgressBarPage()
                ResourceState.ERROR -> mViewMvc.hideProgressBarPage()
            }
            handleMovieList(data)
            handleError(throwable)
        }
    }

    private fun handleMovieList(data: List<PopularMovieView>?) {
        if (data != null) {
            mViewMvc.bindPopularMovies(data)
        }
    }

    private fun handleError(throwable: Throwable?) {

    }

    override fun onClickItemMovie() {

    }
}