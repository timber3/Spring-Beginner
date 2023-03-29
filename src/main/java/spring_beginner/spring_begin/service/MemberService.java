package spring_beginner.spring_begin.service;

import spring_beginner.spring_begin.domain.Member;
import spring_beginner.spring_begin.repository.MemberRepository;
import spring_beginner.spring_begin.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository;

    // D.I : Dependency Injection (의존성 주입)
    // 내부에서 인스턴스를 생성하지 않고 외부에서 넣어주는 형태
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /*
    * 회원 가입
    * */
    public Long join(Member member) {
        // 중복 회원 검증
        validateDuplicationMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicationMember(Member member) {
        Optional<Member> result = memberRepository.findByName(member.getName());

        // Optional 이기 때문에 ifPresent를 사용할 수 있음.
        result.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });

        /*
         * 위의 코드를
         * memberRepository.findByName(member.getName()).ifPresent로 바로 엮는게 보기좋다.
         *
         * */
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }



}
