package test.test.service;

import test.test.domain.Member;
import test.test.repository.MemberRepository;
import test.test.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository ;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //회원가입
    public Long join(Member member){
        // 이름이 같은 중복 회원X
//        Optional<Member> result = memberRepository.findByName(member.getName());
//        //command+option+v : Optional반환
//        result.ifPresent(m ->{ //m에 값이 있으면 로직이 동작하는 것, Optional이라 가능, 없었으면 if null
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        } );
//
//        memberRepository.save(member);
//        return member.getId();
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                        .ifPresent(m ->{
                            throw new IllegalStateException("이미 존재하는 회원입니다.");
                        } );
    }
    //전체 회원 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
