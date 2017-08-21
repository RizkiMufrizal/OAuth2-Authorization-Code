package org.rizki.mufrizal.auth.server.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 21 August 2017
 * @Time 11:10 AM
 * @Project Auth-Server
 * @Package org.rizki.mufrizal.auth.server.controller
 * @File LoginController
 *
 */

@Controller
class LoginController {

    @GetMapping(value = "/login")
    fun login(): String = "login"

}