package com.dt.kotlin.facades

import com.dt.kotlin.dtos.Instance
import com.dt.kotlin.services.api.InstanceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * @author shashankmittal
 * @created 15/10/19
 */
@Service
class InstanceFacadeImpl : InstanceFacade {

    @Autowired
    lateinit var instanceService: InstanceService

    override fun getAllInstances(): List<Instance> {
        return instanceService.getAllInstances()
    }

    override fun getInstanceById(id: Long): Instance {
        return instanceService.getInstanceById(id)
    }

    override fun createInstance(instance: Instance): Instance {
        return instanceService.createInstance(instance)
    }

    override fun updateInstance(id: Long, instance: Instance): Instance {
        return instanceService.updateInstance(id,instance)
    }
}