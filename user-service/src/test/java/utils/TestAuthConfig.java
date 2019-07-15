package utils;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@TestConfiguration
public class TestAuthConfig {

    @Bean
    public TokenStore jwtTokenStore() {
        return new JwtTokenStore(jwtTokenEnhancer());
    }

    @Bean
    public JwtAccessTokenConverter jwtTokenEnhancer() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        String keyValue = "-----BEGIN PUBLIC KEY-----MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAoOo+plDIE5n/sXS8K0zQAsuYPsHN1zUvPZwc5WvyNhzz+4+am79Fk+chbiXbbM0rY9E29zjxf/8RYEt/KdfXlILRH1qv5dJcKNfOwUQ/TJqi9xfG1Yb1ucRgUFqQ0p7Yj0vV3tpLZpdaTkm3kkM0aSgUqr31JPZmxiqamMVW5/dqCtQ8C0dLyY4KL+XcKMDS/BVmxfj1CVhfRuq5M6yWkfOrcuisqd8tIPowEvnNycF25pWuRjUVA6Uyc5DI6hntsZIDAJhNjqstAH9aLRqhgwKegqnR7BrOyN+mreCeU1UM3yHQsSxae/VKQikn2xU43JVF7apgkfuYLFgFMMqC0wIDAQAB-----END PUBLIC KEY-----";
        converter.setVerifierKey(keyValue);
        return converter;
    }
}
