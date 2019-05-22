package id.co.rezkyauliapratama.multi_module_cleanarch_kotlin.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import id.co.rezkyauliapratama.lib_presenter.di.scope.ApplicationContext

@Module
class ApplicationModule(val application: Application) {

    @Provides
    @ApplicationContext
    fun provideContext(): Context {
        return application
    }

    @Provides
    fun provideApplication(): Application {
        return application
    }

}