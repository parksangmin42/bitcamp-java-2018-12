// 클라이언트 만들기
package ch23.a;

import java.net.Socket;

public class Client1 {

  public static void main(String[] args) throws Exception {
    // 클라이언트?
    // =>
    
    // 1) 도구 준비
    // => 서버와의 연결이 이루어지면 Socket 객체를 리턴한다.
    Socket socket = new Socket(
        "localhost", // IP 주소(ex: 234.3.4.56) 또는 도메인명(ex: www.daum.net)
             // 127.0.0.1 (특수아이피) - 로컬 컴퓨터를 가르킨다.
             // 특수 도메인명 : localhost - 127.0.0.1을 가리킨다.
        
        8888 // 포트번호 - 서버를 구분하는 식별 번호.
            // IP 주소가 회사 대표 번호라면, 포트 버호는 내선 번호라 할 수 있다.
        );
    System.out.println("서버와 연결되었음!");
    
    // 2) 서버 연결 해제
    socket.close();
  }

}
