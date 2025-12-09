package com.example.demo.member.model;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Member {
    private Long id;
    private String userid;
    private String name;
    private String password;
    private String role;
    private Date createdAt;
    private Date updatedAt;
    private Boolean isDeleted;
}
