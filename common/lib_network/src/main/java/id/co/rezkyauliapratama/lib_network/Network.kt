package id.co.rezkyauliapratama.lib_network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

const val REQUEST_TIME_OUT = 20L

fun getHttpClientBuilder(interceptors: ArrayList<Interceptor>?): OkHttpClient.Builder {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

    val clientBuilder = OkHttpClient.Builder()
        .followRedirects(false)
        .connectTimeout(REQUEST_TIME_OUT, TimeUnit.SECONDS)
        .readTimeout(REQUEST_TIME_OUT, TimeUnit.SECONDS)
        .addInterceptor(httpLoggingInterceptor)

    interceptors?.forEach {
        if (it !is HttpLoggingInterceptor)
            clientBuilder.addInterceptor(it)
    }

    return clientBuilder
}

fun getMoshi() : Moshi {
    return Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
}

fun getRetrofit(okHttpClient: OkHttpClient, url: String, moshi: Moshi) : Retrofit {
    val retrofit = Retrofit.Builder()
        .baseUrl(url)
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build()

    return retrofit
}

inline fun <reified T> services(retrofit: Retrofit): T {
    return retrofit.create(T::class.java)
}
