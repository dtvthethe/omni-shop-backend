package com.omni.backend.controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("")
class IndexController(
    private val env: Environment
) {
    @Value("\${spring.application.name}")
    lateinit var appName: String

    @GetMapping("")
    fun index(): String {
        val activeProfile = env.activeProfiles.first()

        return "Omni Shop API, profile = $activeProfile, appName = $appName"
    }
}
