package id.co.rezkyauliapratama

import android.app.Application
import id.co.rezkyauliapratama.lib_core.di.*
import id.co.rezkyauliapratama.lib_network.di.NetworkModule
import id.co.rezkyauliapratama.multi_module_cleanarch_kotlin.BuildConfig
import timber.log.Timber


class App : Application(), CoreComponentProvider {

    private lateinit var coreComponent: CoreComponent

    override fun onCreate() {
        super.onCreate()
        provideCoreComponent().inject(this)

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    override fun provideCoreComponent(): CoreComponent {
        if (!this::coreComponent.isInitialized) {

            coreComponent = DaggerCoreComponent.builder()
                .coreModule(CoreModule(BuildConfig.API_KEY))
                .networkModule(NetworkModule(BuildConfig.API_BASE_URL, arrayListOf()))
                .schedulerModule(SchedulerModule())
                .build()
        }
        return coreComponent
    }

}