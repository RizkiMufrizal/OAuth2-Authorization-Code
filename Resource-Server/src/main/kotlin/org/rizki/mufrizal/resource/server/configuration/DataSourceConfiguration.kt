package org.rizki.mufrizal.resource.server.configuration

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.core.env.Environment
import javax.sql.DataSource

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 20 August 2017
 * @Time 6:30 PM
 * @Project Starter-BackEnd
 * @Package org.rizki.mufrizal.starter.backend.configuration
 * @File DataSourceConfiguration
 *
 */

@Configuration
@PropertySource("classpath:application.yml")
class DataSourceConfiguration @Autowired constructor(val environment: Environment) {

    @Bean(destroyMethod = "close")
    fun dataSource(): DataSource {
        val dataSourceConfig = HikariConfig()
        dataSourceConfig.driverClassName = environment.getRequiredProperty("spring.datasource.driver-class-name")
        dataSourceConfig.jdbcUrl = environment.getRequiredProperty("spring.datasource.url")
        dataSourceConfig.username = environment.getRequiredProperty("spring.datasource.username")
        dataSourceConfig.password = environment.getRequiredProperty("spring.datasource.password")
        dataSourceConfig.maximumPoolSize = environment.getRequiredProperty("spring.datasource.maximumPoolSize").toInt()
        dataSourceConfig.minimumIdle = environment.getRequiredProperty("spring.datasource.minimumIdle").toInt()
        dataSourceConfig.connectionTimeout = environment.getRequiredProperty("spring.datasource.connectionTimeout").toLong()
        dataSourceConfig.idleTimeout = environment.getRequiredProperty("spring.datasource.idleTimeout").toLong()
        dataSourceConfig.addDataSourceProperty("poolName", environment.getRequiredProperty("spring.datasource.poolName"))
        dataSourceConfig.addDataSourceProperty("cachePrepStmts", true)
        dataSourceConfig.addDataSourceProperty("prepStmtCacheSize", 250)
        dataSourceConfig.addDataSourceProperty("prepStmtCacheSqlLimit", 2048)
        return HikariDataSource(dataSourceConfig)
    }
}