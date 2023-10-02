package com.formationspring.sncfchatp3.controllers;

import com.formationspring.sncfchatp3.domain.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Key;
import java.util.Date;

@RestController
@RequestMapping(path = "/login")
public class LoginController {
    @PostMapping
    public ResponseEntity<String> generateToken(@RequestBody String login){
        String token = createToken(login);
        return ResponseEntity.ok(token);
    }

    @PostMapping(path ="/read")
    public ResponseEntity<String> parseToken(@RequestBody String token){
        String login = readToken(token);
        return ResponseEntity.ok(login);
    }

    private Key getKey() {
        byte[] keyBytes = Decoders.BASE64.decode("SECRETKEYquiEstSuperLongSaGrandJeTeLeDisMoiMonAmi");
        // La clé doit faire 256bits
        Key key = Keys.hmacShaKeyFor(keyBytes);
        return key;
    }

    private String createToken (String login){
        return  Jwts.builder()
                .setSubject(login)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*5))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();

    }
    private String  readToken(String token){
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();

    }

}
