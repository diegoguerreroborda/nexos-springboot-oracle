package com.dhgb.testBackend.testSpringboot.dto

data class UserResponse(
        val id: String,
        val userName: String,
        val encryptedPassword: String
)