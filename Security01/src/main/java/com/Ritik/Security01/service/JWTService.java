package com.Ritik.Security01.service;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;

@Service
public class JWTService {

    //    private String scretKey="3JS3JAD"; // RANDOM VALUE
    private String secretKey = "";

    public JWTService() throws NoSuchAlgorithmException {
        KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
        SecretKey sk = keyGen.generateKey();
        secretKey = Base64.getEncoder().encodeToString(sk.getEncoded());
    }


    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();

        return Jwts.builder()
                .claims()
                .add(claims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + (60 * 60 * 50)))
                .and()
                .signWith(getKey())
                .compact();

        //Now validate Token.. 2:40:00p
    }

    private Key getKey() {
        try {
            byte[] keyBytes = Base64.getDecoder().decode(secretKey);
//            return keys.hmacShaKeyFor(keyBytes);
            return Keys.hmacShaKeyFor(keyBytes);

        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid Base64-encoded secret key", e);
        }

    }
}
