package org.rizki.mufrizal.auth.server.domain.oauth2

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 20 August 2017
 * @Time 6:03 PM
 * @Project Starter-BackEnd
 * @Package org.rizki.mufrizal.starter.backend.domain.oauth2
 * @File OAuth2ClientToken
 *
 */
@Entity
@Table(name = "oauth_client_token")
data class OAuth2ClientToken(
        @Id
        @Column(name = "token_id", nullable = false)
        val tokenId: String? = null,

        @Column(name = "token", columnDefinition = "BLOB")
        val token: ByteArray? = null,

        @Column(name = "authentication_id")
        val authenticationId: String? = null,

        @Column(name = "user_name")
        val userName: String? = null,

        @Column(name = "client_id")
        val clientId: String? = null
)