package spring_beginner.spring_begin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring_beginner.spring_begin.domain.Member;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    @Override
    Optional<Member> findByName(String name);
}
