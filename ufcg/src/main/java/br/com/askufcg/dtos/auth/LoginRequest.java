package br.com.askufcg.dtos.auth;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}
