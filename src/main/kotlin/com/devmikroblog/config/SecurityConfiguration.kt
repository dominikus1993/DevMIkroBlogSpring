package com.devmikroblog.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.security.SecurityProperties
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.csrf.CsrfFilter
import org.springframework.security.web.csrf.CsrfTokenRepository
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository
import org.springframework.security.web.util.matcher.AntPathRequestMatcher
import javax.activation.DataSource

/**
 * Created by dominik on 27.03.16.
 */
@Configuration
@EnableWebSecurity
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
open class SecurityConfiguration : WebSecurityConfigurerAdapter() {

    override fun configure(auth: AuthenticationManagerBuilder?) {
//        auth?.jdbcAuthentication()?.dataSource(dataSource as javax.sql.DataSource)
//                ?.usersByUsernameQuery("select username, password from Users where username=?")
//                ?.authoritiesByUsernameQuery("select username role from Users where username=?")
        super.configure(auth)
    }

    override fun configure(http: HttpSecurity?) {
        http?.httpBasic()?.and()?.authorizeRequests()
                ?.antMatchers("/index", "/home", "/")?.permitAll()
                ?.anyRequest()?.authenticated()?.and()?.formLogin()?.loginPage("/login")
                ?.permitAll()?.and()?.logout()?.logoutRequestMatcher(AntPathRequestMatcher("/logout"))
                ?.permitAll()
                ?.and()?.csrf()?.disable()
    }

    private fun csrfTokenRepositoryGet():CsrfTokenRepository{
        val repository = HttpSessionCsrfTokenRepository()
        repository.setHeaderName("X-XSRF-TOKEN")
        return repository;
    }
}