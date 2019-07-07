package id.co.rezkyauliapratama.featurehome.presenter.detailpopularmovie

import android.view.ViewGroup
import id.co.rezkyauliapratama.featurehome.presenter.common.ViewMvcFactory
import id.co.rezkyauliapratama.featurehome.presenter.detailpopularmovie.controller.DetailPopularMovieController
import id.co.rezkyauliapratama.featurehome.presenter.detailpopularmovie.view.DetailPopularMovieViewMvc
import id.co.rezkyauliapratama.libcore.presenter.controllers.BaseFragment
import id.co.rezkyauliapratama.featurehome.di.DaggerFeatureHomeComponent
import id.co.rezkyauliapratama.featurehome.presenter.model.PopularMovieResult
import id.co.rezkyauliapratama.libcore.di.CoreInjectHelper.provideCoreComponent
import id.co.rezkyauliapratama.libcore.di.PresenterModule


class DetailMovieFragment : BaseFragment<ViewMvcFactory,DetailPopularMovieController,DetailPopularMovieViewMvc>() {

    override fun injectDI() {
        DaggerFeatureHomeComponent
            .builder()
            .coreComponent(provideCoreComponent(requireActivity().applicationContext))
            .presenterModule(PresenterModule(requireActivity()))
            .build()
            .inject(this)
    }



    override fun initView(container: ViewGroup?) {
        mViewMvc = mViewMvcFactory.getDetailPopularMoviewViewMvc(container)
        val popularMovieResult: PopularMovieResult? = arguments?.getParcelable("DataResult")
        mController.bind(mViewMvc,popularMovieResult)
    }
}