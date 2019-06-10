package id.co.rezkyauliapratama.libcore.di

import dagger.Module
import dagger.Provides
import id.co.rezkyauliapratama.libcore.baseapi.BaseResponse
import id.co.rezkyauliapratama.libnetwork.common.NetworkErrorInterface

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
