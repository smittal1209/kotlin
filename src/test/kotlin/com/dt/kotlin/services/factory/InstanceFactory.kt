package com.dt.kotlin.services.factory

import com.dt.kotlin.constants.*
import com.dt.kotlin.daos.entities.InstanceEntity

/**
 * @author shashankmittal
 * @created 21/10/19
 */
class InstanceFactory {

    companion object {
        fun getDummyInstanceEntityList(): List<InstanceEntity> {
            return arrayListOf<InstanceEntity>(getDummyInstanceEntity())
        }

        private fun getDummyInstanceEntity(): InstanceEntity {
            return InstanceEntity(
                    id = DUMMY_ID,
                    version = DUMMY_INSTANCE_VERSION,
                    description = DUMMY_INSTANCE_DESCRIPTION,
                    type = DUMMY_INSTANCE_TYPE,
                    name = DUMMY_INSTANCE_NAME)
        }
    }

}