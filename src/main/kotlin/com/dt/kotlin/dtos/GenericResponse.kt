package com.dt.kotlin.dtos

/**
 * @author shashankmittal
 * @created 15/10/19
 */
data class GenericResponse<T, E>(var code: String? = null) {
    var message: String? = null
    var data: T? = null
    var error: E? = null

    constructor(code: String, message: String, data: T, error: E? = null) : this(code) {
        this.message = message
        this.data = data
        this.error = error
    }
}