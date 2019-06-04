package id.co.rezkyauliapratama.lib_core.baseapi

import com.squareup.moshi.Json
import id.co.rezkyauliapratama.lib_network.common.NetworkErrorInterface

class BaseResponse : NetworkErrorInterface {
    override fun getDirectUrl(): String? {
        return ""
    }

    override fun getMessage(): String {
        return statusMessage
    }

    @Json(name = "status_code") var statusCode: Int = 0
    @Json(name = "status_message") val statusMessage: String = ""
    @Json(name = "status_success") val statusSuccess: Boolean = false
}