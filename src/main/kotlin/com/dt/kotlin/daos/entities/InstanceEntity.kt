package com.dt.kotlin.daos.entities

import javax.persistence.*

/**
 * @author shashankmittal
 * @created 15/10/19
 */

@Entity(name = "instance")
data class InstanceEntity(@Column(name = "id")
                          @Id
                          @GeneratedValue(strategy = GenerationType.AUTO)
                          var id: Long = -1) : BaseEntity() {

    @Column(name = "name", unique = true, nullable = false)
    var name: String = ""

    @Column(name = "description")
    var description: String? = null

    @Column(name = "type")
    var type: String? = null

    @Column(name = "version")
    var version: String? = null

    constructor(id: Long, name: String, description: String, type: String, version: String) : this(id) {
        this.name = name
        this.description = description
        this.type = type
        this.version = version
    }
}