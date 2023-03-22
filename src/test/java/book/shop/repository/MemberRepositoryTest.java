package book.shop.repository;

import book.shop.entity.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @DisplayName("Save 테스트")
    @Transactional
    public void testMember() {
        // Given
        Member member = new Member();
        member.setName("A");

        // When
        Long id = memberRepository.save(member);
        Member result = memberRepository.find(id);

        // Then
        Assertions.assertThat(result.getId()).isEqualTo(member.getId());
        Assertions.assertThat(result.getName()).isEqualTo(member.getName());
        Assertions.assertThat(result).isEqualTo(member);
    }
}