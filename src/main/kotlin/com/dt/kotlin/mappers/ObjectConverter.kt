package com.dt.kotlin.mappers

import com.dt.kotlin.daos.entities.InstanceEntity
import com.dt.kotlin.dtos.Instance

/**
 * @author shashankmittal
 * @created 15/10/19
 */
fun Instance.toInstanceEntity(): InstanceEntity {

    var instanceEntity = InstanceEntity()

    instanceEntity.name = this.name ?: ""
    instanceEntity.description = this.description
    instanceEntity.type = this.type
    instanceEntity.version = this.type

    return instanceEntity
}

fun InstanceEntity.toInstance(): Instance {

    var instance = Instance(this.id.toString())

    instance.name = this.name
    instance.description = this.description
    instance.type = this.type
    instance.version = this.type

    return instance
}
