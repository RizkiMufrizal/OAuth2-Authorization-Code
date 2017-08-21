package org.rizki.mufrizal.auth.server.configuration

import org.rizki.mufrizal.auth.server.domain.oauth2.Authorities
import org.rizki.mufrizal.auth.server.domain.oauth2.AuthorizedGrantTypes
import org.rizki.mufrizal.auth.server.domain.oauth2.OAuth2ClientDetail
import org.rizki.mufrizal.auth.server.domain.oauth2.Scope
import org.rizki.mufrizal.auth.server.domain.oauth2.User
import org.rizki.mufrizal.auth.server.repository.OAuth2ClientDetailRepository
import org.rizki.mufrizal.auth.server.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Component

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 20 August 2017
 * @Time 9:20 PM
 * @Project Starter-BackEnd
 * @Package org.rizki.mufrizal.starter.backend.configuration
 * @File ScheduledTaskConfiguration
 *
 */
@EnableScheduling
@Component
class ScheduledTaskConfiguration {

    @Autowired
    private lateinit var userRepositoty: UserRepository

    @Autowired
    private lateinit var oAuth2ClientDetailRepository: OAuth2ClientDetailRepository

    @Scheduled(fixedRate = 3600000)
    fun insertData() {
        if (!this.userRepositoty.findByUsername("rizki").isPresent) {
            val userRoles = listOf("ROLE_ADMIN", "ROLE_USER")
            this.userRepositoty.save(User(
                    username = "rizki",
                    password = BCryptPasswordEncoder().encode("mufrizal"),
                    isActive = true,
                    roles = userRoles
            ))
        }

        if (!this.oAuth2ClientDetailRepository.findByClientId("clientid").isPresent) {
            this.oAuth2ClientDetailRepository.save(OAuth2ClientDetail(
                    clientId = "clientid",
                    resourceIds = "RESOURCE_ID_BARANG",
                    clientSecret = "secret",
                    scope = "${Scope.read},${Scope.write}",
                    authorizedGrantTypes = "${AuthorizedGrantTypes.client_credentials},${AuthorizedGrantTypes.password},${AuthorizedGrantTypes.refresh_token},${AuthorizedGrantTypes.authorization_code}",
                    webServerRedirectUri = "http://127.0.0.1:8081",
                    authorities = "${Authorities.ADMIN},${Authorities.CLIENT},${Authorities.ADMINISTRATOR}",
                    accessTokenValidity = 3600,
                    refreshTokenValidity = 3600,
                    additionalInformation = "{\"additional_param\":\"hello OAuth2\"}",
                    autoApprove = true
            ))
        }
    }
}