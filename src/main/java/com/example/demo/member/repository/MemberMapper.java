package com.example.demo.member.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.member.model.Member;

@Mapper
public interface MemberMapper {
    List<Member> findAll();
    Member findById(Long id);
    void insert(Member member);
    void update(Member member);
    void delete(Long id);

}
