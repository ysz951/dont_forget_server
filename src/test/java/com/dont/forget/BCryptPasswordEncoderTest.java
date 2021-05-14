package com.dont.forget;


import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
public class BCryptPasswordEncoderTest {
    @Test
    public void testPasswordEncode() {
        // user123
        String encoded=new
                BCryptPasswordEncoder().encode("ysz951");
        System.out.println(encoded);
    }
}