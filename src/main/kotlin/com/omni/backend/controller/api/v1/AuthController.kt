package com.omni.backend.controller.api.v1

import com.omni.backend.service.AuthService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/auth")
class AuthController(
    private val authService: AuthService
) {
    @GetMapping("")
    fun index(): String {
        return "Auth Ctr " + authService.getName()
    }
}
