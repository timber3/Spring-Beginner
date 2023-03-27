package spring_beginner.spring_begin.repository;

import spring_beginner.spring_begin.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    // Optional 은 만약 찾으려는 ID가 없어서 NULL을 반환할 때 감싸서 반환한다고 함.
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
