package com.dt.kotlin.daos.repositories

import com.dt.kotlin.daos.entities.InstanceEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * @author shashankmittal
 * @created 15/10/19
 */
@Repository
interface InstanceRepository : JpaRepository<InstanceEntity, Long> {

    fun findAllByStatus(status: Boolean = true): List<InstanceEntity>

    fun findByIdAndStatus(id: Long, status: Boolean = true): InstanceEntity
}