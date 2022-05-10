package com.dhgb.testSpringbootOracle.springbootOracle.service

import org.keycloak.admin.client.Keycloak
import org.keycloak.representations.idm.RoleRepresentation
import org.keycloak.representations.idm.UserRepresentation
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class RoleService(
    private val keycloak: Keycloak,
    @Value("\${keycloak.realm}")
    private val realm: String
) {

    fun create(name: String) {
        val role = RoleRepresentation()
        role.name = name
        keycloak
            .realm(realm)
            .roles()
            .create(role)
    }

    fun createUser(userName: String){
        val user = UserRepresentation()
        user.username = userName
        keycloak
            .realm(realm)
            .users()
            .create(user)
    }

    fun findAll(): List<RoleRepresentation> =
        keycloak
            .realm(realm)
            .roles()
            .list()

    fun findByName(roleName: String): RoleRepresentation =
        keycloak
            .realm(realm)
            .roles()
            .get(roleName)
            .toRepresentation()

    fun findAllUsers() =
        keycloak
            .realm(realm)
            .users()
            .list()
}