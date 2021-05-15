package com.dont.forget.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import com.dont.forget.payload.JwtAuthenticationResponse;
import com.dont.forget.security.CurrentUser;
import com.dont.forget.security.JwtTokenProvider;
import com.dont.forget.security.UserPrincipal;

public class TokenController {

    @Autowired
    private JwtTokenProvider tokenProvider;

    @PostMapping("/jwt/refresh")
    public ResponseEntity<?> refresh(@CurrentUser UserPrincipal currentUser) {
        String jwt = tokenProvider.refreshToken(currentUser);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt, currentUser.getRole()));

    }
}
