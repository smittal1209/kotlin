package com.dt.kotlin.daos.entities

import javax.persistence.*

/**
 * @author shashankmittal
 * @created 15/10/19
 */

@Entity(name = "instance")
class InstanceEntity : BaseEntity() {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = -1

    @Column(name = "name", unique = true, nullable = false)
    var name: String = ""

    @Column(name = "description")
    var description: String? = null

    @Column(name = "type")
    var type: String? = null

    @Column(name = "version")
    var version: String? = null
}