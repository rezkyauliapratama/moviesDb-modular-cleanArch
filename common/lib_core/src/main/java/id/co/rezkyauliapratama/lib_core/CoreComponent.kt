package id.co.rezkyauliapratama.lib_core

import dagger.Component
import id.co.rezkyauliapratama.lib_network.di.NetworkModule
import id.co.rezkyauliapratama.lib_uicomponent.di.GlideModule
import id.co.rezkyauliapratama.lib_uicomponent.di.SchedulerModule
import javax.inject.Singleton

@Singleton
@Component(modules = [SchedulerModule::class, NetworkModule::class])
class CoreComponent {

}