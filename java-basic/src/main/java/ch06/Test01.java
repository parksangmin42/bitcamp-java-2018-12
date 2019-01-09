// 메서드 - 정의하고 사용하는 방법
package ch06;

public class Test01 {
  public static void main(String[] args) {
    // 메서드 사용
    // => 특정 기능을 수행하는 명령어를 모아두고 이름을 붙인 것이 메서드이다.
    // => 모아 둔 명령어 블록을 실행하는 것을 "메서드 호출(call)"이라 한다.
    // => 문법
    //    메서드명(); <= 값을 받지 않는 메서드라면
    //    메서드명(값1,값2 ...);  <== 값을 받는 메서드라면. 값을 주지 않으면 오류!
    //    변수 = 메서드명();  <== 실행 결과 값을 되돌려 주는 메서드라면. 물론 받지 않아도 된다.
    //    변수 = 메서드명(값1, 값2, ...);  <== 값을 받고 결과를 리턴하는 메서드라면
    
    m1();
    // 실행 과정 
    // 1) m1() 규칙에 따라 정의한 메서드 블록으로 간다.
    //  2) 메서드 바디를 실행한다.
    //  3) 다시 원래 위치로 돌아온다.
    //  4) 다음 줄을 실행한다.
    
    // 명령어들을 블록에 모아놓고 이름을 부여해 두면 나중에 필요할 때 마다 게속 사용할 수 있다.
    m1();
    m1();
    m1();
  }
  
  // 메서드 정의(definition)
  // => 메서드명, 변수선언 : 메서드 시그너처(method signature)
  // => 메서드 블록 : 메서드 몸체(method body)
  static void m1() {
    System.out.println("Hello!");
  }
}
/*
  # 메서드 
  - 특정 기능을 수행하는 명령어들을 모아 둔 블록
  - 문법
  1) 명령어 블록을 실행할 때 값을 넘겨주지 않고 결과도 넘겨 받지 않는다.
    void 메서드명() {
     문장1;
     문장2;
    }
    
  2) 명령어 블록을 실행할 때 값을 넘겨준다. 그러나 결과는 받지 않는다.
    void 메서드명(변수선언1, 변수선언2, ....) {
     문장1;
     문장2;
    }
    
  3) 명령어 블록을 실행할 때 값을 넘겨주지 않는다. 결과는 받는다.
   리턴타입 메서드명() {
    문장1;
    문장2;
   }
   
  4) 명령어 블록을 실행할 때 값을 넘겨주고 결과를 받는다.
   리턴타입 메서드명(변수선언1, 변수선언2, ...) {
    문장1;
    문장2;
   }
 */







