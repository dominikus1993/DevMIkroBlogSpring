package com.devmikroblog.config

import com.devmikroblog.utils.Urls
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.web.csrf.CsrfTokenRepository
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository
import org.springframework.security.web.util.matcher.AntPathRequestMatcher
import org.springframework.security.web.util.matcher.RequestMatcher
import java.util.regex.Pattern
import javax.sql.DataSource


/**
 * Created by dominik on 27.03.16.
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
open class SecurityConfiguration : WebSecurityConfigurerAdapter() {

    @Autowired
    private lateinit var userService: UserDetailsService;

    @Autowired
    private lateinit var dataSource: DataSource

    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth?.userDetailsService(userService)
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
        http?.authorizeRequests()
                ?.antMatchers("/**/*.{js,html}")
                ?.permitAll()
                ?.antMatchers("/**/api/auth/register")
                ?.permitAll()
                ?.anyRequest()
                ?.authenticated()
                ?.and()
                ?.formLogin()
                ?.loginPage("/login.html")
                ?.permitAll()
                ?.and()
                ?.logout()
                ?.logoutRequestMatcher(AntPathRequestMatcher(Urls.Logout))
                ?.permitAll()
                ?.and()
                ?.csrf()
                ?.disable()
    }


    private fun csrfTokenRepositoryGet():CsrfTokenRepository{
        val repository = HttpSessionCsrfTokenRepository()
        repository.setHeaderName("X-XSRF-TOKEN")
        return repository;
    }
}