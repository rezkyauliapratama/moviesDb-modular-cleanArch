package id.co.rezkyauliapratama.feature_home.di

import dagger.Component
import id.co.rezkyauliapratama.feature_home.presenter.HomeActivity
import id.co.rezkyauliapratama.feature_home.presenter.popularmovie.PopularMovieFragment
import id.co.rezkyauliapratama.lib_core.di.CoreComponent
import id.co.rezkyauliapratama.lib_core.di.FeatureScope
import id.co.rezkyauliapratama.lib_core.di.PresenterModule
import id.co.rezkyauliapratama.lib_core.di.ViewModelFactoryModule

@Component(
    modules = [
        PresenterModule::class, MvcWrapperModule::class, RepositoryModule::class,
        DataSourcesModule::class, NetworkModule::class, ViewModelModule::class,
        ViewModelFactoryModule::class
    ],
    dependencies = [CoreComponent::class]
)
@FeatureScope
interface FeatureHomeComponent {

    @Component.Builder
    interface Builder {
        fun build(): FeatureHomeComponent
        fun coreComponent(component: CoreComponent): Builder
        fun presenterModule(module: PresenterModule): Builder
    }

    fun inject(homeActivity: HomeActivity)
    fun inject(popularMovieFragment: PopularMovieFragment)
}