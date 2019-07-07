package id.co.rezkyauliapratama.featurehome.di

import dagger.Component
import id.co.rezkyauliapratama.featurehome.presenter.HomeActivity
import id.co.rezkyauliapratama.featurehome.presenter.detailpopularmovie.DetailMovieFragment
import id.co.rezkyauliapratama.featurehome.presenter.popularmovie.PopularMovieFragment
import id.co.rezkyauliapratama.libcore.di.CoreComponent
import id.co.rezkyauliapratama.libcore.di.FeatureScope
import id.co.rezkyauliapratama.libcore.di.PresenterModule
import id.co.rezkyauliapratama.libcore.di.ViewModelFactoryModule

@Component(
    modules = [
        PresenterModule::class, MvcWrapperModule::class, RepositoryModule::class,
        DataSourcesModule::class, ViewModelModule::class,
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
    fun inject(detailMovieFragment: DetailMovieFragment)
}
