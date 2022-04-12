package com.dhgb.testSpringbootOracle.springbootOracle.controller

import com.dhgb.testSpringbootOracle.springbootOracle.model.User
import com.dhgb.testSpringbootOracle.springbootOracle.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


//Oracle
@RestController
class UserController {

    @Autowired
    lateinit var userService: UserService


    @GetMapping("/")
    private fun findAll(): List<User> {
        return userService.findAllUsers()
    }

    @PostMapping("/type")
    private fun findColumnUser(@RequestBody column: String){ //: List<String>
//        println("Todos: ${userRepo.findAll()}")
//        return userRepository.findColumnIntoDb(column.trim())
    }

//    @PostMapping("/users-name")
//    fun findByUserName(@RequestBody name: String): List<User>{
////        return userRepo.findByUserName(name)
//    }

    @PostMapping("/new-user")
    private fun addUser(@RequestBody user: User): HttpStatus {
        return if(userService.saveUser(user)) HttpStatus.OK else HttpStatus.BAD_REQUEST
    }

    @PostMapping("/deleted-user")
    private fun deleteUserById(@RequestBody id: String): HttpStatus =
            if(userService.deleteUser(id.toInt())) HttpStatus.OK else HttpStatus.BAD_REQUEST
//        return  HttpStatus.OK

    @PostMapping("updated-user")
    private fun updateUser(@RequestBody id: Int): HttpStatus =
        if(userService.updateUser(id)) HttpStatus.OK else HttpStatus.BAD_REQUEST
}