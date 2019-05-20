package id.co.rezkyauliapratama.lib_network.common

import com.google.gson.Gson
import id.co.rezkyauliapratama.lib_network.common.NetworkException.Companion.CODE_BAD_REQUEST
import id.co.rezkyauliapratama.lib_network.common.NetworkException.Companion.CODE_FORBIDDEN
import id.co.rezkyauliapratama.lib_network.common.NetworkException.Companion.CODE_NOT_FOUND
import id.co.rezkyauliapratama.lib_network.common.NetworkException.Companion.CODE_REDIRECT
import id.co.rezkyauliapratama.lib_network.common.NetworkException.Companion.CODE_SERVER_ERROR
import id.co.rezkyauliapratama.lib_network.common.NetworkException.Companion.CODE_UNAUTHORIZED
import id.co.rezkyauliapratama.lib_network.common.NetworkException.Companion.CODE_UNPROCESSABLE
import id.co.rezkyauliapratama.lib_network.common.`interface`.NetworkErrorInterface
import io.reactivex.Single
import io.reactivex.SingleSource
import io.reactivex.SingleTransformer
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.net.UnknownServiceException
import javax.inject.Inject

class ErrorTransformer<T> @Inject constructor(private val gson: Gson, private val errorBody : NetworkErrorInterface) : SingleTransformer<T, T> {

    override fun apply(upstream: Single<T>): SingleSource<T> {
        return upstream.onErrorResumeNext {
            val throwable = when (it) {
                is HttpException -> {
                    if (it.code() == CODE_REDIRECT) {
                        getRedirectException(it)?.run {
                            return@onErrorResumeNext Single.error(this)
                        }
                    }
                    val body = it.response().errorBody()?.string()
                    val response = gson.fromJson(body, errorBody::class.java)
                    val message = response.getMessage()

                    when (it.code()) {
                        CODE_BAD_REQUEST ->
                            NetworkException.BadRequestException(message)
                        CODE_NOT_FOUND ->
                            NetworkException.NotFoundException(message)
                        CODE_UNAUTHORIZED ->
                            NetworkException.UnauthorizedException(message)
                        CODE_FORBIDDEN ->
                            NetworkException.ForbiddenException(message)
                        CODE_UNPROCESSABLE ->
                            NetworkException.UnprocessableException(message)
                        CODE_SERVER_ERROR ->
                            NetworkException.ServerException(message)
                        else -> NetworkException.UnknownException(message)
                    }
                }
                is UnknownHostException,
                is ConnectException,
                is SocketTimeoutException,
                is UnknownServiceException -> ConnectException()
                else -> it
            }
            Single.error(throwable)
        }.map { response ->
            response
        }
    }

    private fun getRedirectException(httpException: HttpException): RedirectException? {
        val url = httpException.response().headers().get(errorBody.getDirectUrl() ?: "Location")
        return url?.let { RedirectException(it) }
    }
}