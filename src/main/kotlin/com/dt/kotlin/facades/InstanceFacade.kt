package com.dt.kotlin.facades

import com.dt.kotlin.dtos.Instance

/**
 * @author shashankmittal
 * @created 15/10/19
 */
interface InstanceFacade {

    fun getAllInstances(): List<Instance>

    fun getInstanceById(id: Long): Instance

    fun createInstance(instance: Instance): Instance

    fun updateInstance(id: Long, instance: Instance): Instance
}