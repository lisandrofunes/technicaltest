package com.dux.technicaltest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RestController;

import com.dux.technicaltest.jwt.JwtService;
import com.dux.technicaltest.model.LoginRequest;
import com.dux.technicaltest.model.LoginResponse;

import jakarta.validation.Valid;

@RestController
public class AuthApiController implements AuthApi {
    @Autowired 
    private AuthenticationManager authManager;

    @Autowired 
    private JwtService jwtUtils;

    public ResponseEntity<LoginResponse> login(@Valid LoginRequest loginRequest) {
        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        String token = jwtUtils.generateToken((UserDetails) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponse(token));

    }
}