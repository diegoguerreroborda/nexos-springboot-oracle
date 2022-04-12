package com.dhgb.testSpringbootOracle.springbootOracle.repository

import com.dhgb.testSpringbootOracle.springbootOracle.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepo: JpaRepository<User, Int> {

//    fun findByUserName(name: String): List<User>

//    @Transactional
//    @Modifying
//    @Query("update USER_DB u set u.name = Pedri where u.id = 1")
//    fun updateUser(id: Int): Boolean
}