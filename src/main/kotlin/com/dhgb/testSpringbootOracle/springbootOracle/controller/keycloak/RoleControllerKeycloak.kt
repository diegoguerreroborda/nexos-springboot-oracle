package com.dhgb.testSpringbootOracle.springbootOracle.controller.keycloak

import com.dhgb.testSpringbootOracle.springbootOracle.service.keycloak.RoleService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/keycloak/role")
class RoleControllerKeycloak(private val roleService: RoleService) {

    @GetMapping("/hola")
    fun test(): String = "hola keycloak"

    @GetMapping
    fun findAll() = roleService.findAll()

//    @GetMapping
//    fun finAllByName(@PathVariable roleName: String) = roleService.findByName(roleName)

    @PostMapping
    fun createRole(@RequestParam name: String) = roleService.createRole(name)

}