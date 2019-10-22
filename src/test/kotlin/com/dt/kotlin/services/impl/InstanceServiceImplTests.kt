package com.dt.kotlin.services.impl

import com.dt.kotlin.daos.repositories.InstanceRepository
import com.dt.kotlin.mappers.toInstance
import com.dt.kotlin.services.factory.InstanceFactory
import org.assertj.core.api.Java6Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

/**
 * @author shashankmittal
 * @created 21/10/19
 */
@RunWith(MockitoJUnitRunner::class)
class InstanceServiceImplTests {

    @Mock
    lateinit var instanceRepository: InstanceRepository

    @InjectMocks
    lateinit var instanceServiceImpl: InstanceServiceImpl

    @Test
    fun test_getAllInstance_success() {
        val dummyInstanceEntityList = InstanceFactory.getDummyInstanceEntityList()

        `when`(instanceRepository.findAllByStatus(true))
                .thenReturn(dummyInstanceEntityList)

        val allInstances = instanceServiceImpl.getAllInstances()

        assertThat(allInstances).isNotNull()
        assertThat(allInstances.size).isEqualTo(dummyInstanceEntityList.size)
        assertThat(dummyInstanceEntityList.map { it.toInstance() }).isEqualTo(allInstances)
    }
}