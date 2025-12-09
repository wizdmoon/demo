package com.example.demo.member.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.member.dto.MemberDTO;
import com.example.demo.member.service.MemberService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("members")
public class MemberController {

    // 생성자 수동 주입
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    // 읽기
    // @GetMapping("members")
    // public String getMethodName(MemberDTO dto) {
    //     return dto.getUserid() + " / " + dto.getName() + "/" + dto.getPassword();
    // }

    @GetMapping
    public List<MemberDTO> getAllMembers() {
        return memberService.findAllMembers();
    }

    @GetMapping("/{id}")
    public MemberDTO getMember(@PathVariable Long id) {
        return memberService.findMemberById(id);
    }

    @PostMapping
    public void createMember(@RequestBody MemberDTO dto) {
        memberService.saveMember(dto);
    }

    @PutMapping("/{id}")
    public void updateMember(@PathVariable Long id, @RequestBody MemberDTO dto) {
        dto.setId(id); // Path Variable로 받은 id를 DTO에 세팅
        memberService.updateMember(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable Long id) {
        memberService.deleteMemberById(id);
    }


    
    
}
