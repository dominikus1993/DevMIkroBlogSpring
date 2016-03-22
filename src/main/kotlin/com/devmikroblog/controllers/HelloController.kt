package com.devmikroblog.controllers

import com.devmikroblog.model.Result
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/**
 * Created by pnet-46 on 22.03.16.
 */
@RestController
class HelloController{

    @RequestMapping("/hello")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String): Result<String> {
        return Result(name)
    }
}