package kr.easw.lesson06.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

// REST 컨트롤러로 선언
@RestController
// 기본 엔드포인트 설정
@RequestMapping("/api/v1/user")
// 모든 final 필드에 대한 생성자 생성 (Lombok)
@RequiredArgsConstructor
public class UserDataEndpoint {

    // 유저 목록 조회
    @GetMapping("/list")
    public List<String> listUsers() {
        // 이 예제에서는 하드코딩된 유저 목록을 반환합니다.
        List<String> users = new ArrayList<>();
        users.add("user1");
        users.add("user2");
        users.add("user3");
        return users;
    }

    // 유저 삭제
    @PostMapping("/remove")
    public ResponseEntity<String> removeUser() {
        // 이 예제에서는 단순한 응답을 반환합니다.
        return ResponseEntity.ok("유저가 성공적으로 삭제되었습니다.");
    }
}
