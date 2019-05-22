package id.co.rezkyauliapratama.multi_module_cleanarch_kotlin.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import id.co.rezkyauliapratama.lib_presenter.di.scope.ApplicationContext
import okhttp3.Interceptor
import javax.inject.Singleton

@Module
class InterceptorModule {

    @Singleton
    @Provides
    fun provideInterceptors(@ApplicationContext context: Context): ArrayList<Interceptor> {
        val interceptors = arrayListOf<Interceptor>()

        return interceptors
    }
}