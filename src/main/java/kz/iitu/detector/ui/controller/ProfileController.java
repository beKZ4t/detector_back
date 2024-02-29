package kz.iitu.detector.ui.controller;

import kz.iitu.detector.domain.user.service.UserService;
import kz.iitu.detector.ui.dto.UserDataRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    private final UserService service;

    public ProfileController(UserService service) {
        this.service = service;
    }

    @PostMapping("/change")
    ResponseEntity<?> changeProfile(@RequestHeader("Token") String token, @RequestBody UserDataRequest userDataRequest) {
        return service.changeProfile(token, userDataRequest);
    }

    @GetMapping
    ResponseEntity<?> getProfile(@RequestHeader("Token") String token) {
        return service.getProfile(token);
    }
}
