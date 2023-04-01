package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        /*
        컴포넌트 스캔을 사용하면 @Configuration 이 붙은 설정 정보도 자동으로 등록되기 때문에,
        AppConfig, TestConfig 등 앞서 만들어두었던 설정 정보도 함께 등록되고, 실행되어 버린다.
        그렇기 때문에 @Configuration이 붙은 클래스는 컴포넌트스캔에서 제외하기 위해 설정했다.
         */
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class),
        // basePackages의 하위 패키지를 모두 탐색한다.
        basePackages = "hello.core.member"

)

public class AutoAppConfig {

}
