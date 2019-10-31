package com.invillia.springteams.service;

import com.invillia.springteams.model.Member;
import com.invillia.springteams.repository.MemberRepository;
import com.invillia.springteams.repository.TeamRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> findAllMembers(Long id) {
        return memberRepository.findAllByIdTeam(id);
    }

    @Transactional
    public void insert(Member member){
        memberRepository.save(member);
    }

    public List<Member> findAll(){
        return memberRepository.findAll();
    }

    public Member findById(Long id){
        return memberRepository.findById(id).get();
    }

    @Transactional
    public void update(Long id){
        Member member = findById(id);
        //Inserir futuros métodos
        memberRepository.save(member);
    }

    @Transactional
    public void deleteById(Long id) {
        memberRepository.deleteById(id);
    }
}
