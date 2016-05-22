package com.devmikroblog

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession
import org.springframework.session.web.http.HeaderHttpSessionStrategy
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@SpringBootApplication
@EnableRedisHttpSession
@EnableAutoConfiguration
open class DevMikroblogSpringApplication


fun main(args: Array<String>) {
    SpringApplication.run(DevMikroblogSpringApplication::class.java, *args)
}

@Bean
fun sessionStrategy():HeaderHttpSessionStrategy{
    return HeaderHttpSessionStrategy()
}

//@RequestMapping("token")
//fun token(session: HttpSession):Map<String, String>{
//    return mapOf("token" to session.id)
//}
