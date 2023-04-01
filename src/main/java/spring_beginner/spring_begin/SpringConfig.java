package spring_beginner.spring_begin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring_beginner.spring_begin.repository.MemberRepository;
import spring_beginner.spring_begin.repository.MemoryMemberRepository;
import spring_beginner.spring_begin.service.MemberService;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

}
