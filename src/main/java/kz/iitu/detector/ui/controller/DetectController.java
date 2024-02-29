package kz.iitu.detector.ui.controller;

import kz.iitu.detector.domain.detect.service.DetectService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/detect")
@AllArgsConstructor
public class DetectController {

    private final DetectService detectService;

}
