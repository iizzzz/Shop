package book.shop.repository;

import book.shop.entity.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    // 저장
    public void save(Member member) {
        em.persist(member);
    }

    // 단건 조회
    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    // 전체 조회
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }

    // 파라미터 바인딩을 통해 이름으로 조회
    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}
