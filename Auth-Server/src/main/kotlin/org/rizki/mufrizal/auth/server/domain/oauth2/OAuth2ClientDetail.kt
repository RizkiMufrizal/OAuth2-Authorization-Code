package org.rizki.mufrizal.auth.server.domain.oauth2

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Lob
import javax.persistence.Table

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 20 August 2017
 * @Time 5:55 PM
 * @Project Starter-BackEnd
 * @Package org.rizki.mufrizal.starter.backend.domain
 * @File OAuth2ClientDetail
 *
 */
@Entity
@Table(name = "oauth_client_details")
data class OAuth2ClientDetail(
        @Id
        @Column(name = "client_id", nullable = false)
        val clientId: String? = null,

        @Column(name = "resource_ids", nullable = false)
        val resourceIds: String? = null,

        @Column(name = "client_secret", nullable = false)
        val clientSecret: String? = null,

        @Column(name = "scope", nullable = false)
        val scope: String? = null,

        @Column(name = "authorized_grant_types", nullable = false)
        val authorizedGrantTypes: String? = null,

        @Column(name = "web_server_redirect_uri", nullable = false)
        val webServerRedirectUri: String? = null,

        @Column(name = "authorities", nullable = false)
        val authorities: String? = null,

        @Column(name = "access_token_validity", nullable = false)
        val accessTokenValidity: Int? = null,

        @Column(name = "refresh_token_validity", nullable = false)
        val refreshTokenValidity: Int? = null,

        @Lob
        @Column(name = "additional_information", nullable = false)
        val additionalInformation: String? = null,

        @Column(name = "autoapprove", nullable = false)
        val autoApprove: Boolean? = null
)