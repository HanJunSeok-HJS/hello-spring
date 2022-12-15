package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    @AfterEach // 테스트 코드를 순차적으로 실행하여 오류 방지
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        Member member = new Member();
        member.setName("spring");

        memberRepository.save(member);

        Member result = memberRepository.findById(member.getId()).get(); // MemoryMemberRepository에서 아이디를 저장하면 시퀀스가 ++되는 것을 확인할 수 있다. 만약에 아이디가 저장이 되었다면 테스트 코드가 실행될 것이다.
        assertThat(member).isEqualTo(result);
    }

    @Test
    void findById() {
    }

    @Test
    void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        memberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        memberRepository.save(member2);

        Member result = memberRepository.findByName("spring1").get(); // get() : Optional사용하여 꺼내옴
        assertThat(result).isEqualTo(member1);
    }

    @Test
    void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        memberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        memberRepository.save(member2);

        List<Member> result = memberRepository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }

}