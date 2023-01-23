package hello.core.order;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    OrderService orderService = new OrderServiceImpl();
    MemberService memberService = new MemberServiceImpl();

    @Test
    @DisplayName("[order] 주문생성")
    void createOrder(){
        //given
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        //when
        Order order = orderService.createOrder(memberId, "memberA", 10000);

        //then
        Assertions.assertThat(memberId).isEqualTo(order.getMemberId());
        Assertions.assertThat(10000).isEqualTo(order.getItemPrice());
        Assertions.assertThat(9000).isEqualTo(order.calculatePrice());
    }
}
