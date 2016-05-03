package com.devmikroblog.controllers

import com.devmikroblog.services.interfaces.IUserService
import org.springframework.beans.factory.annotation.Autowired
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

    private val userService: IUserService;

    @Autowired
    constructor(userService: IUserService) : super(){

        this.userService = userService
    }

    fun user(user:Principal):Principal{
        return user;
    }
}