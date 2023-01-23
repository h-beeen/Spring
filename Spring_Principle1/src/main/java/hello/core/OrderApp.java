package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.order.Order;
import hello.core.order.OrderService;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appconfig = new AppConfig();

        MemberService memberService = appconfig.memberService();
        OrderService orderService = appconfig.orderService();

        Long memberId = 1L;
        Member member1 = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member1);

        Order order = orderService.createOrder(memberId, "itemA", 35000);
        System.out.println("order = " + order);
        System.out.println("order.calculatePrice() = " + order.calculatePrice());
    }
}
