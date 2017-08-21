package org.rizki.mufrizal.auth.server.repository

import org.rizki.mufrizal.auth.server.domain.oauth2.OAuth2ClientDetail
import org.springframework.data.repository.PagingAndSortingRepository
import java.util.Optional

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 20 August 2017
 * @Time 9:24 PM
 * @Project Starter-BackEnd
 * @Package org.rizki.mufrizal.starter.backend.repository
 * @File OAuth2ClientDetailRepository
 *
 */
interface OAuth2ClientDetailRepository : PagingAndSortingRepository<OAuth2ClientDetail, String> {
    fun findByClientId(clientId: String): Optional<OAuth2ClientDetail>
}