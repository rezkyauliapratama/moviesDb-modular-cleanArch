package id.co.rezkyauliapratama.featurehome.presenter.popularmovie.controller

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import id.co.rezkyauliapratama.featurehome.domain.viewmodel.PopularMovieViewModel
import id.co.rezkyauliapratama.featurehome.presenter.model.PopularMovieResult
import id.co.rezkyauliapratama.featurehome.presenter.popularmovie.view.PopularMovieViewMvc
import id.co.rezkyauliapratama.libcore.presenter.common.Resource
import id.co.rezkyauliapratama.libcore.presenter.common.ResourceState
import id.co.rezkyauliapratama.libcore.presenter.common.SafeObserver
import id.co.rezkyauliapratama.libcore.presenter.controllers.BaseViewModelController
import timber.log.Timber

class PopularMovieController : BaseViewModelController<PopularMovieViewMvc, PopularMovieViewModel>(),
    PopularMovieViewMvc.Listener {

    override fun bind(viewMvc: PopularMovieViewMvc, viewModel: PopularMovieViewModel, lifecycle: LifecycleOwner) {
        mViewMvc = viewMvc
        mViewModel = viewModel
        mLifecycle = lifecycle
    }

    override fun initLiveDataObservers() {
        super.initLiveDataObservers()
        mViewModel.moviesList.observe(mLifecycle, SafeObserver(this::handleStateResult))
    }

    private fun handleStateResult(resource: Resource<List<PopularMovieResult>>) {
        when (resource.state) {
            ResourceState.LOADING -> {
                if (resource.data == null) {
                    mViewMvc.showProgressBarPage()
                }
            }
            ResourceState.SUCCESS -> mViewMvc.hideProgressBarPage()
            ResourceState.ERROR -> {
                mViewMvc.displayError(resource.throwable)
            }
        }
        resource.data?.apply {
            mViewMvc.submitList(this)
        }
    }


    override fun onStart() {
        super.onStart()
        mViewMvc.registerListener(this)
    }

    override fun onStop() {
        super.onStop()
        mViewMvc.unregisterListener(this)
    }

}
