package com.dhgb.testSpringbootOracle.springbootOracle.repository

import com.dhgb.testSpringbootOracle.springbootOracle.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepo: JpaRepository<User, Int> {

    fun findAllByOrderByIdAsc(): List<User>
    fun findByUserName(name: String): List<User>
}