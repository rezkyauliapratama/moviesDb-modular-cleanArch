package id.co.rezkyauliapratama.feature_home.di

import id.co.rezkyauliapratama.feature_home.data.datasource.MovieDataSourceImpl
import id.co.rezkyauliapratama.feature_home.data.datasource.source.api.MoviesApi
import id.co.rezkyauliapratama.feature_home.data.datasource.source.datasource.MovieRemoteDataSource
import id.co.rezkyauliapratama.feature_home.data.repository.MovieRepositoryImpl
import id.co.rezkyauliapratama.feature_home.domain.repository.MovieRepository
import id.co.rezkyauliapratama.feature_home.domain.usecase.GetPopularMovie
import id.co.rezkyauliapratama.feature_home.presenter.model.PopularMovieView
import id.co.rezkyauliapratama.lib_network.common.ErrorTransformer
import id.co.rezkyauliapratama.lib_network.di.DI_API_KEY
import id.co.rezkyauliapratama.lib_network.services
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module
import id.co.rezkyauliapratama.feature_home.domain.viewmodel.PopularMovieViewModel
import id.co.rezkyauliapratama.lib_network.di.networkModule
import id.co.rezkyauliapratama.lib_presenter.di.schedulerModule
import org.koin.core.context.loadKoinModules

fun injectFeature() = loadFeature

private val loadFeature by lazy {
    loadKoinModules(
        viewModelModule,
        useCaseModule,
        errorTransformerModule,
        repositoryModule,
        dataSourceModule,
        apiModule,
        networkModule,
        schedulerModule
    )
}

val viewModelModule: Module = module {
    viewModel { PopularMovieViewModel(getPopularMovie = get()) }
}

val useCaseModule: Module = module {
    factory { GetPopularMovie(movieRepository = get(), errorTransformer = get(named(DI_ERROR_POPULAR_MOVIES))) }
}

val errorTransformerModule: Module = module {
    factory(named(DI_ERROR_POPULAR_MOVIES)) { ErrorTransformer<List<PopularMovieView>>() }
}

val repositoryModule: Module = module {
    single { MovieRepositoryImpl(apiKey = get(named(DI_API_KEY)), remoteSource = get()) as MovieRepository }
}

val dataSourceModule: Module = module {
    single { MovieDataSourceImpl(api = get(named(DI_MOVIE_API))) as MovieRemoteDataSource }
}

val apiModule: Module = module {
    //provide movie api
    single(named(DI_MOVIE_API)) { services<MoviesApi>(retrofit = get()) }
}

const val DI_MOVIE_API = "DI_MOVIE_API"
const val DI_ERROR_POPULAR_MOVIES = "DI_ERROR_POPULAR_MOVIES"