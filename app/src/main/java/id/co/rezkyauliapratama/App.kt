package id.co.rezkyauliapratama

import android.app.Application
import id.co.rezkyauliapratama.libcore.di.CoreComponent
import id.co.rezkyauliapratama.libcore.di.CoreComponentProvider
import id.co.rezkyauliapratama.libcore.di.CoreModule
import id.co.rezkyauliapratama.libcore.di.DaggerCoreComponent
import id.co.rezkyauliapratama.libcore.di.SchedulersModule
import id.co.rezkyauliapratama.multimodulecleanarchkotlin.BuildConfig
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
                .schedulerModule(SchedulersModule())
                .build()
        }
        return coreComponent
    }
}
