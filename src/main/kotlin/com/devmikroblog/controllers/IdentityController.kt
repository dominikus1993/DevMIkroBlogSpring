package com.devmikroblog.controllers

import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

/**
 * Created by dominik on 27.03.16.
 */
@RestController
@RequestMapping("/api/auth")
class IdentityController : BaseController{

    constructor() : super(){

    }

    fun user(user:Principal):Principal{
        return user;
    }
}