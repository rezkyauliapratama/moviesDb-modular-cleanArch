package id.co.rezkyauliapratama.feature_home.di

import android.content.Context
import android.view.LayoutInflater
import dagger.Module
import dagger.Provides
import id.co.rezkyauliapratama.feature_home.data.datasource.MovieDataSourceImpl
import id.co.rezkyauliapratama.feature_home.data.datasource.source.api.MoviesApi
import id.co.rezkyauliapratama.feature_home.data.datasource.source.datasource.MovieRemoteDataSource
import id.co.rezkyauliapratama.feature_home.data.repository.MovieRepositoryImpl
import id.co.rezkyauliapratama.feature_home.domain.repository.MovieRepository
import id.co.rezkyauliapratama.feature_home.presenter.common.ViewMvcFactory
import id.co.rezkyauliapratama.feature_home.presenter.popularmovie.controller.PopularMovieViewModelController
import id.co.rezkyauliapratama.lib_core.di.ApiKey
import id.co.rezkyauliapratama.lib_network.services
import id.co.rezkyauliapratama.lib_core.di.ActivityContext
import retrofit2.Retrofit

@Module
class MvcWrapperModule {

    @Provides
    fun provideViewMvcFactory(@ActivityContext context: Context): ViewMvcFactory {
        return ViewMvcFactory(LayoutInflater.from(context))
    }

    @Provides
    fun provideMovieController(): PopularMovieViewModelController {
        return PopularMovieViewModelController()
    }
}

@Module
class RepositoryModule {

    @Provides
    fun provideMovieRepository(@ApiKey apiKey: String, movieRemoteDataSource: MovieRemoteDataSource): MovieRepository {
        return MovieRepositoryImpl(apiKey, movieRemoteDataSource)
    }

}

@Module
class DataSourcesModule {

    @Provides
    fun provideMovieRemoteDataSource(moviesApi: MoviesApi): MovieRemoteDataSource {
        return MovieDataSourceImpl(moviesApi)
    }

}

@Module
class NetworkModule {

    @Provides
    fun provideMovieApiService(retrofit: Retrofit): MoviesApi {
        return services(retrofit)
    }

}