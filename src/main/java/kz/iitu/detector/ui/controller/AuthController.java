package kz.iitu.detector.ui.controller;

import kz.iitu.detector.domain.user.service.UserService;
import kz.iitu.detector.ui.dto.LoginRequest;
import kz.iitu.detector.ui.dto.UserDataRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
@CrossOrigin("*")
public class AuthController {

    private final UserService service;

    @PostMapping("/login")
    ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        return service.login(loginRequest);
    }

    @PostMapping("/register")
    ResponseEntity<?> register(@RequestBody UserDataRequest userDataRequest) {
        return service.register(userDataRequest);
    }
}
