// Stateless 응용 - 계산 결과 유지하기
package ch23.e;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/*
Stateless는 응답을 받은 후에 연결을 끊는다.
다시 요청할 때는 서버와 연결을 다시 한다.
서버쪽에서는 어떻게 클라이언트를 구분하여 작업 결과를 유지할 것인가? 
 */
public class CalculatorClient {
  public static void main(String[] args) {
    
    Scanner keyboard = new Scanner(System.in);
    int response = 0;
    
    while (true) {
      // 계산 요청을 할 때 연산자와 값만 넘긴다.
      // 예) + 2
      // 예) / 3
      //
      System.out.print("> ");
      String input = keyboard.nextLine();
      

      try (Socket socket = new Socket("localhost", 8888);
          PrintStream out = new PrintStream(socket.getOutputStream());
          BufferedReader in = new BufferedReader(
              new InputStreamReader(socket.getInputStream()))) {
        
        System.out.println("서버와 연결됨! 서버에게 계산 작업을 요청함!");
        
        out.println(input);
        out.println(response);
        out.flush();

        String str = in.readLine();
        System.out.println(str);
        try {
        response = Integer.parseInt(str);} catch (Exception e) {}

        if (input.equalsIgnoreCase("quit"))
          break;
        
      } catch (Exception e) {
        e.printStackTrace();
      }
      System.out.println("서버와 연결 끊음!");
      
    } // while
    
    keyboard.close();
  }
}











