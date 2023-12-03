package kr.easw.lesson06.controller;

import kr.easw.lesson06.model.dto.ExceptionalResultDto;
import kr.easw.lesson06.model.dto.UserAuthenticationDto;
import kr.easw.lesson06.model.dto.UserDataEntity;
import kr.easw.lesson06.service.UserDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class UserAuthEndpoint {
    private final UserDataService userDataService;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody UserDataEntity entity) {
        try {
            // 로그인을 시도합니다.
            String token = String.valueOf(userDataService.createTokenWith(entity));
            return ResponseEntity.ok(token); // 성공 시 JWT 토큰 반환
        } catch (Exception ex) {
            // 로그인 실패 시, 예외 메시지와 함께 Bad Request 반환
            return ResponseEntity.badRequest().body(new ExceptionalResultDto(ex.getMessage()));
        }
    }

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody UserDataEntity entity) {
        try {
            // 유저 회원가입 로직을 구현합니다.
            userDataService.registerUser(entity);
            return ResponseEntity.ok("User registered successfully");
        } catch (Exception ex) {
            // 회원가입 실패 시, 예외 메시지와 함께 Bad Request 반환
            return ResponseEntity.badRequest().body(new ExceptionalResultDto(ex.getMessage()));
        }
    }
}
