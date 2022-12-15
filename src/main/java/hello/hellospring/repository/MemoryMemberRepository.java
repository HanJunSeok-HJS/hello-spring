package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;
    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // Optional.ofNullable : null값도 반환해줌
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name)) // MemberRepository에서 넘어온 name이 Member 객체에 저장되어 있는 name과 일치하는 name만 넘어오게 됌
                .findAny(); // 찾아온 name과 Member클래스에 저장된 name이 같다면 반환함. Optional로 반환됌.
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); // store객체에 담겨져 있는 모든 회원의 리스트를 가져옴.
    }

    public void clearStore() {
        store.clear();
    }
}
