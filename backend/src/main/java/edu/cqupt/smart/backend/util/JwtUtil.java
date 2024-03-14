package edu.cqupt.smart.backend.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Package_Name: edu.cqupt.smart.backend.util
 * @Description: TODO
 * @Date: 2024/3/1 18:40
 * @Created: SiriAo
 */
@Component
public class JwtUtil {

    //7天过期 (ms)
    @Value("${spring.security.jwt.expire}")
    private static Long EXPIRE_DAYS;
    //32位秘钥
    @Value("${spring.security.jwt.secret}")
    private static String SECRET;
    private final static SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS256;
    //jwt签发者
    private final static String jwt_iss = "siriAo";
    //jwt所有人
    private final static String subject = "All";

    //生成token
    public static String generateToken(String username) {
        Date now = new Date();
        Date expiration = new Date(now.getTime() + 1000 * 60 * 60 * EXPIRE_DAYS);

        Map<String, Object> header = new HashMap();
        header.put("alg", "HS256");
        header.put("typ", "JWT");

        Map<String, Object> payload = new HashMap();
        payload.put("id", "123456");
        payload.put("userName", "admin");

        return Jwts.builder()
                .setHeaderParams(header)
                .setSubject(username) // 签发给谁
                .setIssuedAt(now) // 签发时间
                .setExpiration(expiration)
                .signWith(SIGNATURE_ALGORITHM, SECRET)
                .compact();
    }

    public static Claims getClaimsFromJwt(String jwt) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(jwt)
                    .getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return claims;
    }
}
