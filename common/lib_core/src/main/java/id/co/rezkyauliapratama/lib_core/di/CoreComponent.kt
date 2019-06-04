package id.co.rezkyauliapratama.lib_core.di

import android.app.Application
import com.squareup.moshi.Moshi
import dagger.Component
import id.co.rezkyauliapratama.lib_core.domain.executors.PostExecutionThread
import id.co.rezkyauliapratama.lib_core.domain.executors.ThreadExecutor
import id.co.rezkyauliapratama.lib_network.common.NetworkErrorInterface
import id.co.rezkyauliapratama.lib_network.di.NetworkModule
import retrofit2.Retrofit
import javax.inject.Singleton

@Component(modules = [SchedulerModule::class, CoreModule::class, NetworkModule::class])
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
        fun schedulerModule(module: SchedulerModule): Builder
        fun networkModule(module: NetworkModule): Builder
    }

}
