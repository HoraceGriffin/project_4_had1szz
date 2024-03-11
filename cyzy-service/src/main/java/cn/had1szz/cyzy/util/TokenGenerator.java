package cn.had1szz.cyzy.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author : Horace Leoi
 * @since : 2024/3/7
 */
@Component
public class TokenGenerator {

    @Value("${jwt.secret}")
    private String JWT_SECRET;
    @Value("${jwt.expired}")
    private Long JWT_EXPIRED;

    public Map<String, Object> getTokenHeader() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("alg","HMAC256");
        map.put("type", "bearer");

        return map;
    }

    public String getToken(Integer uid) {
        return JWT
                .create()
                .withHeader(this.getTokenHeader())
                .withJWTId(UUID.randomUUID().toString())
                .withClaim("uid", uid)
                .withExpiresAt(new Date(System.currentTimeMillis() + JWT_EXPIRED))
                .sign(Algorithm.HMAC256(JWT_SECRET));
    }

    public boolean isTokenExpired(String token) {
        DecodedJWT decodedJWT = this.resolveBearer(token);
        return decodedJWT.getExpiresAt().before(new Date());
    }

    public DecodedJWT resolveBearer(String token) {
        if (!token.startsWith("Bearer ")) {
            return null;
        }

        return JWT.decode(token.substring("Bearer ".length()));
    }

    public Long getUid(String token) {
        DecodedJWT decodedJWT = this.resolveBearer(token);
        return decodedJWT.getClaim("uid").asLong();
    }

}
