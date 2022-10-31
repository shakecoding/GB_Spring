package com.example.ex00.dependency;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // 일반 객체는 이걸 붙이면 spring이 관리한다.
//@Data //초기화 생성자도 만들어 줌. 게터 세터 까지!
@Getter
@ToString
//@NoArgsConstructor // 기본 생성자
//@AllArgsConstructor // 모든 필드 다 초기화하는 생성자
@RequiredArgsConstructor // 원하는 필드 골라서 초기화하는 생성자

// Setter 를 안쓰는 이유는 spring에서 관리하기 때문에 우리가 안써준다. 그리고 final이다.

public class Coding {
//    필드 주입 (단위 테스트에서는 필드 주입을 사용하자)
//    굉장히 편하게 주입할 수 있으나 순환 참조시 오류가 발생하지 않기 때문에 StackOverFlow 발생.
//    final을 붙일 수 없기 때문에 다른 곳에서 변형 가능

//    @Autowired // 필드 주입
//    @NonNull // null 이면 안된다.
    private final Computer computer; // 생성자가 있기 때문에 final 를 쓰게 되면서 오류가 안남.
    // 생성자로 초기화 해줬기에 final 에 값을 넣어주지 않은 것 처럼 보여도 오류가 나지 않는다.

//    생성자 주입
//    순환 참조시 컴파일러 인지 가능, 오류 발생
//    메모리에 할당되면서 초기값으로 주입되므로 final 키워드 사용 가능, 다른 곳에서 변형 불가능.
//    의존성 주입이 되지 않으면 객체가 생성되지 않으므로 NPE 방어
//    생성자에 @Autowired 생략 가능. 그렇기에 required 만 적어주면 final 에 오류가 안난다.
//    @Autowired
//    public Coding(Computer computer) {
//        this.computer = computer;
//    }

    //component 하고 required 하고 final을 해야 주입이 똑바로 된다.
}
