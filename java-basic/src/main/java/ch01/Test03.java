// 주석

// 한 줄 주석 - 줄 끝까지 주석으로 취급.


/*
여러줄 주석
시작 점 부터 끝 까지 
주석을 이쁘게 표현하기 위해 시작줄에 *사용해서 쓰는 경우가 있다 
앞에 *는 의미없다 그냥 꾸미는것
 * ㅇㅇ
 * ㄴㄴ

 */
/*
 # javadoc 사용법
 

   $ javadoc -d [문서를저장할폴더] -sourcespath [소스폴더] 패키지명
   $ javadoc -d doc -sourcepath src/main/java ch01
   */
   
package ch01; //이 소스 파일에 작성하는 모든 클래스는 ch01 패키지에 소속된다.

/**
 java doc 주석이라 한다.
 즉 자바 API 문서를(HTML) 생성할 때 참고하는 주석.
 클래스, 변수, 메서드, 선언에 붙인다.
 */


public class Test03 {

/**
    이 메서드는 object 클래스의 메서드를 재정의한 것이다.
 */
    @Override // 애노테이션이라 부르는 주석이다. 프로그램에서 사용한다.
    public String toString() {
        return "ok";
    }
   public static void main(String[] args) {
        System.out.println("Hello!");
    } //end main
} //end class




// 컴파일하는 현재 폴더에 각 class에 대한 바이트코드를 생성한다.
