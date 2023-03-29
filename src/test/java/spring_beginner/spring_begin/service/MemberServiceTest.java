package spring_beginner.spring_begin.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spring_beginner.spring_begin.domain.Member;
import spring_beginner.spring_begin.repository.MemoryMemberRepository;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        // given
        Member member = new Member();
        member.setName("Spring");

        // when
        Long saveId = memberService.join(member);

        // then
        Member result = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(result.getName());
    }

    @Test
    public void 중복_회원_예외() {
        // given
        Member member1 = new Member();
        member1.setName("Spring");

        Member member2 = new Member();
        member2.setName("Spring");
        // when
        memberService.join(member1);
        assertThrows(IllegalStateException.class, () -> memberService.join(member2));


/*        try {
            memberService.join(member2);
            fail();
        } catch (IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }*/

        // then
    }


    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}