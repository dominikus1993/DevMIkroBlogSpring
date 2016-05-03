package com.devmikroblog.services.implementations

import com.devmikroblog.model.Result
import com.devmikroblog.model.Role
import com.devmikroblog.model.User
import com.devmikroblog.repositories.interfaces.IUserRepository
import com.devmikroblog.services.interfaces.IUserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by dominik on 03.05.16.
 */
@Service
public class UserService : IUserService{

    private val userRepository: IUserRepository;

    @Autowired
    constructor(userRepository: IUserRepository) {
        this.userRepository = userRepository
    }

    override fun login(username: String, password: String): Result<User?> {
        return Result.ErrorWhenNoData(userRepository.login(username, password))
    }

    override fun register(user: User): Result<Boolean> {
        throw UnsupportedOperationException()
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