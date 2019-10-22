package com.dt.kotlin.services.impl

import com.dt.kotlin.daos.repositories.InstanceRepository
import com.dt.kotlin.dtos.Instance
import com.dt.kotlin.mappers.toInstance
import com.dt.kotlin.mappers.toInstanceEntity
import com.dt.kotlin.services.api.InstanceService
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * @author shashankmittal
 * @created 15/10/19
 */
@Service
class InstanceServiceImpl : InstanceService {

    @Autowired
    lateinit var instanceRepository: InstanceRepository

    override fun getAllInstances() = instanceRepository.findAllByStatus(true).map { it.toInstance() }

    override fun getInstanceById(id: Long) = instanceRepository.findByIdAndStatus(id, true).toInstance()

    override fun createInstance(instance: Instance) = instanceRepository.save(instance.toInstanceEntity()).toInstance()

    override fun updateInstance(id: Long, instance: Instance): Instance {
//        TODO:findByIdAndStatus throws EmptyResultDataAccessException if resource not found

        val findByIdAndStatus = instanceRepository.findByIdAndStatus(id)

        BeanUtils.copyProperties(instance, findByIdAndStatus)

        return instanceRepository.save(findByIdAndStatus).toInstance()
    }
}