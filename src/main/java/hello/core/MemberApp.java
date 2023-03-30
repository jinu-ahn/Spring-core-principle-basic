package hello.core;

import hello.core.member.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = new MemberServiceImpl(new MemoryMemberRepository());
//        MemberService memberService = appConfig.memberService();

        // ApplicationContext를 스프링 컨테이너라고 한다.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        /*
        - 메서드 명을 스프링 빈의 이름으로 사용됨.
        - 스프링 컨테이너를 통해서 필요한 스프링 빈를 찾는다. applicationContext.getBean()을 통해 찾는다.
         */
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
