package org.rizki.mufrizal.auth.server.domain.oauth2


/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 20 August 2017
 * @Time 6:00 PM
 * @Project Starter-BackEnd
 * @Package org.rizki.mufrizal.starter.backend.domain.oauth2
 * @File AuthorizedGrantTypes
 *
 */
enum class AuthorizedGrantTypes {
    password, client_credentials, refresh_token, authorization_code, implicit
}