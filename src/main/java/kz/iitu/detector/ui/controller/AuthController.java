package kz.iitu.detector.ui.controller;

import kz.iitu.detector.domain.user.UserService;
import kz.iitu.detector.ui.dto.LoginRequest;
import kz.iitu.detector.ui.dto.UserDataRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService service;

    public AuthController(UserService service) {
        this.service = service;
    }

    @PostMapping("/login")
    ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        return service.login(loginRequest);
    }

    @PostMapping("/register")
    ResponseEntity<?> register(@RequestBody UserDataRequest userDataRequest) {
        return service.register(userDataRequest);
    }
}
