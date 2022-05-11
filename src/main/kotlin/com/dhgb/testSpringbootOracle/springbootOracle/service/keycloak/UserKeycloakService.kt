package com.dhgb.testSpringbootOracle.springbootOracle.service.keycloak

import org.keycloak.admin.client.Keycloak
import org.keycloak.representations.idm.CredentialRepresentation
import org.keycloak.representations.idm.RoleRepresentation
import org.keycloak.representations.idm.UserRepresentation
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class UserKeycloakService(
    private val keycloak: Keycloak,
    @Value("\${keycloak.realm}")
    private val realm: String
) {

    fun createUser(userName: String, password: String){
        val user = UserRepresentation()
        val roleRepresentation = RoleRepresentation()
        roleRepresentation.name = "user"
        user.username = userName
        user.isEnabled = true
        user.credentials = listOf(createPassword(password))
        try {
            keycloak.realm(realm).users().create(user)
            assignRole(findByUsername(userName).id, findByName("user"))
        }catch (e: Exception){
            println("Error $e")
        }
    }

    private fun createPassword(password: String): CredentialRepresentation {
        val credentials = CredentialRepresentation()
        credentials.isTemporary = false
        credentials.value = password
        credentials.type = CredentialRepresentation.PASSWORD
        return credentials
    }

    private fun findByUsername(username: String): UserRepresentation =
        keycloak
            .realm(realm)
            .users()
            .search(username)[0]

    private fun assignRole(userId: String, roleRepresentation: RoleRepresentation) {
        keycloak
            .realm(realm)
            .users()
            .get(userId)
            .roles()
            .realmLevel()
            .add(listOf(roleRepresentation))
    }

    fun findByName(roleName: String): RoleRepresentation =
        keycloak
            .realm(realm)
            .roles()
            .get(roleName)
            .toRepresentation()

    fun findAll() =
        keycloak
            .realm(realm)
            .users()
            .list()
}