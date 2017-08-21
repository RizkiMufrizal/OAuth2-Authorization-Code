package org.rizki.mufrizal.resource.server.helpers

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.hateoas.ResourceSupport

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 20 August 2017
 * @Time 8:51 PM
 * @Project Starter-BackEnd
 * @Package org.rizki.mufrizal.starter.backend.helpers
 * @File HateoasResource
 *
 */
class HateoasResource @JsonCreator
constructor(@param:JsonProperty("content") val content: Any? = null) : ResourceSupport()