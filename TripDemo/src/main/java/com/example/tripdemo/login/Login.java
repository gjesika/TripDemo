package com.example.tripdemo.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Login {

    @Autowired
   AuthenticationManager authenticationManager;



    @PostMapping("/authenticate")
    public ResponseEntity<?> loginMethod(@RequestParam String username, @RequestParam String password) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username,
                            password));
            return ResponseEntity.ok(authentication);
        } catch (Exception e) {
            return ResponseEntity.ok(e.getMessage());
        }
    }





}
