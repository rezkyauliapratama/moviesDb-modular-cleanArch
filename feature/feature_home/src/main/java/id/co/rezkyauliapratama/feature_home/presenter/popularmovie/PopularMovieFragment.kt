package id.co.rezkyauliapratama.feature_home.presenter.popularmovie

import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import id.co.rezkyauliapratama.feature_home.di.DaggerFeatureHomeComponent
import id.co.rezkyauliapratama.feature_home.domain.viewmodel.PopularMovieViewModel
import id.co.rezkyauliapratama.feature_home.presenter.common.ViewMvcFactory
import id.co.rezkyauliapratama.feature_home.presenter.popularmovie.controller.PopularMovieViewModelController
import id.co.rezkyauliapratama.feature_home.presenter.popularmovie.view.PopularMovieViewMvc
import id.co.rezkyauliapratama.lib_core.di.CoreInjectHelper
import id.co.rezkyauliapratama.lib_core.presenter.controllers.BaseViewModelFragment
import id.co.rezkyauliapratama.lib_core.di.PresenterModule

class PopularMovieFragment :
    BaseViewModelFragment<ViewMvcFactory, PopularMovieViewModel, PopularMovieViewModelController, PopularMovieViewMvc>() {

    override fun buildViewModel(): PopularMovieViewModel {
        return ViewModelProviders.of(this, mViewModelFactory)[PopularMovieViewModel::class.java]
    }

    override fun injectDI() {
        DaggerFeatureHomeComponent
            .builder()
            .coreComponent(CoreInjectHelper.provideCoreComponent(requireActivity().applicationContext))
            .presenterModule(PresenterModule(requireActivity()))
            .build()
            .inject(this)
    }


    override fun initView(container: ViewGroup?) {
        mViewMvc = mViewMvcFactory.getPopularMoviesViewMvc(container, mViewMvcFactory)
        mController.bind(mViewMvc, viewModel, viewLifecycleOwner)
    }

}
