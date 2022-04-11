package com.dhgb.testSpringbootOracle.springbootOracle.controller

import com.dhgb.testSpringbootOracle.springbootOracle.dto.UserRequest
import com.dhgb.testSpringbootOracle.springbootOracle.database.UserDb
import com.dhgb.testSpringbootOracle.springbootOracle.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.web.bind.annotation.*

//Oracle
@RestController
class UserController(@Autowired jdbcTemplate: JdbcTemplate) {

    val userRepository = UserRepository(jdbcTemplate)

    @GetMapping("/")
    fun findAll(): List<UserDb> {
        return userRepository.findAllIntoDb()
    }

    @PostMapping("/type")
    fun findColumnUser(@RequestBody column: String): List<String>{
        return userRepository.findColumnIntoDb(column.trim())
    }

    @PostMapping("/new-user")
    fun addUser(@RequestBody user: UserRequest): HttpStatus {
        return if(userRepository.addUserDb((user))) HttpStatus.OK else HttpStatus.BAD_REQUEST
    }

    @PostMapping("/deleted-user")
    fun deleteUserById(@RequestBody id: String): HttpStatus{
        return if(userRepository.deleteUserById(id.toInt())) HttpStatus.OK else HttpStatus.BAD_REQUEST
    }
}