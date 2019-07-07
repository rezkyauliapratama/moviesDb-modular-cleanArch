package id.co.rezkyauliapratama.libcore.di

import android.app.Application
import dagger.Component
import id.co.rezkyauliapratama.libcore.domain.executors.PostExecutionThread
import id.co.rezkyauliapratama.libcore.domain.executors.ThreadExecutor
import javax.inject.Singleton

@Component(modules = [SchedulersModule::class, CoreModule::class])
@Singleton
interface CoreComponent {
    fun getThreadExecutor(): ThreadExecutor
    fun getPostExecutionThread(): PostExecutionThread

    fun inject(app: Application)

    @Component.Builder
    interface Builder {
        fun build(): CoreComponent
        fun coreModule(module: CoreModule): Builder
        fun schedulerModule(module: SchedulersModule): Builder
    }

}
