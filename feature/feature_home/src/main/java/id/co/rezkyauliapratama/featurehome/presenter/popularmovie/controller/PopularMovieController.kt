package id.co.rezkyauliapratama.featurehome.presenter.popularmovie.controller

import androidx.lifecycle.LifecycleOwner
import androidx.paging.PagedList
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
        mViewModel.moviesList.observe(mLifecycle, SafeObserver(this::handleMoviesResult))
        mViewModel.getState().observe(mLifecycle, SafeObserver(this::handleStateResult))
    }

    private fun handleStateResult(resourceState: Resource<List<PopularMovieResult>>) {
        mViewMvc.submitState(resourceState)

        when (resourceState.state) {
            ResourceState.LOADING -> {
                if (resourceState.data == null) {
                    mViewMvc.showProgressBarPage()
                }
            }
            ResourceState.SUCCESS -> mViewMvc.hideProgressBarPage()
            ResourceState.ERROR -> {
                Timber.e("handleStateResult error : ${resourceState.throwable}")
                mViewMvc.displayError(resourceState.throwable)
            }
        }
    }

    private fun handleMoviesResult(pagedList: PagedList<PopularMovieResult>) {
        mViewMvc.submitList(pagedList)
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


    override fun onClickItemMovie() {

    }
}
