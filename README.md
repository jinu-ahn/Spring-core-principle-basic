<details>
<summary><h1>객체지향 프로그래밍</h1></summary>
<div markdown="1">

<h2>객체지향 프로그래밍의 특징</h2>
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
