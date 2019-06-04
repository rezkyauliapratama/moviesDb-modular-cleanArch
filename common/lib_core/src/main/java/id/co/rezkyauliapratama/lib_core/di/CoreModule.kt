package id.co.rezkyauliapratama.lib_core.di

import dagger.Module
import dagger.Provides
import id.co.rezkyauliapratama.lib_core.baseapi.BaseResponse
import id.co.rezkyauliapratama.lib_network.common.NetworkErrorInterface

@Module
class CoreModule(private val apiKey: String) {

    @Provides
    fun provideBaseApiResponse(): NetworkErrorInterface {
        return BaseResponse()
    }

    @Provides
    @ApiKey
    fun provideApiKey(): String {
        return apiKey
    }

}