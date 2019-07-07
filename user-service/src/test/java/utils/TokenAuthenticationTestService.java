package utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import java.security.KeyPair;
import java.util.*;

public class TokenAuthenticationTestService {

    private static final long EXPIRATION_TIME = 864_000_000; // 10 days
    private static final String TOKEN_PREFIX = "Bearer ";
    private static Resource keyResource = new ClassPathResource("testing-keys.jks");
    private static KeyPair keyPair = new KeyStoreKeyFactory( keyResource,"testing".toCharArray()).getKeyPair("testing");


    public static String createToken(String username, List<String> authorities) {
        Map<String, Object> claims = new HashMap<>();
        Map<String, List<String>> permissions = new HashMap<>();
        List<String> articlesPermissions = new LinkedList<>();
        articlesPermissions.add("READ");
        permissions.put("ARTICLES", articlesPermissions);

        // put your information into claim
        claims.put("id", "12345");
        claims.put("authorities", authorities);
        claims.put("created", new Date());
        claims.put("user_name", username);

        String jwt = Jwts.builder()
                .setSubject(username)
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.RS256, keyPair.getPrivate())
                .compact();

        System.out.println("TOKEN " + jwt);

        return TOKEN_PREFIX + jwt;
    }

    public static String createM2MToken(String username, String scope) {
        Collection<String> permissions = new LinkedList<>();
        permissions.add("READ_STUFF");

        Map<String, Object> claims = new HashMap<>();

        // put your information into claim
        claims.put("id", "12345");
        claims.put("created", new Date());
        claims.put("user_name", username);
        claims.put("scope", scope);

        String jwt = Jwts.builder()
                .setSubject(username)
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.RS256, keyPair.getPrivate())
                .compact();

        System.out.println("TOKEN " + jwt);

        return TOKEN_PREFIX + jwt;
    }
}

