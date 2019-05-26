package id.co.rezkyauliapratama.lib_presenter.di

import id.co.rezkyauliapratama.lib_presenter.data.executors.JobExecutor
import id.co.rezkyauliapratama.lib_presenter.domain.executors.PostExecutionThread
import id.co.rezkyauliapratama.lib_presenter.domain.executors.ThreadExecutor
import id.co.rezkyauliapratama.lib_presenter.presenter.UIThread
import org.koin.core.module.Module
import org.koin.dsl.module


val schedulerModule: Module = module {

    single { JobExecutor() as ThreadExecutor }

    factory { UIThread() as PostExecutionThread }
}