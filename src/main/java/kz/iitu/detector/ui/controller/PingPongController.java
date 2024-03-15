package kz.iitu.detector.ui.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ping")
@CrossOrigin("*")
public class PingPongController {

    @GetMapping
    ResponseEntity<?> ping() {
        return ResponseEntity.ok("pong");
    }
}
