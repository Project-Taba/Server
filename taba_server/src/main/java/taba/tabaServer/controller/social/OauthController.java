package taba.tabaServer.controller.social;

import org.springframework.web.bind.annotation.*;
import taba.tabaServer.config.AuthTokens;
import taba.tabaServer.config.infra.kakao.KakaoLoginParams;
import taba.tabaServer.config.infra.naver.NaverLoginParams;
import taba.tabaServer.service.OAuthLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/oauth")
public class OauthController {
    //oauth 로그인 서비스
    private final OAuthLoginService oAuthLoginService;

    //카카오 로그인
    @PostMapping("/kakao")
    public ResponseEntity<AuthTokens> loginKakao(@RequestBody KakaoLoginParams params) {
        return ResponseEntity.ok(oAuthLoginService.login(params));
    }

    //네이버 로그인
    @PostMapping("/naver")
    public ResponseEntity<AuthTokens> loginNaver(@RequestBody NaverLoginParams params) {
        return ResponseEntity.ok(oAuthLoginService.login(params));
    }
}
