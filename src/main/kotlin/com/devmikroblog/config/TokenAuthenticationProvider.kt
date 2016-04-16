package com.devmikroblog.config

import com.devmikroblog.repositories.interfaces.IUserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import java.util.function.Predicate

/**
 * Created by dominik on 12.04.16.
 */
public class TokenAuthenticationProvider : AuthenticationProvider{

    @Autowired
    private lateinit  var userRepository:IUserRepository

    override fun authenticate(auth: Authentication?): Authentication? {
       val userNamePasswordAuthToken = auth as UsernamePasswordAuthenticationToken

        val userName = userNamePasswordAuthToken.principal.toString()
        val password = userNamePasswordAuthToken.credentials.toString()

        val user = userRepository.read(Predicate{x -> x.login == userName && x.password == password})

        return UsernamePasswordAuthenticationToken(user, null, user?.authorities)
    }

    override fun supports(p0: Class<*>?): Boolean {
        throw UnsupportedOperationException()
    }

}