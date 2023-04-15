<details>
<summary><h2>객체지향 프로그래밍</h2></summary>
<div markdown="1">

## 객체지향 프로그래밍의 특징
"객체" 들의 모임으로 파악하고자 하는 것으로 각각의 객체는 메시지를 주고받고, 데이터를 처리할 수 있습니다. (협력)
프로그램을 유연하고 변경이 용이하게 만들기 때문에 대규모 소프트웨어 개발에 많이 사용됩니다.
<br></br>

★ 유연하고, 변경이 용이하다
- 레고 블럭 조립하듯이

- 키보드, 마우스 갈아 끼우듯이

- 컴퓨터 부품 갈아 끼우듯이

- 컴포넌트를 쉽고 유연하게 변경하면서 개발할 수 있는 방법

**즉, 객체 지향 프로그래밍의 핵심은 다형성!!**

<h2>역할과 구현을 분리</h2>

역할과 구현으로 구분하면 세상이 단순해지고, 유연해지며 변경도 편리해진다.

>ex) 운전자 (역할)이 있는상태, 자동차는 어떤 종류(구현)여도 자동차의 역할을 한다.
자동차가 바뀌어도(구현) 운전자는 운전할 수 있다. (역할)

역할 = 인터페이스 / 구현 = 인터페이스를 구현한 클래스, 구현 객체

따라서 클라이언트는 대상의 역할(인터페이스)만 알면 되며, 내부구조나 대상 자체를 변경하여도 영향을 받지 않는다.

<h4>핵심❗객체를 설계할 때 역할과 구현을 명확히 분리하여 역할을 먼저 부여하고, 그 역할을 수행하는 구현 객체 만들기</h4>

<h3> ★ 정리 </h3>
- 실시계의 역할과 구현이라는 편리한 컨셉을 다형성을 통해 객체 세상으로 가져올 수 있다.

- 유연하고, 변경이 용이

- 확장 가능한 설계

- 클라이언트에 영향을 주지 않는 변경 가능

- 인터페이스를 안정적으로 잘 설계하는 것이 중요 ★

But 한계로는
- 역할(인터페이스) 자체가 변하면, 클라이언트, 서버 모두에 큰 변경 필요
  - ex) 자동차를 비행기로 변경한다면? / 대본 자체가 변경된다면?
  
🎯즉, 인터페이스를 안정적으로 잘 설계하는 것이 중요하다!!

# SOLID
  ### 좋은 객체 지향 설계의 5가지 원칙
  
> SRP (단일 책임 원칙) : 하나의 클래스는 하나의 책임만 져야한다.
∴ 변경이 있을 때 파급 효과가 적으면 단일 책임 원칙을 잘 따른 것이다.



> OCP (개방-폐쇄 운칙) : 소프트웨어 요소는 확장에는 열려 있으나 변경에는 닫혀 있어야 한다.
∴ 인터페이스를 구현한 새로운 클래스를 하나 만들어서 새로운 기능을 구현 
**❗즉, 다형성을 활용!!**

> LSP (리스코프 치환 원칙) : 프로그램의 객체는 프로그램의 정확성을 깨뜨리지 않으면서 하위 타입의 인스턴스로 바꿀 수 있어야 한다.  
∴ 다형성에서 하위 클래스는 인터페이스 규약을 다 지켜야 한다는 것, 다형성을 지원하기 위한 원칙, 인터페이스를 구현한 구현체를 믿고 사용하려면 이 원칙이 필요

> ISP (인터페이스 분리 원칙) : 특정 클라이언트를 위한 인터페이스 여러 개가 범용 인터페이스 하나보다 낫다.  
∴ 인터페이스가 명확해지고, 대체 가능성이 높아진다.

> DIP (의존관계 역전 원칙) : 프로그래머는 "**추상화에 의존해야지, 구체화에 의존하면 안된다.**" 의존성 주입은 이 원칙을 따르는 방법 중 하나이다.  
∴ 구현 클래스에 의존하지 말고, 인터페이스에 의존하라는 뜻  
❗ 즉, **역할** 에 의존해야지 **구현**에 의존하면 안된다. 인터페이스에 의존해야 유연하게 구현체를 변경할 수 있다.  

---
## ★ 정리
- 객체 지향의 핵심은 다형성
- 다형성 만으로는 쉽게 부품을 갈아 끼우듯이 개발할 수 없다.
- 다형성 만으로는 구현 객체를 변경할 때 클라이언트 코드도 함께 변경된다.
- 다형성 만으로는 OCP, DIP를 지킬 수 없다.
∴ 뭔가 더 필요하다.
</div>
</details>

<details>
<summary><h2>객체지향 원리적용</h2></summary>
<div markdown="1">

# 새로운 할인 정책 적용과 문제점
```
//private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
```
위 코드에서의 문제점으로는 정액 할인 정책에서 정률 할인 정책으로 변경시, 
추상화(인터페이스), 구체클래스(할인 정책 구현 클래스) 모두 의존 한다. 

실제 의존관계
![](https://velog.velcdn.com/images/ahn_s/post/d90f81e1-80e5-4798-bee2-d15fd58b55f2/image.png)

잘보면 클라이언트인 OrderServiceImpl 이 DiscountPolicy 인터페이스 뿐만 아니라
FixDiscountPolicy 인 구체 클래스도 함께 의존하고 있다. 실제 코드를 보면 의존하고 있다! DIP 위반사항이다.

![](https://velog.velcdn.com/images/ahn_s/post/aead71a6-b613-47f0-af3f-79a83aa02b58/image.png)

중요!: 그래서 FixDiscountPolicy 를 RateDiscountPolicy 로 변경하는 순간 OrderServiceImpl 의 소스 코드도 함께 변경해야 한다! OCP 위반하였다.

예를 들어 보자면,
공연을 예로 들어 로미오 역할(인터페이스)을 하는 디카프리오라는 남자 배우(구현체)가 줄리엣 역할(인터페이스)을 하는 여자 주인공(구현체)를 초빙하는 것과 같으며 디카프리오는 공연도하고 여자 주인공도 초빙하는 다양한 책임을 가지게 된다.
역할에 맞는 배우를 지정하는 책임을 담당하는 별도의 공연 기획자가 필요하고, 배우와 공연 기획자의 책임을 확실히 분리해야함. (관심사 분리)

---

> 해결방안 (관심사 분리)

애플리케이션의 전체 동작 방식을 구성(config)하기 위해, **'구현 객체를 생성'** 하고, **'연결'** 하는 책임을 가지는 별도의 설정 클래스를 만들기

### AppConfig (객체의 생성과 연결을 담당)
```
public class AppConfig {

    public MemberService memberService() {
        // 생성자 주입
        return new MemberServiceImpl(memberRepository());
    }
    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    private DiscountPolicy discountPolicy() {
    /*할인 정책을 변경할 때에는 return 값만 바꿔주면 된다.*/
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
```
애플리케이션의 실제 동작에 필요한 '구현 객체를 생성' 한다.
- MemberServiceImpl
- MemoryMemberRepository
- OrderServiceImpl
- FixDiscountPolicy

AppConfig는 생성한 객체 인스턴스의 참조(레퍼런스)를 생성자를 통해서 주입(연결)해준다.
- MemberServiceImpl MemoryMemberRepository
- OrderServiceImpl MemoryMemberRepository , FixDiscountPolicy

이렇게 된다면 MemberServiceImpl 은 이제부터 의존관계에 대한 고민은 외부에 맡기고 실행에만 집중하면 된다.

즉, DIP 완성 - MemberServiceImpl 은 MemberRepository 인 추상에만 의존하면 된다. 이제 구체 클래스를
몰라도 된다.

---
### 좋은 객체 지향 설계의 5가지 원칙의 적용
여기서는 3가지 SRP , DIP , OCP 적용됨.

> 1. SRP 단일 책임 원칙 : 한 클래스는 하나의 책임만 가져야 한다.
- SRP 단일 책임 원칙을 따르면서 관심사 분리
- AppConfig: 구현 객체를 생성하고 연결하는 책임
- 클라이언트 객체: 실행하는 책임

> 2. DIP 의존관계 역전 원칙 : 프로그래머는 "추상화에 의존해야지, 구체화에 의존하면 안된다." 의존성 주입은 이 원칙을 따르는 방법 중 하나다.
- 클라이언트 코드가 추상화 인터페이스, 구체화 구현 클래스 함께 의존 했었지만, AppConfig가 구체화 구현 클래스 인스턴스를 클라이언트 코드 대신 생성해서 클라이언트 코드에 의존관계를 주입함으로써 클라이언트 코드는 추상화 인터페이스만 의존할 수 있게 되어 DIP 원칙을 지켰다.

> 3. OCP 개방-폐쇄 원칙 : 소프트웨어 요소는 확장에는 열려 있으나 변경에는 닫혀 있어야 한다.
- AppConfig가 의존관계인 할인 정책을 변경해서 클라이언트 코드에 주입하므로 클라이언트 코드는 변경하지 않아도 된다.
</div>
</details>

<details>
<summary><h2>스프링 컨테이너</h2></summary>
<div markdown="1">
  
## 스프링 컨테이너 생성
  
```java
//스프링 컨테이너 생성
ApplicationContext applicationContext =
        new AnnotationConfigApplicationContext(AppConfig.class);
```

> - ApplicationContext 를 스프링 컨테이너 이며 인터페이스이다.  
> - 스프링 컨테이너는 XML을 기반으로 만들 수 있고, 애노테이션 기반의 자바 설정 클래스로 만들 수 있다.  
> - new AnnotationConfigApplicationContext(AppConfig.class) 클래스는 ApplicationContext 인터페이스의 구현체이다.

+더 정확히는 스프링 컨테이너를 부를 때 BeanFactory , ApplicationContext 로 구분해서
이야기하는데, BeanFactory 를 직접 사용하는 경우는 거의 없으므로 일반적으로 ApplicationContext 를 스프링 컨테이너라 부른다.

![](https://velog.velcdn.com/images/ahn_s/post/3bd3478c-b75b-4584-94d1-4cfdd4fd8197/image.png)

**❗❗주의!** : 빈 이름은 항상 다른 이름을 부여해야 한다. 같은 이름을 부여하면, 다른 빈이 무시되거나, 기존 빈을 덮어버리거나 설정에 따라 오류가 발생한다.

---
## 스프링 컨테이너에서 데이터 조회

- 컨테이너에 등록된 모든 빈 조회하기
```java
public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    /*
    * ac.getBeanDefinitionNames() : 스프링에 등록된 모든 빈 이름을 조회한다.
    * ac.getBean() : 빈 이름으로 빈 객체(인스턴스)를 조회한다.
    */

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {

        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name=" + beanDefinitionName + " object=" + bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            //Role ROLE_APPLICATION : 직접 등록한 애플리케이션 빈
            //Role ROLE_INFRASTRUCTURE : 스프링이 내부에서 사용하는 빈

            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name=" + beanDefinitionName + " object=" + bean);
            }

        }
    }
}
```
---
- 스프링 빈 조회 - 기본
스프링 컨테이너에서 스프링 빈을 찾는 가장 기본적인 조회 방법
   - ac.getBean(빈이름, 타입)
   - ac.getBean(타입)
   
```java
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        //memberService가 MemberServiceImpl의 인스턴스 이면 성공
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void findBeanByType() {
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    // 구체타입으로 조회하면 유연성이 떨어진다.
    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2() {
        MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회 실패")
    void findBeanByNameFail() {
        //ac.getBean("xxxx",MemberService.class);
        assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("xxxx", MemberService.class));

    }
}
```
---
- 스프링 빈 조회 - 동일한 타입이 둘 이상
   - 타입으로 조회시 같은 타입의 스프링 빈이 둘 이상이면 오류가 발생한다. 이때는 빈 이름을 지정하자.
   - ac.getBeansOfType() 을 사용하면 해당 타입의 모든 빈을 조회할 수 있다.
   
```java
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextSameBeanFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 중복 오류가 발생한다.")
    void findBeanByTypeDuplicate() {
        assertThrows(NoUniqueBeanDefinitionException.class,
                () -> ac.getBean(MemberRepository.class));
    }

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 빈 이름을 지정하면 된다.")
    void findBeanByName() {
        MemberRepository memberRepository = ac.getBean("memberRepository1",MemberRepository.class);
        assertThat(memberRepository).isInstanceOf(MemberRepository.class);
    }

    @Test
    @DisplayName("특정 타입을 모두 조회하기")
    void findAllBeanByType() {
        Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);

        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " value = " + beansOfType.get(key));
        }
        System.out.println("beansOfType = " + beansOfType);
        assertThat(beansOfType.size()).isEqualTo(2);
    }

    @Configuration
    static class SameBeanConfig {
        @Bean
        public MemberRepository memberRepository1() {
            return new MemoryMemberRepository();
        }

        @Bean
        public MemberRepository memberRepository2() {
            return new MemoryMemberRepository();
        }
    }
}

```
---
- 스프링 빈 조회 - 상속관계
   - 부모 타입으로 조회하면, 자식 타입도 함께 조회한다.
   - 그래서 모든 자바 객체의 최고 부모인 Object 타입으로 조회하면, 모든 스프링 빈을 조회한다.
![](https://velog.velcdn.com/images/ahn_s/post/2029933e-32a9-4ece-924f-fd3827669de4/image.png)
```java
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextExtendsFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    @DisplayName("부모 타입으로 조회시, 자식이 둘 이상 있으면, 중복 오류가 발생한다.")
    void findBeanByParentTypeDuplicate() {
        assertThrows(NoUniqueBeanDefinitionException.class,
                () -> ac.getBean(DiscountPolicy.class));
    }

    @Test
    @DisplayName("부모 타입으로 조회시, 자식이 둘 이상 있으면, 빈 이름을 지정하면 된다.")
    void findBeanByParentTypeName() {
        DiscountPolicy rateDiscountPolicy = ac.getBean("rateDiscountPolicy", DiscountPolicy.class);
        assertThat(rateDiscountPolicy).isInstanceOf(RateDiscountPolicy.class);
    }

    @Test
    @DisplayName("특정 하위 타입으로 조회")
    void findBeanBySubType() {
        RateDiscountPolicy bean = ac.getBean(RateDiscountPolicy.class);
        assertThat(bean).isInstanceOf(RateDiscountPolicy.class);
    }

    @Test
    @DisplayName("부모 타입으로 모두 조회하기")
    void findAllBeanByParentType() {
        Map<String, DiscountPolicy> beansOfType = ac.getBeansOfType(DiscountPolicy.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " value = " + beansOfType.get(key));
        }
    }
    
    @Test
    @DisplayName("부모 타입으로 모두 조회하기 - Object")
    void findAllBeanByObjectType() {
        Map<String, Object> beansOfType = ac.getBeansOfType(Object.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " value = " + beansOfType.get(key));
        }
    }
    @Configuration
    static class TestConfig {
        @Bean
        public DiscountPolicy rateDiscountPolicy() {
            return new RateDiscountPolicy();
        }
        @Bean
        public DiscountPolicy fixDiscountPolicy() {
            return new FixDiscountPolicy();
        }
    }
}
```
---
## BeanFactory와 ApplicationContext

> "BeanFactory"
- 스프링 컨테이너의 최상위 인터페이스로 빈을 관리하고 조회하는 역할을 담당한다

> "ApplicationContext
- BeanFactory 기능을 모두 상속받아서 제공한다.

![](https://velog.velcdn.com/images/ahn_s/post/1aee564a-cc06-460f-a9bf-628928259fa2/image.png)

> - 메시지소스를 활용한 국제화 기능
   - 예를 들어서 한국에서 들어오면 한국어로, 영어권에서 들어오면 영어로 출력
> - 환경변수
   - 로컬, 개발, 운영등을 구분해서 처리
> - 애플리케이션 이벤트
   - 이벤트를 발행하고 구독하는 모델을 편리하게 지원
> - 편리한 리소스 조회
   - 파일, 클래스패스, 외부 등에서 리소스를 편리하게 조회

 
</div>
</details>
