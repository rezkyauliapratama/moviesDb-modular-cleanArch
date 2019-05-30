package id.co.rezkyauliapratama.lib_presenter.di

import android.view.LayoutInflater
import com.bumptech.glide.Glide
import id.co.rezkyauliapratama.lib_presenter.data.executors.JobExecutor
import id.co.rezkyauliapratama.lib_presenter.domain.executors.PostExecutionThread
import id.co.rezkyauliapratama.lib_presenter.domain.executors.ThreadExecutor
import id.co.rezkyauliapratama.lib_presenter.presenter.UIThread
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

val viewFactory: Module = module {
    factory { LayoutInflater.from(androidContext()) }

}

val glideModule: Module = module {

    factory { Glide.with(androidContext()) }
}

val schedulerModule: Module = module {

    single { JobExecutor() as ThreadExecutor }

    factory { UIThread() as PostExecutionThread }
}