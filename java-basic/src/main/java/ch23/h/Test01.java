// URL 다루기
package ch23.h;

import java.net.URL;

public class Test01 {

  public static void main(String[] args) throws Exception{
    
    URL url = new URL("http://www.bitcamp.co.kr:80/index.php?main_page=home&articleId=100");
    
    System.out.printf("프로토콜: %s\n", url.getProtocol()); 
    System.out.printf("서버주소: %s\n", url.getHost()); 
    System.out.printf("포트번호: %d\n", url.getPort()); // 포트번호를 생략하면 -1을 리턴한다.
    System.out.printf("자원경로: %s\n", url.getPath()); 
    
    // QuertString
    // => 자원의 경로(path) 다음에 오는 파라미터이다.
    // => 형식: 파리미터명 = 파라미터값&파라미터명=파라미터값&파라미터명=파라미터값
    System.out.printf("QuertString: %s\n", url.getQuery()); 
    // main_page=home&articleId=100
  }
}
