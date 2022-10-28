package com.duocuc.turismoreal.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class JwtDTO {

    private String accessToken;
    private String tokenType = "Bearer";

    public JwtDTO(String accessToken) {
        this.accessToken = accessToken;
    }
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }
    
}
