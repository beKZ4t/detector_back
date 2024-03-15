package kz.iitu.detector.ui.controller;

import kz.iitu.detector.config.jwt.AuthorizationStructure;
import kz.iitu.detector.domain.detect.service.DetectService;
import kz.iitu.detector.ui.dto.DetectRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/detect")
@AllArgsConstructor
@CrossOrigin("*")
public class DetectController {

    private final DetectService service;
    private final AuthorizationStructure authorization;

    @PostMapping
    public ResponseEntity<?> detect(
        @RequestHeader("Authorization") String token,
        @RequestBody DetectRequest detectRequest
    ) throws Exception {
        return authorization.checkUser(token, user -> service.detect(user, detectRequest));
    }

    @GetMapping("/history")
    public ResponseEntity<?> getHistory(
        @RequestHeader("Authorization") String token
    ) throws Exception {
        return authorization.checkUser(token, service::findAll);
    }

}
