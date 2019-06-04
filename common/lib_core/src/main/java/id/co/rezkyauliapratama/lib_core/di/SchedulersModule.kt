package id.co.rezkyauliapratama.lib_core.di

import dagger.Module
import dagger.Provides
import id.co.rezkyauliapratama.lib_core.domain.executors.PostExecutionThread
import id.co.rezkyauliapratama.lib_core.domain.executors.ThreadExecutor
import id.co.rezkyauliapratama.lib_core.presenter.UIThread
import id.co.rezkyauliapratama.lib_core.data.executors.JobExecutor

@Module
class SchedulerModule {

    @Provides
    fun providesThreadExecutor() : ThreadExecutor {
        return JobExecutor()
    }

    @Provides
    fun provides(): PostExecutionThread {
        return UIThread()
    }
}