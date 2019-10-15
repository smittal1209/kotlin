package com.dt.kotlin.controllers

import com.dt.kotlin.constants.BASE_URL
import com.dt.kotlin.constants.PING
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = BASE_URL)
class HealthController {

    @GetMapping(value = PING)
    fun ping(): ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.OK).body("OK")
    }
}