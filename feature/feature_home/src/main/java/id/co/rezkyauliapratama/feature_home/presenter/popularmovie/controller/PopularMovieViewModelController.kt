package id.co.rezkyauliapratama.feature_home.presenter.popularmovie.controller

import androidx.lifecycle.LifecycleOwner
import id.co.rezkyauliapratama.feature_home.domain.viewmodel.PopularMovieViewModel
import id.co.rezkyauliapratama.feature_home.presenter.model.PopularMovieView
import id.co.rezkyauliapratama.feature_home.presenter.popularmovie.view.PopularMovieViewMvc
import id.co.rezkyauliapratama.lib_core.presenter.common.Resource
import id.co.rezkyauliapratama.lib_core.presenter.common.ResourceState
import id.co.rezkyauliapratama.lib_core.presenter.common.SafeObserver
import id.co.rezkyauliapratama.lib_core.presenter.controllers.BaseViewModelController
import timber.log.Timber

class PopularMovieViewModelController : BaseViewModelController<PopularMovieViewMvc, PopularMovieViewModel>(),
    PopularMovieViewMvc.Listener {

    override fun bind(viewMvc: PopularMovieViewMvc, viewModel: PopularMovieViewModel, lifecycle: LifecycleOwner) {
        mViewMvc = viewMvc
        mViewModel = viewModel
        mLifecycle = lifecycle
    }

    override fun initLiveDataObservers() {
        super.initLiveDataObservers()
        mViewModel.popularMovieLiveData.observe(mLifecycle, SafeObserver(this::handleMoviesResult))
    }

    override fun onStart() {
        super.onStart()
        Timber.e("controller onstart")
        mViewMvc.registerListener(this)
    }

    override fun onStop() {
        super.onStop()
        Timber.e("controller onstop")
        mViewMvc.unregisterListener(this)
    }


    private fun handleMoviesResult(resources: Resource<List<PopularMovieView>>) {
        resources.apply {
            when (state) {
                ResourceState.LOADING -> mViewMvc.showProgressBarPage()
                ResourceState.SUCCESS -> mViewMvc.hideProgressBarPage()
                ResourceState.ERROR -> mViewMvc.hideProgressBarPage()
            }
            handleMovieList(data)
        }
    }

    private fun handleMovieList(data: List<PopularMovieView>?) {

        if (data != null) {
            mViewMvc.bindPopularMovies(data)
        }
    }

    override fun onClickItemMovie() {

    }
}