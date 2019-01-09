// 메서드 - 파라미터와 리턴 
package ch06;

public class Test04 {
  public static void main(String[] args) {
    int i;
    //i = m1(); // 컴파일 오류! 리턴 값의 타입과 변수의 타입이 맞지 않다.
    String s;
    s = m1(); //ok
    System.out.println(s);
    
    i = m2();
    System.out.println(i);

  }
  
  static String m1() {

    return "홍길동";
    }
  
  static int m2() {
    return 100;
  }
}








