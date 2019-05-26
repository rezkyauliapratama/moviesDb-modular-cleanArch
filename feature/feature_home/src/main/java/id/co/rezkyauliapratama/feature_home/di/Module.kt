package id.co.rezkyauliapratama.feature_home.di

import id.co.rezkyauliapratama.feature_home.data.datasource.source.api.MoviesApi
import id.co.rezkyauliapratama.lib_network.services
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module


val apiModule: Module = module {
    //provide movie api
    single(named(DI_MOVIE_API)) { services<MoviesApi>(retrofit = get()) }
}

const val DI_MOVIE_API = "DI_MOVIE_API"