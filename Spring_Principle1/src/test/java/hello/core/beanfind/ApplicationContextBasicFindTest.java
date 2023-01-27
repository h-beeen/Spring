package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("[bean] 이름 없이 타입으로만 조회")
    void findBeanByType()
    {
        MemberService memberService = ac.getBean(MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
        System.out.println("memberService.getClass() = " + memberService.getClass());
    }

    @Test
    @DisplayName("[bean] 빈 이름으로 조회")
    void findBeanByName()
    {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
        System.out.println("memberService = " + memberService);
    }

    @Test
    @DisplayName("[bean] 구현체 타입으로 조회") // 비추비추..개발자는 역할에 의존해야 하기 때문입니다...
    void findBeanByName2()
    {
        MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("[bean] 빈 이름으로 조회 X") // 비추비추..개발자는 역할에 의존해야 하기 때문입니다...
    void findBeanByNameX()
    {
//      ac.getBean("x", MemberService.class);
        assertThrows(NoSuchBeanDefinitionException.class, // junit assertThrows
                () -> ac.getBean("x", MemberService.class));
    }
}
