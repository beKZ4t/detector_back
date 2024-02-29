package kz.iitu.detector.domain.detect.service;

import kz.iitu.detector.domain.detect.model.Detect;
import kz.iitu.detector.domain.detect.repository.DetectRepository;
import kz.iitu.detector.domain.user.model.User;
import kz.iitu.detector.ui.dto.DetectPercentsResponse;
import kz.iitu.detector.ui.dto.DetectRequest;
import kz.iitu.detector.ui.dto.DetectResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DetectService {

    private final DetectRepository repository;

    public ResponseEntity<?> detect(User user, DetectRequest detectRequest) {
        DetectPercentsResponse detectPercentsResponse = analyze(detectRequest.getContent());
        Detect detect = repository.save(new Detect(user.getId(), System.currentTimeMillis(), detectRequest.getContent(), detectPercentsResponse.getAi(), detectPercentsResponse.getHuman(), detectPercentsResponse.getPlagiarism()));
        return ResponseEntity.ok(new DetectResponse(detect.getId(), detect.getTime(), detect.getContent(), detectPercentsResponse));
    }

    private DetectPercentsResponse analyze(String content) {
        return new DetectPercentsResponse(75, 25, 54);
    }

}
