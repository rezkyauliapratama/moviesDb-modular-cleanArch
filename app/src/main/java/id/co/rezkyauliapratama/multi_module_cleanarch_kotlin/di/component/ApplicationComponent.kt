package id.co.rezkyauliapratama.multi_module_cleanarch_kotlin.di.component

import dagger.Component
import id.co.rezkyauliapratama.lib_network.di.NetworkModule
import id.co.rezkyauliapratama.multi_module_cleanarch_kotlin.di.module.ApplicationModule
import id.co.rezkyauliapratama.multi_module_cleanarch_kotlin.di.module.InterceptorModule
import javax.inject.Singleton

@Component(modules = [ NetworkModule::class, ApplicationModule::class, InterceptorModule::class])
@Singleton
interface AppComponent {

}