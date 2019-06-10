package id.co.rezkyauliapratama.featurehome.presenter.popularmovie

import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import id.co.rezkyauliapratama.featurehome.di.DaggerFeatureHomeComponent
import id.co.rezkyauliapratama.featurehome.domain.viewmodel.PopularMovieViewModel
import id.co.rezkyauliapratama.featurehome.presenter.common.ViewMvcFactory
import id.co.rezkyauliapratama.featurehome.presenter.popularmovie.adapter.PopularMoviesAdapter
import id.co.rezkyauliapratama.featurehome.presenter.popularmovie.controller.PopularMovielController
import id.co.rezkyauliapratama.featurehome.presenter.popularmovie.view.PopularMovieViewMvc
import id.co.rezkyauliapratama.libcore.di.CoreInjectHelper
import id.co.rezkyauliapratama.libcore.di.PresenterModule
import id.co.rezkyauliapratama.libcore.presenter.controllers.BaseViewModelFragment
import javax.inject.Inject

class PopularMovieFragment :
    BaseViewModelFragment<ViewMvcFactory, PopularMovieViewModel, PopularMovielController, PopularMovieViewMvc>() {

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

    @Inject
    lateinit var popularMoviesAdapter: PopularMoviesAdapter


    override fun initView(container: ViewGroup?) {
        mViewMvc = mViewMvcFactory.getPopularMoviesViewMvc(container, popularMoviesAdapter)
        mController.bind(mViewMvc, viewModel, viewLifecycleOwner)
    }

}
