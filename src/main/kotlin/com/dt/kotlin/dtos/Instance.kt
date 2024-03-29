package com.dt.kotlin.dtos

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable
import javax.validation.constraints.NotBlank

/**
 * @author shashankmittal
 * @created 16/10/19
 */

data class Instance(@JsonProperty("id") var id: String? = null) : Serializable {

    @NotBlank
    @JsonProperty("name")
    var name: String? = null

    @JsonProperty("description")
    var description: String? = null

    @JsonProperty("type")
    var type: String? = null

    @JsonProperty("version")
    var version: String? = null
}