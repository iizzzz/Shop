package book.shop.service;

import book.shop.entity.Member;
import book.shop.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberService service;
    @Autowired
    MemberRepository repository;

    @Test
    @DisplayName("회원가입 테스트")
    public void join() throws Exception {
        // Given
        Member member = new Member();
        member.setName("A");

        // When
        Long join = service.join(member);

        // Then
        // member와 repo에서 찾은 member가 같은지 검증
        assertEquals(member, repository.findOne(join));
    }

    @Test
    @DisplayName("중복 검증")
    public void checkDuplicated() throws Exception {
        // Given
        Member member1 = new Member();
        member1.setName("A");

        Member member2 = new Member();
        member2.setName("A");

        // When
        service.join(member1);
        service.join(member2);

        // Then
    }
}