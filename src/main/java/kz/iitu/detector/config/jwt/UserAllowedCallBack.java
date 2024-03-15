package kz.iitu.detector.config.jwt;

import kz.iitu.detector.domain.user.model.User;
import org.springframework.http.ResponseEntity;

public interface UserAllowedCallBack {

    ResponseEntity<?> allowed(User user);

}