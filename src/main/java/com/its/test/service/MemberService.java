package com.its.test.service;

import com.its.test.dto.MemberDTO;
import com.its.test.entity.MemberEntity;
import com.its.test.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    public Long save(MemberDTO memberDTO){
        Long id = memberRepository.save(MemberEntity.toMemberSaveEntity(memberDTO)).getMemberId();
        return id;
    }
}
