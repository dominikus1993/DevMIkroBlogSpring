package com.devmikroblog

import com.devmikroblog.model.Post
import com.devmikroblog.model.Result
import com.devmikroblog.model.Role
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession
import org.springframework.session.web.http.HeaderHttpSessionStrategy
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import java.util.*
import javax.servlet.http.HttpSession

@SpringBootApplication
@EnableRedisHttpSession
@RestController
@RequestMapping("/")
@EnableAutoConfiguration(exclude=arrayOf(HibernateJpaAutoConfiguration::class, DataSourceAutoConfiguration::class))
open class DevMikroblogSpringApplication


fun main(args: Array<String>) {
    SpringApplication.run(DevMikroblogSpringApplication::class.java, *args)
}

@Bean
fun sessionStrategy():HeaderHttpSessionStrategy{
    return HeaderHttpSessionStrategy()
}

@RequestMapping("token")
fun token(session: HttpSession):Map<String, String>{
    return mapOf("token" to session.id)
}
