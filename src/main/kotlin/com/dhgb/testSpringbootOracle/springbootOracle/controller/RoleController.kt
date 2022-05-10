package com.dhgb.testSpringbootOracle.springbootOracle.controller

import com.dhgb.testSpringbootOracle.springbootOracle.service.RoleService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/role")
class RoleController(private val roleService: RoleService) {

    @GetMapping("/hola")
    fun test(): String = "hola keycloak"

    @GetMapping
    fun findAll() = roleService.findAll()

    @GetMapping("/users")
    fun findAllUsers() = roleService.findAllUsers()

//    @GetMapping
//    fun finAllByName(@PathVariable roleName: String) = roleService.findByName(roleName)

    @PostMapping
    fun createRole(@RequestParam name: String) = roleService.create(name)

    @PostMapping("/add-user")
    fun createUser(@RequestParam name: String) = roleService.createUser(name)

}