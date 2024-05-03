package taba.tabaServer.config.infra.kakao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import taba.tabaServer.config.oauth.OAuthInfoResponse;
import taba.tabaServer.config.oauth.OAuthProvider;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class KakaoInfoResponse implements OAuthInfoResponse {

    @JsonProperty("kakao_account")
    private KakaoAccount kakaoAccount;

    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class KakaoAccount {
        private Profile profile;
        private String name;
        private String email;
        private String gender;
        private String birthday;
        private String birthyear;
        private String phone_number;
    }

    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class Profile {
        private String nickname;
    }

    @Override
    public String getEmail() {
        return kakaoAccount.email;
    }

    @Override
    public String getName() { return kakaoAccount.name; }

    @Override
    public OAuthProvider getOAuthProvider() {
        return OAuthProvider.KAKAO;
    }
    @Override
    public String getGender() {
        return kakaoAccount.gender;
    }

    @Override
    public String getBirthday() {
        return kakaoAccount.birthday;
    }

    @Override
    public String getBirthyear() {
        return kakaoAccount.birthyear;
    }

    @Override
    public String getMobile() {
        return kakaoAccount.phone_number;
    }
}
