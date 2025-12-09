package com.example.demo.member.service;

import java.util.List;

import com.example.demo.member.dto.MemberDTO;

public interface MemberService {

    List<MemberDTO> findAllMembers();
    MemberDTO findMemberById(Long id);
    void saveMember(MemberDTO dto);
    void updateMember(MemberDTO dto);
    void deleteMemberById(Long id);

}
