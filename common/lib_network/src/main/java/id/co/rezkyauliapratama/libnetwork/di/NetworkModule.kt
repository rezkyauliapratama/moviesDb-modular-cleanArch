package id.co.rezkyauliapratama.libnetwork.di

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import id.co.rezkyauliapratama.libnetwork.getHttpClientBuilder
import id.co.rezkyauliapratama.libnetwork.getMoshi
import id.co.rezkyauliapratama.libnetwork.getRetrofit
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
