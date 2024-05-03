package taba.tabaServer;

import org.springframework.test.web.servlet.MockMvc;
import taba.tabaServer.config.AuthTokens;
import taba.tabaServer.config.AuthTokensGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import taba.tabaServer.config.infra.JwtTokenProvider;

import java.time.Duration;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AuthTokensGeneratorTest {

    @Autowired
    private AuthTokensGenerator authTokensGenerator;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;


    @Test
    @DisplayName("JWT 토큰 생성 성공")
    void testGenerate() {
        // given
        Long memberId = 0L;

        // when
        AuthTokens authTokens = authTokensGenerator.generate(memberId);

        // then
        assertThat(authTokens.getGrantType()).isEqualTo("Bearer");
        assertThat(authTokens.getAccessToken()).isNotBlank();
        assertThat(authTokens.getRefreshToken()).isNotBlank();
        assertThat(authTokens.getExpiresIn()).isNotNull();
    }

    @Test
    @DisplayName("JWT 토큰 기반 사용자 조회 성공")
    void testExtractSubject() {
        // given
        Long memberId = 0L;
        AuthTokens authTokens = authTokensGenerator.generate(memberId);
        String accessToken = authTokens.getAccessToken();

        // when
        Long extractedMemberId = authTokensGenerator.extractMemberId(accessToken);

        // then
        assertThat(extractedMemberId).isEqualTo(memberId);
    }

    @DisplayName("validToken(): 유효한 토큰인 경우에 유효성 검증에 성공한다.")
    @Test
    void validToken_validToken() {
        // given: 유효한 토큰(기본값) 생성
        Long memberId = 0L;

        // when
        AuthTokens authTokens = authTokensGenerator.generate(memberId);
        String accessToken = authTokens.getAccessToken();
        boolean result = jwtTokenProvider.validToken(accessToken);

        // then
        assertThat(result).isTrue();
    }

}
