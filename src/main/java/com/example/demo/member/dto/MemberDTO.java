package com.example.demo.member.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberDTO {
    private Long id;
    private String userid;
    private String name;
    private String password;

}
