package com.dhgb.testSpringbootOracle.springbootOracle.service.oracle

import com.dhgb.testSpringbootOracle.springbootOracle.model.ModifyUserRequest
import com.dhgb.testSpringbootOracle.springbootOracle.model.User

interface UserService {

    fun findAllUsers(): List<User>
    fun findUsersByName(name: String): List<User>
    fun saveUser(user: User): Boolean
    fun deleteUser(id: Int): Boolean
    fun updateUser(upUser: ModifyUserRequest): Boolean
}