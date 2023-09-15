package com.RealTimeMessaging.controllers;

import com.RealTimeMessaging.services.Impl.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo")
@RequiredArgsConstructor
public class DemoController {
    private final AuthenticationService authenticationService;
    @PostMapping("/test")
    @Secured({ "ROLE_USER", "ROLE_ADMIN" })
    public ResponseEntity<String> login () {
        return ResponseEntity.ok("SUCCESS");
    }
    @PostMapping("/test2")
    @Secured({ "ROLE_SUPER_ADMIN"})
    public ResponseEntity<String> login2 () {
        return ResponseEntity.ok("SUCCESS");
    }


}
