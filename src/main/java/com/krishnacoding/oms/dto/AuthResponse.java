package com.krishnacoding.oms.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {

    private String token;
    private String username;
    private String role;
    private String message;
}
