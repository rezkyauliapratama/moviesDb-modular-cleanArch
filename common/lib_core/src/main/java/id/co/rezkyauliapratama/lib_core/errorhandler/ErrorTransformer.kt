package id.co.rezkyauliapratama.lib_core.errorhandler

import com.squareup.moshi.Moshi
import id.co.rezkyauliapratama.lib_network.common.NetworkErrorInterface
import id.co.rezkyauliapratama.lib_network.common.NetworkException
import id.co.rezkyauliapratama.lib_network.common.NetworkException.Companion.CODE_BAD_REQUEST
import id.co.rezkyauliapratama.lib_network.common.NetworkException.Companion.CODE_FORBIDDEN
import id.co.rezkyauliapratama.lib_network.common.NetworkException.Companion.CODE_NOT_FOUND
import id.co.rezkyauliapratama.lib_network.common.NetworkException.Companion.CODE_REDIRECT
import id.co.rezkyauliapratama.lib_network.common.NetworkException.Companion.CODE_SERVER_ERROR
import id.co.rezkyauliapratama.lib_network.common.NetworkException.Companion.CODE_UNAUTHORIZED
import id.co.rezkyauliapratama.lib_network.common.NetworkException.Companion.CODE_UNPROCESSABLE
import id.co.rezkyauliapratama.lib_network.common.RedirectException
import io.reactivex.Single
import io.reactivex.SingleSource
import io.reactivex.SingleTransformer
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.net.UnknownServiceException
import javax.inject.Inject

/**
 * @author Rezky Aulia Pratama
 *
 * This class functions to handle error that produce from Data Source
 * @param moshi is Moshi type
 * @param errorBody is class that extends NetworkErrorInterface, to handle the error that produce by Network Data Source
 *
 */
class ErrorTransformer<T> @Inject constructor(private val moshi: Moshi, private val errorBody: NetworkErrorInterface) : SingleTransformer<T, T> {

    override fun apply(upstream: Single<T>): SingleSource<T> {
        return upstream.onErrorResumeNext {
            val throwable = when (it) {
                is HttpException -> {
                    networkException(it)
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


    /**
     * @author Rezky Aulia Pratama
     * This method is to handle the Error that cause by HttpException. It'll translate the HttpException error into the generic error
     * @param httpException is HttpException
     * @return Exception
     */
    private fun networkException(httpException: HttpException): Exception {
        if (httpException.code() == CODE_REDIRECT) {
            getRedirectException(httpException)?.run {
                return this
            }
        }

        val body = httpException.response().errorBody()?.string()
        val jsonAdapter = moshi.adapter(errorBody::class.java)

        val response = body?.run { jsonAdapter.fromJson(body) }
        val message = response?.getMessage()

        return when (httpException.code()) {
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

    private fun getRedirectException(httpException: HttpException): RedirectException? {
        val url = httpException.response().headers().get(errorBody.getDirectUrl() ?: "Location")
        return url?.let { RedirectException(it) }
    }
}