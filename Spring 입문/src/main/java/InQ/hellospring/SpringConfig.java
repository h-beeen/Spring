package InQ.hellospring;

import InQ.hellospring.repository.JpaMemberRepository;
import InQ.hellospring.repository.MemberRepository;
import InQ.hellospring.repository.MemoryMemberRepository;
import InQ.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig{
    private EntityManager em;
@Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

}
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new JpaMemberRepository();
    }
}
