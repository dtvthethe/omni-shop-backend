package com.omni.backend.controller.api.v1

import com.omni.backend.service.AuthService
import jakarta.servlet.http.HttpServletRequest
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

    @GetMapping("ip")
    fun myIp(request: HttpServletRequest): String {
        val header = listOf(
            "X-Forwarded-For",
            "Proxy-Client-IP",
            "WL-Proxy-Client-IP",
            "HTTP_X_FORWARDED_FOR",
            "HTTP_X_FORWARDED",
            "HTTP_X_CLUSTER_CLIENT_IP",
            "HTTP_CLIENT_IP",
            "HTTP_FORWARDED_FOR",
            "HTTP_FORWARDED",
            "HTTP_VIA",
            "REMOTE_ADDR"
        )

        for (h in header) {
            val ip = request.getHeader(h)
            if (!ip.isNullOrEmpty() && !"unknown".equals(ip, ignoreCase = true)) {
                return ip.split(",").first().trim()
            }
        }

        val ip =  request.remoteAddr ?: "unknown"
        val realIp = if (ip == "0:0:0:0:0:0:0:1") "127.0.0.1" else ip

        return "My IP is: $realIp"
    }
}
