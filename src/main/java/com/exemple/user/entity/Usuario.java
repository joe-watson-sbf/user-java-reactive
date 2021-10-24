package com.exemple.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
public class Usuario {
    @Id
    private String id;
    private String fullName;
    private int age;
    private String phoneNumber;
    private String profilImageUrl;
}
