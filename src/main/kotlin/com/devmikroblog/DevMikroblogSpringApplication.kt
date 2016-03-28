package com.devmikroblog

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession
import org.springframework.session.web.http.HeaderHttpSessionStrategy

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
