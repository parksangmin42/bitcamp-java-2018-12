// 대기열 개수 설정하기
package ch23.a;

import java.net.ServerSocket;
import java.util.Scanner;

public class Server2 {
  public static void main(String[] args) throws Exception {
    Scanner keyboard = new Scanner(System.in);
    
    //대기열?
    // => 클라이언트가 접속을 요청하면 대기열에 클라이언트 정보를 저장한다.
    // => 대기열의 크기가 클라이언트의 연결을 허락하는 최대 개수이다.
    // => new Socket(포트번호, 대기열크기);
    ServerSocket serverSocket = new ServerSocket(8888, 3);
    
    
    System.out.println("서버 소켓 생성 완료!");
    System.out.println("클라이언트의 연결을 기다림!");
    
    keyboard.nextLine(); 
    
    serverSocket.close();
    System.out.println("서버 소켓을 닫음.");
    
    keyboard.close();
  }
}
