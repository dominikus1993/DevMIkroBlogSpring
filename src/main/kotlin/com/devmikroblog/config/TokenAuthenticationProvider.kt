package com.devmikroblog.config

import com.devmikroblog.repositories.interfaces.IUserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.core.Authentication

/**
 * Created by dominik on 12.04.16.
 */
public class TokenAuthenticationProvider : AuthenticationProvider{

    @Autowired
    private lateinit  var userRepository:IUserRepository

    override fun authenticate(auth: Authentication?): Authentication? {
        return null
    }

    override fun supports(p0: Class<*>?): Boolean {
        throw UnsupportedOperationException()
    }

}