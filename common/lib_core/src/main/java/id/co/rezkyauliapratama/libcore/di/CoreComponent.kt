package id.co.rezkyauliapratama.libcore.di

import android.app.Application
import com.squareup.moshi.Moshi
import dagger.Component
import id.co.rezkyauliapratama.libcore.domain.executors.PostExecutionThread
import id.co.rezkyauliapratama.libcore.domain.executors.ThreadExecutor
import id.co.rezkyauliapratama.libnetwork.common.NetworkErrorInterface
import id.co.rezkyauliapratama.libnetwork.di.NetworkModule
import retrofit2.Retrofit
import javax.inject.Singleton

@Component(modules = [SchedulersModule::class, CoreModule::class, NetworkModule::class])
@Singleton
interface CoreComponent {
    fun getBaseResponse(): NetworkErrorInterface
    fun getThreadExecutor(): ThreadExecutor
    fun getPostExecutionThread(): PostExecutionThread
    fun getRetrofit(): Retrofit
    fun getMoshi(): Moshi
    @ApiKey
    fun getApiKey(): String

    fun inject(app: Application)

    @Component.Builder
    interface Builder {
        fun build(): CoreComponent
        fun coreModule(module: CoreModule): Builder
        fun schedulerModule(module: SchedulersModule): Builder
        fun networkModule(module: NetworkModule): Builder
    }

}
