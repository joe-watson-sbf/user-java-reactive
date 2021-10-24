package com.exemple.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    private String id;
    private String fullName;
    private int age;
    private String phoneNumber;
    private String profilImageUrl;
}
