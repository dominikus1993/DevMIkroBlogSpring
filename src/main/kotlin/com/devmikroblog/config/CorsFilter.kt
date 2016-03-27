package com.devmikroblog.config


import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component
import javax.servlet.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Created by dominik on 27.03.16.
 */
@Component
@Order(org.springframework.core.Ordered.HIGHEST_PRECEDENCE)
class CorsFilter : Filter {
    override fun destroy() {
    }

    override fun doFilter(req: ServletRequest?, res: ServletResponse?, chain: FilterChain?) {
        val  response = res as HttpServletResponse?
        val request = req as HttpServletRequest?
        response?.setHeader("Access-Control-Allow-Origin", "*")
        response?.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE")
        response?.setHeader("Access-Control-Allow-Headers", "x-auth-token, x-requested-with")
        response?.setHeader("Access-Control-Max-Age", "3600")

        if (req?.method !="OPTIONS") {
            chain?.doFilter(req, res)
        } else {
        }
    }

    override fun init(p0: FilterConfig?) {
    }

}