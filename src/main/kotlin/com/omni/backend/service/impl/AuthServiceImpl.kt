package com.omni.backend.service.impl

import com.omni.backend.service.AuthService
import org.springframework.stereotype.Service

@Service
class AuthServiceImpl : AuthService {
    override fun getName(): String {
        return "This is auth service"
    }
}
