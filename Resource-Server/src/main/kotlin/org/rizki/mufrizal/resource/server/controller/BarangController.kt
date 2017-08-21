package org.rizki.mufrizal.resource.server.controller

import org.rizki.mufrizal.resource.server.helpers.HateoasResource
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo
import org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn
import org.springframework.http.HttpStatus

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 21 August 2017
 * @Time 12:56 PM
 * @Project Resource-Server
 * @Package org.rizki.mufrizal.resource.server.controller
 * @File BarangController
 *
 */
@RestController
@RequestMapping(value = "/api")
class BarangController {

    @GetMapping(value = "/barangs")
    fun getBarangs(): ResponseEntity<*> {
        val map = listOf("Aqua", "Rinso")
        val hateoasResource = HateoasResource(map)
        hateoasResource.add(linkTo(methodOn(BarangController::class.java).getBarangs()).withSelfRel())
        return ResponseEntity(hateoasResource, HttpStatus.OK)
    }

}