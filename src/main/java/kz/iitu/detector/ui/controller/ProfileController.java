package kz.iitu.detector.ui.controller;

import kz.iitu.detector.config.jwt.AuthorizationStructure;
import kz.iitu.detector.domain.user.service.UserService;
import kz.iitu.detector.ui.dto.UserDataRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profile")
@AllArgsConstructor
@CrossOrigin("*")
public class ProfileController {


    private final UserService service;
    private final AuthorizationStructure authorization;


    @PostMapping("/change")
    ResponseEntity<?> changeProfile(
            @RequestHeader("Authorization") String token,
            @RequestBody UserDataRequest userDataRequest
    ) {
        return authorization.checkUser(token, user -> service.changeProfile(user, userDataRequest));
    }

    @GetMapping
    ResponseEntity<?> getProfile(@RequestHeader("Authorization") String token) {
        return authorization.checkUser(token, service::getProfile);
    }
}
