package id.co.rezkyauliapratama.featurehome.di

import android.content.Context
import android.view.LayoutInflater
import dagger.Module
import dagger.Provides
import id.co.rezkyauliapratama.featurehome.presenter.common.ViewMvcFactory
import id.co.rezkyauliapratama.featurehome.presenter.popularmovie.controller.PopularMovielController
import id.co.rezkyauliapratama.libcore.di.ActivityContext

@Module
class MvcWrapperModule {

    @Provides
    fun provideViewMvcFactory(@ActivityContext context: Context): ViewMvcFactory {
        return ViewMvcFactory(LayoutInflater.from(context))
    }

    @Provides
    fun provideMovieController(): PopularMovielController {
        return PopularMovielController()
    }
}

