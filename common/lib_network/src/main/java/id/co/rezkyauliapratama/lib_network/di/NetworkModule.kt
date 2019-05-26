package id.co.rezkyauliapratama.lib_network.di

import id.co.rezkyauliapratama.lib_network.getHttpClientBuilder
import id.co.rezkyauliapratama.lib_network.getMoshi
import id.co.rezkyauliapratama.lib_network.getRetrofit
import org.koin.core.module.Module
import org.koin.dsl.module

val networkModule: Module = module {

    //provide moshi
    factory { getMoshi() }

    //provide okhttp client
    single { getHttpClientBuilder(interceptors = get()) }

    //provide retrofit
    single { (url: String) -> getRetrofit(okHttpClient = get(), moshi = get(), url = url) }

}

