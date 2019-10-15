package com.dt.kotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [SecurityAutoConfiguration::class])
class KotlinStarterApplication

fun main(args: Array<String>) {
	runApplication<KotlinStarterApplication>(*args)
}
