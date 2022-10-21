package InQ.hellospring.repository;

import InQ.hellospring.domain.Member;
import java.util.List;
import java.util.Optional;
public interface MemberRepository {
    Member save(Member member);

    Optional<Member> findById(Long id);

    List<Member> findByName(String name);

    List<Member> findAll();
}