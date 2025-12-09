package com.example.demo.member.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.member.dto.MemberDTO;
import com.example.demo.member.mapper.MemberMapperStruct;
import com.example.demo.member.repository.MemberMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    // lombok 사용한 생성자 수동 주입
    private final MemberMapperStruct mapperStruct; // MapStruct Mapper
    private final MemberMapper memberMapper;       // DB Mapper

    // @Override
    // public List<MemberDTO> findAllMembers() {
    //     return memberMapper.findAll()
    //                        .stream()
    //                        .map(MemberDTO::new)
    //                        .collect(Collectors.toList());
    // }

    @Override
    public List<MemberDTO> findAllMembers() {
        return memberMapper.findAll()
                .stream()
                .map(mapperStruct::toDTO) // .map(member -> mapperStruct.toDTO(member)) 람다식 사용
                .collect(Collectors.toList());
    }

    @Override
    public MemberDTO findMemberById(Long id) {
        return mapperStruct.toDTO(memberMapper.findById(id));
    }

    @Override
    public void saveMember(MemberDTO dto) {
        memberMapper.insert(mapperStruct.toEntity(dto));
    }

    @Override
    public void updateMember(MemberDTO dto) {
        memberMapper.update(mapperStruct.toEntity(dto));
    }

    @Override
    public void deleteMemberById(Long id) {
        memberMapper.delete(id);
    }

}
