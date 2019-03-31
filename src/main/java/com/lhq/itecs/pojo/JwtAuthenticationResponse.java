package com.lhq.itecs.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtAuthenticationResponse {
    private Integer id;
    private String username;
    private String token;
}
