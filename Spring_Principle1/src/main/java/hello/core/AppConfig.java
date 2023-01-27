package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 설정 정보, 구성 정보
public class AppConfig {

    @Bean
    public MemberRepository memberRepository() {   // 멤버 DB
        return new MemoryMemberRepository();      // DB 선택
    }

    @Bean
    public DiscountPolicy discountPolicy(){ // 할인 정책
        return new FixDiscountPolicy();     // 할인 정책 선택
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }
}
