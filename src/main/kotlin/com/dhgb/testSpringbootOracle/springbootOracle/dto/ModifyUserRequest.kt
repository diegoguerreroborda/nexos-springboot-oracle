package com.dhgb.testSpringbootOracle.springbootOracle.dto

data class ModifyUserRequest(
        val id: Int,
        val userName: String?,
        val password: String?,
        val phone: String?,
)