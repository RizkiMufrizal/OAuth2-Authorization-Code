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
 * @Time 6:06 PM
 * @Project Starter-BackEnd
 * @Package org.rizki.mufrizal.starter.backend.domain.oauth2
 * @File OAuth2RefreshToken
 *
 */
@Entity
@Table(name = "oauth_refresh_token")
data class OAuth2RefreshToken(

        @Id
        @Column(name = "token_id")
        val tokenId: String? = null,

        @Column(name = "token", columnDefinition = "BLOB")
        val token: ByteArray? = null,

        @Column(name = "authentication", columnDefinition = "BLOB")
        val authentication: ByteArray? = null
)