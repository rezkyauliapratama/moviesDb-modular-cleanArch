package id.co.rezkyauliapratama.libnetwork.common

sealed class NetworkException(private val msg: String?) : Exception() {

    companion object {
        const val CODE_BAD_REQUEST = 400
        const val CODE_UNAUTHORIZED = 401
        const val CODE_FORBIDDEN = 403
        const val CODE_NOT_FOUND = 404
        const val CODE_UNPROCESSABLE = 422
        const val CODE_SERVER_ERROR = 500
        const val CODE_REDIRECT = 302
    }

    override val message: String?
        get() = msg

    class BadRequestException(msg : String?) : NetworkException(msg)
    class NotFoundException(msg : String?) : NetworkException(msg)
    class ForbiddenException(msg : String?) : NetworkException(msg)
    class ServerException(msg : String?) : NetworkException(msg)
    class UnauthorizedException(msg : String?) : NetworkException(msg)
    class UnprocessableException(msg : String?) : NetworkException(msg)
    class UnknownException(msg : String?) : NetworkException(msg)
}
