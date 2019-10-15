package com.dt.kotlin.daos.entities

import org.hibernate.annotations.Type
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass

/**
 * @author shashankmittal
 * @created 15/10/19
 */

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
open class BaseEntity {

    @Column(name = "created_at", updatable = false, nullable = false)
    @CreatedDate
    var createdAt: LocalDateTime = LocalDateTime.now()

    @Column(name = "updated_at", nullable = false)
    @LastModifiedDate
    var updatedAt: LocalDateTime = LocalDateTime.now()

    @Column(name = "status", nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    var status: Boolean = true

}