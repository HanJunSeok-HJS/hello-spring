package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); // 회원의 id, name이 저장됌.
    Optional<Member> findById(Long id); // 회원의 id로 정보를 가져올 수 있음.
    Optional<Member> findByName(String name); // 회원의 name로 정보를 가져올 수 있음.
    List<Member> findAll(); // 모든 회원의 정보를 가져올 수 있음.
}
