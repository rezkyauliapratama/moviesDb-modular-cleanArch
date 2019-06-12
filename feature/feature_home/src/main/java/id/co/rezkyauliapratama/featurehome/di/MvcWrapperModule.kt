package id.co.rezkyauliapratama.featurehome.di

import android.content.Context
import android.view.LayoutInflater
import dagger.Module
import dagger.Provides
import id.co.rezkyauliapratama.featurehome.presenter.common.ViewMvcFactory
import id.co.rezkyauliapratama.featurehome.presenter.popularmovie.adapter.controller.LoaderFooterAdapterController
import id.co.rezkyauliapratama.featurehome.presenter.popularmovie.adapter.controller.PopularMovieAdapterController
import id.co.rezkyauliapratama.featurehome.presenter.popularmovie.controller.PopularMovieController
import id.co.rezkyauliapratama.libcore.di.ActivityContext

@Module
class MvcWrapperModule {

    @Provides
    fun provideViewMvcFactory(@ActivityContext context: Context): ViewMvcFactory {
        return ViewMvcFactory(LayoutInflater.from(context))
    }

    @Provides
    fun provideMovieController(): PopularMovieController {
        return PopularMovieController()
    }

    @Provides
    fun provideMovieAdapterController(): PopularMovieAdapterController {
        return PopularMovieAdapterController()
    }

    @Provides
    fun provideLoaderFooterAdapterController(): LoaderFooterAdapterController {
        return LoaderFooterAdapterController()
    }
}

