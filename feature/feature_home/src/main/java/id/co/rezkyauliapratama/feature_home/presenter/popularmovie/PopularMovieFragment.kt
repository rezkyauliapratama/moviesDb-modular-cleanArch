package id.co.rezkyauliapratama.feature_home.presenter.popularmovie

import android.view.ViewGroup
import id.co.rezkyauliapratama.feature_home.di.injectFeature
import id.co.rezkyauliapratama.feature_home.domain.viewmodel.PopularMovieViewModel
import id.co.rezkyauliapratama.feature_home.presenter.common.ViewMvcFactory
import id.co.rezkyauliapratama.feature_home.presenter.popularmovie.controller.PopularMovieController
import id.co.rezkyauliapratama.feature_home.presenter.popularmovie.view.PopularMovieViewMvc
import id.co.rezkyauliapratama.lib_presenter.presenter.controllers.BaseViewModelFragment
import org.koin.androidx.viewmodel.ext.android.getViewModel

class PopularMovieFragment :
    BaseViewModelFragment<ViewMvcFactory, PopularMovieViewModel, PopularMovieController, PopularMovieViewMvc>() {

    override fun buildViewModel(): PopularMovieViewModel {
        return getViewModel()
    }

    override fun inject() {
        injectFeature()
    }

    override fun initView(container: ViewGroup?) {
        val mViewMvc = mViewMvcFactory.getPopularMoviesViewMvc(container)
        mController.bind(mViewMvc, viewModel, lifecycle)
    }

}
