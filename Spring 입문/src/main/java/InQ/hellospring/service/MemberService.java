package InQ.hellospring.service;

import InQ.hellospring.domain.Member;
import InQ.hellospring.repository.MemberRepository;
import InQ.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /** 회원가입 **/
    public Long join(Member member){
        // 같은 이름이 있는 중복 회원 X

        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent( m -> {
                    throw new IllegalStateException("ERROR");
                });
    }

    /** 전체 회원 조회 **/
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
    
