package com.dhgb.testSpringbootOracle.springbootOracle.controller

import com.dhgb.testSpringbootOracle.springbootOracle.model.ModifyUserRequest
import com.dhgb.testSpringbootOracle.springbootOracle.model.User
import com.dhgb.testSpringbootOracle.springbootOracle.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/admin")
class AdminController {

    @Autowired
    lateinit var userService: UserService

    @GetMapping("/")
    private fun getOk(): String{
        return "okks admin"
    }

    @GetMapping("/kbs")
    private fun getPing(): HttpStatus{
        return HttpStatus.OK
    }

    @GetMapping("/list")
    private fun findAll(): ResponseEntity<List<User>> {
        return ResponseEntity.ok(userService.findAllUsers())
    }

    @PostMapping("/list/{name}")
    fun findByUserName(@PathVariable name: String): ResponseEntity<List<User>>{
        return ResponseEntity.ok(userService.findUsersByName(name))
    }

    @PostMapping("/new-user")
    private fun addUser(@RequestBody user: User): HttpStatus {
        return if(userService.saveUser(user)) HttpStatus.OK else HttpStatus.BAD_REQUEST
    }

    @PostMapping("/deleted-user")
    private fun deleteUserById(@RequestBody id: String): HttpStatus {
        return if(userService.deleteUser(id.toInt())) HttpStatus.OK else HttpStatus.BAD_REQUEST
    }

    @PostMapping("updated-user")
    private fun updateUser(@RequestBody upUser: ModifyUserRequest): HttpStatus {
        return if(userService.updateUser(upUser)) HttpStatus.OK else HttpStatus.BAD_REQUEST
    }
}