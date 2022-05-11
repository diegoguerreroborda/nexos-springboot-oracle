package com.dhgb.testSpringbootOracle.springbootOracle.controller.keycloak

import com.dhgb.testSpringbootOracle.springbootOracle.service.keycloak.UserKeycloakService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/keycloak/user")
class UserControllerKeycloak(private val userKeycloakService: UserKeycloakService) {

    @GetMapping("/hola")
    fun test(): String = "hola keycloak user"

    @GetMapping
    fun findAllUsers() = userKeycloakService.findAll()


    @PostMapping("/add-user")
    fun createUser(@RequestParam params: Map<String,String>) {
        println("El nombre es ${params["name"]} *** ${params["password"]}")
        if(!params["name"].isNullOrEmpty() && !params["password"].isNullOrEmpty()){
            userKeycloakService.createUser(params["name"]!!, params["password"]!!)
        }
    }
}