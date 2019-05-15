package id.co.rezkyauliapratama.network


import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val REQUEST_TIME_OUT = 20L

fun getHttpClientBuilder(interceptors: ArrayList<Interceptor>?): OkHttpClient.Builder? {
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

fun getGson() : Gson {
    return GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .setLenient()
        .create()
}

fun getRetrofit(okHttpClient: OkHttpClient, url: String, gson: Gson) : Retrofit {
    val retrofit = Retrofit.Builder()
        .baseUrl(url)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build()

    return retrofit
}

inline fun <reified T> services(retrofit: Retrofit): T {
    return retrofit.create(T::class.java)
}