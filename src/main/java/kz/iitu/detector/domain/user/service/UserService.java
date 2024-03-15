package kz.iitu.detector.domain.user.service;

import kz.iitu.detector.config.jwt.TokenUtils;
import kz.iitu.detector.domain.user.model.User;
import kz.iitu.detector.domain.user.repository.UserRepository;
import kz.iitu.detector.ui.dto.AuthTokenResponse;
import kz.iitu.detector.ui.dto.LoginRequest;
import kz.iitu.detector.ui.dto.UserDataRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<?> login(LoginRequest loginRequest) {
        Optional<User> userOptional = repository.findByEmail(loginRequest.getEmail());
        if (userOptional.isEmpty()) {
            return ResponseEntity.badRequest().body("Email not registered");
        }
        User user = userOptional.get();
        if (user.getPassword().equals(loginRequest.getPassword())) {
            return ResponseEntity.badRequest().body("Wrong password");
        }
        user.setToken(TokenUtils.generateUserToken(user.getEmail(), user.getPassword()));
        repository.save(user);
        return ResponseEntity.ok(new AuthTokenResponse(user.getToken()));
    }

    public ResponseEntity<?> register(UserDataRequest userDataRequest) {
        Optional<User> userOptional = repository.findByEmail(userDataRequest.getEmail());
        if (userOptional.isPresent()) {
            return ResponseEntity.badRequest().body("Email already registered");
        }
        User user = repository.save(new User(userDataRequest.getUsername(), userDataRequest.getEmail(), userDataRequest.getPassword(), TokenUtils.generateUserToken(userDataRequest.getEmail(), userDataRequest.getPassword())));
        return ResponseEntity.ok(new AuthTokenResponse(user.getToken()));
    }

    public ResponseEntity<?> getProfile(User user) {
        return ResponseEntity.ok(user);
    }

    public ResponseEntity<?> changeProfile(User user, UserDataRequest userDataRequest) {
        user.setUsername(userDataRequest.getUsername());
        user.setPassword(userDataRequest.getPassword());
        user.setToken(TokenUtils.generateUserToken(user.getEmail(), user.getPassword()));
        return ResponseEntity.ok(new AuthTokenResponse(user.getToken()));
    }

}
