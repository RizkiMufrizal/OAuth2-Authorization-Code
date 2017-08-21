package org.rizki.mufrizal.resource.server.configuration

import org.apache.commons.io.IOUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer
import org.springframework.security.oauth2.provider.token.TokenStore
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter
import org.springframework.security.web.access.channel.ChannelProcessingFilter
import java.io.File
import java.nio.charset.Charset
import javax.sql.DataSource

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 20 August 2017
 * @Time 6:18 PM
 * @Project Starter-BackEnd
 * @Package org.rizki.mufrizal.starter.backend.configuration
 * @File OAuth2Configuration
 *
 */
@Configuration
open class OAuth2Configuration {

    @Configuration
    @EnableResourceServer
    protected class ResourceServerConfiguration @Autowired constructor(val dataSource: DataSource) : ResourceServerConfigurerAdapter() {

        private val RESOURCE_ID = "RESOURCE_ID_BARANG"

        @Bean
        fun tokenStore(): TokenStore {
            return JdbcTokenStore(dataSource)
        }

        @Bean
        @Qualifier("jwtAccessTokenConverter")
        fun jwtAccessTokenConverter(): JwtAccessTokenConverter {
            val converter = JwtAccessTokenConverter()
            val resource = ClassPathResource("keys${File.separator}public.txt")
            val publicKey: String? = IOUtils.toString(resource.inputStream, Charset.defaultCharset())
            converter.setVerifierKey(publicKey)
            return converter
        }

        override fun configure(resourceServerSecurityConfigurer: ResourceServerSecurityConfigurer?) {
            resourceServerSecurityConfigurer
                    ?.tokenStore(tokenStore())
                    ?.resourceId(RESOURCE_ID)
        }

        override fun configure(httpSecurity: HttpSecurity?) {
            httpSecurity
                    ?.authorizeRequests()
                    ?.antMatchers("/**")
                    ?.fullyAuthenticated()
                    ?.and()
                    ?.addFilterBefore(CorsConfiguration(), ChannelProcessingFilter::class.java)
        }

    }
}