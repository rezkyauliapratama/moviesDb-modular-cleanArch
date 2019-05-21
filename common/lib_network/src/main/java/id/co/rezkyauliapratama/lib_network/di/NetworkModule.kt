package id.co.rezkyauliapratama.lib_network.di

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import id.co.rezkyauliapratama.lib_network.getGson
import id.co.rezkyauliapratama.lib_network.getHttpClientBuilder
import id.co.rezkyauliapratama.lib_network.getRetrofit
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class NetworkModule(val baseUrl: String) {

    @Provides
    fun providesGson(): Gson {
        return getGson()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return getRetrofit(okHttpClient, baseUrl, gson)
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(
        interceptors: ArrayList<Interceptor>
    ): OkHttpClient.Builder {
        return getHttpClientBuilder(interceptors)
    }


}