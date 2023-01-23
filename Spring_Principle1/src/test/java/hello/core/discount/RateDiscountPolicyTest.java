package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();
    MemberService memberService = new MemberServiceImpl();

    @Test
    @DisplayName("[discount] VIP / 정률할인")
    void vip_o(){
        //given
        Long memberId = 1L;
        Member member1 = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member1);

        //when
        int discount = discountPolicy.discount(member1, 20000);

        //then
        Assertions.assertThat(discount).isEqualTo(2000);
    }

    @Test
    @DisplayName("[discount] Basic / 무할인")
    void vip_x(){
        //given
        Long memberId = 2L;
        Member member2 = new Member(2L, "memberB", Grade.Basic);
        memberService.join(member2);

        //when
        int discount = discountPolicy.discount(member2, 10000);

        //then
        Assertions.assertThat(discount).isEqualTo(0);
    }
}
