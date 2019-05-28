package id.co.rezkyauliapratama.lib_network.di

import id.co.rezkyauliapratama.lib_network.getHttpClientBuilder
import id.co.rezkyauliapratama.lib_network.getMoshi
import id.co.rezkyauliapratama.lib_network.getRetrofit
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

val networkModule: Module = module {

    //provide apiKey
    factory(named(DI_API_KEY)) { "b77a9c9af1b4434dcbbacdde72879e7c" }
    //provide moshi
    factory { getMoshi() }

    //provide okhttp client
    single { getHttpClientBuilder(interceptors = get()) }

    //provide retrofit
    single { (url: String) -> getRetrofit(okHttpClient = get(), moshi = get(), url = url) }

}

const val DI_API_KEY = "apiKey"
