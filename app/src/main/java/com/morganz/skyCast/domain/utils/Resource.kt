package com.morganz.skyCast.domain.utils

/**
 * Represents the result of an asynchronous operation, encapsulating success, failure, and loading states.
 * @param R The type of data returned in case of success.
 */
sealed class Resource<out R> {
    /**
     * Represents a successful result containing data of type [T].
     * @param T The type of data.
     * @property data The result data.
     */
    data class Success<out T>(val data: T) : Resource<T>()

    /**
     * Represents a failure result containing an error message, status code, and optional error body.
     * @param message A human-readable error message.
     * @param statusCode The HTTP status code associated with the failure.
     * @param body Additional information about the failure, typically the error body.
     */
    data class Error(
        val message: String?,
        val statusCode: Int? = null,
        val body: Any? = null
    ) : Resource<Nothing>()

    /**
     * Represents a loading state indicating that an operation is in progress.
     */
    data object Loading : Resource<Nothing>()
}
