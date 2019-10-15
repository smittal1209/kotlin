package com.dt.kotlin.controllers

import com.dt.kotlin.constants.ALL
import com.dt.kotlin.constants.BASE_URL
import com.dt.kotlin.constants.ID
import com.dt.kotlin.constants.INSTANCES
import com.dt.kotlin.dtos.GenericResponse
import com.dt.kotlin.dtos.Instance
import com.dt.kotlin.facades.InstanceFacade
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * @author shashankmittal
 * @created 15/10/19
 */
@RestController
@RequestMapping(BASE_URL + INSTANCES)
class InstancesApiController {

    @Autowired
    lateinit var instanceFacade: InstanceFacade

    @GetMapping(ALL)
    fun getAllInstances(): ResponseEntity<GenericResponse<List<Instance>, Unit>> {
        val allInstances = instanceFacade.getAllInstances()

        var genericResponse: GenericResponse<List<Instance>, Unit> = GenericResponse<List<Instance>, Unit>(
                code = HttpStatus.OK.value().toString(),
                message = HttpStatus.OK.name,
                data = allInstances)

        return ResponseEntity.status(HttpStatus.OK).body(genericResponse);
    }

    @GetMapping(value = ID)
    fun getInstanceById(@PathVariable("id") id: Long): ResponseEntity<GenericResponse<Instance, Unit>> {
        val instanceById = instanceFacade.getInstanceById(id)

        var genericResponse: GenericResponse<Instance, Unit> = GenericResponse<Instance, Unit>(
                code = HttpStatus.OK.value().toString(),
                message = HttpStatus.OK.name,
                data = instanceById)

        return ResponseEntity.status(HttpStatus.OK).body(genericResponse);
    }

    @PostMapping
    fun addInstance(@RequestBody instance: Instance): ResponseEntity<GenericResponse<Instance, Unit>> {
        val createInstance = instanceFacade.createInstance(instance)

        var genericResponse: GenericResponse<Instance, Unit> = GenericResponse<Instance, Unit>(
                code = HttpStatus.CREATED.value().toString(),
                message = HttpStatus.CREATED.name,
                data = createInstance)

        return ResponseEntity.status(HttpStatus.CREATED).body(genericResponse);
    }


    @PutMapping(value = ID)
    fun updateInstance(@PathVariable("id") id: Long, @RequestBody instance: Instance): ResponseEntity<GenericResponse<Instance, Unit>> {
        val updatedInstance = instanceFacade.updateInstance(id,instance)

        var genericResponse: GenericResponse<Instance, Unit> = GenericResponse<Instance, Unit>(
                code = HttpStatus.OK.value().toString(),
                message = HttpStatus.OK.name,
                data = updatedInstance)

        return ResponseEntity.status(HttpStatus.OK).body(genericResponse);
    }
}