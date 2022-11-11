package hello.core.member.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_o()
    {
        //given
        Member member = new Member(1L, "memberVip", Grade.VIP);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("Basic은 할인 적용이 되지 않아야 한다.")
    void vip_x()
    {
        //given
        Member member2 = new Member(2L, "member", Grade.BASIC);
        //when
        int discount2 = discountPolicy.discount(member2, 10000);
        //then
        assertThat(discount2).isEqualTo(0);
    }
}