package com.devmikroblog.controllers

import com.devmikroblog.services.interfaces.IUserService
import org.springframework.beans.factory.annotation.Autowired

/**
 * Created by dominik on 08.04.16.
 */
open class BaseController{
    @Autowired
    private lateinit var userService: IUserService;
}