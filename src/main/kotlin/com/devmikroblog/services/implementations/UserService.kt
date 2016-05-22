package com.devmikroblog.services.implementations

import com.devmikroblog.model.Result
import com.devmikroblog.model.Role
import com.devmikroblog.model.User
import com.devmikroblog.model.UserForCreating
import com.devmikroblog.repositories.interfaces.IUserRepository
import com.devmikroblog.services.interfaces.IUserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.util.function.Predicate

/**
 * Created by dominik on 03.05.16.
 */
@Service
public class UserService : IUserService, UserDetailsService {

    private val userRepository: IUserRepository;
    private val passwordEncoder: PasswordEncoder;

    @Autowired
    constructor(userRepository: IUserRepository, passwordEncoder: PasswordEncoder) {
        this.userRepository = userRepository
        this.passwordEncoder = passwordEncoder;
    }

    override fun getAll(user: User): Result<List<User>?> {
        if(user.role == Role.ADMIN){
            return Result.ErrorWhenNoData(userRepository.read())
        }
        return Result(null, listOf("Unauthorized access"))
    }

    override fun loadUserByUsername(username: String?): UserDetails? {
        return userRepository.getUserByUsername(username as String)
    }

    override fun getUserBuUserName(username: String?): Result<User?> {
        return Result.ErrorWhenNoData(userRepository.getUserByUsername(username as String))
    }

    override fun login(username: String, password: String): Result<User?> {
        return Result.ErrorWhenNoData(userRepository.login(username, password))
    }

    override fun register(user: UserForCreating): Result<Boolean> {
        val userByUsername = loadUserByUsername(user.username)

        if(user.password.equals(user.confirmPassword) && userByUsername == null){
            user.password = passwordEncoder.encode(user.password);
            val result = userRepository.register(UserForCreating.toUser(user))
            return Result.ErrorWhenNoData(result)
        }

        return Result(false)
    }

    override fun isAdmin(userId: Int): Result<Boolean> {
        throw UnsupportedOperationException()
    }

    override fun changeRole(userId: Int, role: Role): Result<Boolean> {
        throw UnsupportedOperationException()
    }

    override fun isOwner(postId: Int, userId: Int): Result<Boolean> {
        throw UnsupportedOperationException()
    }
}