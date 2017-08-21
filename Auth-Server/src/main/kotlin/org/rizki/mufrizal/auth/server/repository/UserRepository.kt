package org.rizki.mufrizal.auth.server.repository

import org.rizki.mufrizal.auth.server.domain.oauth2.User
import org.springframework.data.repository.PagingAndSortingRepository
import java.util.Optional

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 20 August 2017
 * @Time 5:58 PM
 * @Project Starter-BackEnd
 * @Package org.rizki.mufrizal.starter.backend.repository
 * @File UserRepository
 *
 */
interface UserRepository : PagingAndSortingRepository<User, String> {
    fun findByUsername(username: String): Optional<User>
}