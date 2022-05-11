package com.dhgb.testSpringbootOracle.springbootOracle.service.keycloak

import org.keycloak.admin.client.Keycloak
import org.keycloak.representations.idm.RoleRepresentation
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class RoleService(
    private val keycloak: Keycloak,
    @Value("\${keycloak.realm}")
    private val realm: String
) {

    fun createRole(name: String) {
        val role = RoleRepresentation()
        role.name = name
        keycloak
            .realm(realm)
            .roles()
            .create(role)
    }

    fun findAll(): List<RoleRepresentation> =
        keycloak
            .realm(realm)
            .roles()
            .list()
}