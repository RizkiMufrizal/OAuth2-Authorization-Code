package org.rizki.mufrizal.auth.server.domain.oauth2

import javax.persistence.CollectionTable
import javax.persistence.Column
import javax.persistence.ElementCollection
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.Table

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 20 August 2017
 * @Time 5:53 PM
 * @Project Starter-BackEnd
 * @Package org.rizki.mufrizal.starter.backend.domain
 * @File User
 *
 */
@Entity
@Table(name = "tb_user")
data class User(
        @Id
        @Column(length = 50, nullable = false)
        val username: String? = null,
        @Column(length = 100, nullable = false)
        val password: String? = null,
        @Column(name = "is_active", length = 100, nullable = false)
        val isActive: Boolean? = null,
        @ElementCollection(fetch = FetchType.EAGER)
        @CollectionTable(name = "roles", joinColumns = arrayOf(JoinColumn(name = "username")))
        @Column(name = "role")
        val roles: List<String>? = null
)