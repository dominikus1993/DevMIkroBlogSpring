package com.devmikroblog.config

import org.springframework.boot.autoconfigure.security.SecurityProperties
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.csrf.CsrfFilter
import org.springframework.security.web.csrf.CsrfTokenRepository
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository

/**
 * Created by dominik on 27.03.16.
 */
@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
class SecurityConfiguration : WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity?) {
        http?.httpBasic()?.and()?.authorizeRequests()
                ?.antMatchers("/index.html", "/home.html", "/login.html", "/")?.permitAll()
                ?.anyRequest()?.authenticated()?.and()?.addFilterAfter(CsrfHeaderFilter(), CsrfFilter::class.java)
                ?.csrf()?.csrfTokenRepository(csrfTokenRepositoryGet())?.and()?.logout();
    }

    private fun csrfTokenRepositoryGet():CsrfTokenRepository{
        val repository = HttpSessionCsrfTokenRepository()
        repository.setHeaderName("X-XSRF-TOKEN")
        return repository;
    }
}