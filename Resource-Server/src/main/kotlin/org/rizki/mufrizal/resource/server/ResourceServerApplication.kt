package org.rizki.mufrizal.resource.server

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.hateoas.config.EnableHypermediaSupport

@SpringBootApplication
@EnableHypermediaSupport(type = arrayOf(EnableHypermediaSupport.HypermediaType.HAL))
class ResourceServerApplication

fun main(args: Array<String>) {
    SpringApplication.run(ResourceServerApplication::class.java, *args)
}