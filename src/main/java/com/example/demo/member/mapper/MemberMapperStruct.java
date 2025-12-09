package com.example.demo.member.mapper;

import org.mapstruct.Mapper;

import com.example.demo.member.dto.MemberDTO;
import com.example.demo.member.model.Member;

@Mapper(componentModel = "spring")
public interface MemberMapperStruct {
    MemberDTO toDTO(Member member);   // Entity → DTO
    Member toEntity(MemberDTO dto);   // DTO → Entity

}

