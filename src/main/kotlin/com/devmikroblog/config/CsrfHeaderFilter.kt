package com.devmikroblog.config

import org.springframework.core.annotation.Order
import org.springframework.security.web.csrf.CsrfToken
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import org.springframework.web.util.WebUtils
import javax.servlet.FilterChain
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Created by dominik on 27.03.16.
 */
@Component
@Order(org.springframework.core.Ordered.HIGHEST_PRECEDENCE)
class CsrfHeaderFilter : OncePerRequestFilter() {
    override fun doFilterInternal(req: HttpServletRequest?, res: HttpServletResponse?, chain: FilterChain?) {
        val csrf = req?.getAttribute(CsrfToken::class.java.name) as CsrfToken?
        if(csrf != null){
            var cookie = WebUtils.getCookie(req, "XSRF-TOKEN")
            var token = csrf.token

            if(cookie == null || token != null && !token.equals(cookie.value)){
                cookie = Cookie("XSRF-TOKEN", token)
                cookie.path = "/"
                res?.addCookie(cookie)
            }
        }
        chain?.doFilter(req, res)
    }
}