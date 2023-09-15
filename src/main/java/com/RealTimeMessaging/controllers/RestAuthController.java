package com.RealTimeMessaging.controllers;

import com.RealTimeMessaging.auth.AuthenticationRequest;
import com.RealTimeMessaging.auth.AuthenticationResponse;
import com.RealTimeMessaging.services.Impl.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class RestAuthController {
    private final AuthenticationService authenticationService;
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login (@RequestBody AuthenticationRequest authenticationRequest) {
        return ResponseEntity.ok(authenticationService.authenticate(authenticationRequest));
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        // Xử lý logic logout ở đây
        return ResponseEntity.ok("Logout thành công");
    }
}
