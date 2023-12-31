package hello.servlet.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemberRepositoryTest {
    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        //given
        Member member = new Member("Hello", 20);
        //then
        Member savedMember = memberRepository.save(member);
        //when
        Member findMember = memberRepository.findById(savedMember.getId());
        assertThat(findMember).isSameAs(savedMember);
    }

    @Test
    void findAll() {
        //given
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 30);
        memberRepository.save(member1);
        memberRepository.save(member2);
        //then
        List<Member> result = memberRepository.findAll();
        //when
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(member1, member2);
    }

}
