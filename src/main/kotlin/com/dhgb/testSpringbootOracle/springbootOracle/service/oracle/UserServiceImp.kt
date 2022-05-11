package com.dhgb.testSpringbootOracle.springbootOracle.service.oracle

import com.dhgb.testSpringbootOracle.springbootOracle.model.ModifyUserRequest
import com.dhgb.testSpringbootOracle.springbootOracle.model.User
import com.dhgb.testSpringbootOracle.springbootOracle.repository.UserRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImp: UserService {

    @Autowired
    lateinit var userRepo: UserRepo

    override fun findAllUsers(): List<User> {
        return userRepo.findAllByOrderByIdAsc()
    }

    override fun findUsersByName(name: String): List<User> {
        return userRepo.findByUserName(name)
    }

    override fun saveUser(user: User): Boolean {
        return try {
            userRepo.save(user)
            true
        }catch (e: Exception){
            false
        }
    }

    override fun deleteUser(id: Int): Boolean {
        return try {
            if(!userRepo.findById(id).isEmpty){
                userRepo.delete(userRepo.findById(id).get())
            }
            true
        }catch (e: Exception){
            false
        }
    }

    override fun updateUser(upUser: ModifyUserRequest): Boolean {
        return try {
            if(!userRepo.findById(upUser.id).isEmpty){
                if(upUser.userName != null){
                    userRepo.findById(upUser.id).get().userName = upUser.userName
                }
                if(upUser.password != null){
                    userRepo.findById(upUser.id).get().password = upUser.password
                }
                if(upUser.phone != null){
                    userRepo.findById(upUser.id).get().phone = upUser.phone
                }
                userRepo.save(userRepo.findById(upUser.id).get())
            }
            true
        }catch (e: Exception){
            false
        }
    }
}