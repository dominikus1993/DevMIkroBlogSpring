package com.devmikroblog.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.datasource.DriverManagerDataSource
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean
import javax.sql.DataSource

/**
 * Created by dominik on 28.03.16.
 */
@Configuration
open class DatabaseConfiguration {

    @Bean
    open fun sessionFactory(): HibernateJpaSessionFactoryBean {
        return HibernateJpaSessionFactoryBean();
    }
}