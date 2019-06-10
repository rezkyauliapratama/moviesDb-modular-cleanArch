package id.co.rezkyauliapratama.lib_network.di

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import id.co.rezkyauliapratama.lib_network.getHttpClientBuilder
import id.co.rezkyauliapratama.lib_network.getMoshi
import id.co.rezkyauliapratama.lib_network.getRetrofit
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
class NetworkModule(private val url: String, private val interceptors: ArrayList<Interceptor>) {

    @Provides
    fun provideMoshi() : Moshi{
        return getMoshi()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit {
        return getRetrofit(okHttpClient, url, moshi)
    }


    @Singleton
    @Provides
    fun provideOkHttpClient(
    ): OkHttpClient {
        val clientBuilder = getHttpClientBuilder(interceptors)

        interceptors.map {
            clientBuilder.addInterceptor(it)
        }
        return clientBuilder.build()
    }

}