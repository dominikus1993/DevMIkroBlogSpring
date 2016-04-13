package com.devmikroblog.config

import com.devmikroblog.model.Role
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.security.SecurityProperties
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
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
        auth?.inMemoryAuthentication()?.withUser("user")?.password("passowrd")?.roles(Role.USER.role)
    }


    override  fun configure(web: WebSecurity){
        web.ignoring()
                .antMatchers(HttpMethod.OPTIONS, "/**")
                .antMatchers("/app/**/*.{js,html}")
                .antMatchers("/bower_components/**")
                .antMatchers("/i18n/**")
                .antMatchers("/content/**")
                .antMatchers("/swagger-ui/index.html")
                .antMatchers("/test/**");
    }

    override fun configure(http: HttpSecurity?) {
        http?.httpBasic()?.and()?.authorizeRequests()
                ?.antMatchers("/index", "/home", "/")?.permitAll()
                ?.anyRequest()?.authenticated()?.and()?.formLogin()?.loginProcessingUrl("/api/authentication")
                ?.usernameParameter("username")
                ?.passwordParameter("password")
                ?.permitAll()
                ?.permitAll()?.and()?.logout()?.logoutUrl("/api/logout")?.deleteCookies("JSESSIONID", "CSRF-TOKEN")
                ?.permitAll()
                ?.and()?.csrf()?.disable()?.authorizeRequests()
                ?.antMatchers("/api/posts")?.permitAll()
    }


    private fun csrfTokenRepositoryGet():CsrfTokenRepository{
        val repository = HttpSessionCsrfTokenRepository()
        repository.setHeaderName("X-XSRF-TOKEN")
        return repository;
    }
}