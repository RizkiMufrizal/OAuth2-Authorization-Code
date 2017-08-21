package org.rizki.mufrizal.auth.server.domain.oauth2

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.GenerationType
import javax.persistence.GeneratedValue
import javax.persistence.Id


/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 20 August 2017
 * @Time 6:05 PM
 * @Project Starter-BackEnd
 * @Package org.rizki.mufrizal.starter.backend.domain.oauth2
 * @File OAuth2Code
 *
 */
@Entity
@Table(name = "oauth_code")
data class OAuth2Code(

        @Id
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Int? = null,

        @Column(name = "code")
        val code: String? = null,

        @Column(name = "authentication", columnDefinition = "BLOB")
        val authentication: ByteArray? = null
)