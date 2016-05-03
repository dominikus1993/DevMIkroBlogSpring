package com.devmikroblog.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter
import org.springframework.security.oauth2.provider.token.TokenStore
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore
import javax.sql.DataSource


/**
 * Created by dominik on 03.05.16.
 */
class OAuthConfiguration : AuthorizationServerConfigurerAdapter() {

    @Autowired
    private lateinit var dataSource: DataSource

    @Bean fun tokenStore(): TokenStore {
        return JdbcTokenStore(dataSource);
    }
}
