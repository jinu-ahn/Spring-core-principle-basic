package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.DataInputStream;

@Configuration // AppConfig를 설정정보로 사용
public class AppConfig {

    /*
    @Bean memberSErvice -> new MemoryMemberRepository()
    @Bean orderService -> new MemoryMemberRepository()
    싱글톤 패턴이 깨진 것 같지만 같은 인스턴스를 참조함.
     */

    /* @Configuration을 사용하지 않았을 때
    * call AppConfig.memberService
    * call AppConfig.memberRepository
    * call AppConfig.orderService
    * call AppConfig.memberRepository
    * call AppConfig.memberRepository
    * */

    /* @Configuration을 사용했을 때
     * call AppConfig.memberService
     * call AppConfig.memberRepository
     * call AppConfig.orderService
    * */

    @Bean // 스프링 컨테이너에 등록
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        // 생성자 주입
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy() {
        /*할인 정책을 변경할 때에는 return 값만 바꿔주면 된다.*/
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
