package com.example.CRUD;

import javax.crypto.SecretKey;

import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Value;

import io.jsonwebtoken.Jwts;
import jakarta.xml.bind.DatatypeConverter;



public class jstSecretMakerTest {
    // @Value("${security.jwt.secret-key}")
    // private String secretKey;

    @Test
    public void generateSecretKey(){
        SecretKey key = Jwts.SIG.HS512.key().build();
        String encodedKey = DatatypeConverter.printHexBinary(key.getEncoded());
        System.out.printf("\nKey = {%s}\n", encodedKey);
    }
}
