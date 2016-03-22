package com.devmikroblog

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration

@SpringBootApplication
@EnableAutoConfiguration(exclude=arrayOf(HibernateJpaAutoConfiguration::class, DataSourceAutoConfiguration::class))
open class DevMikroblogSpringApplication

fun main(args: Array<String>) {
    SpringApplication.run(DevMikroblogSpringApplication::class.java, *args)
}
