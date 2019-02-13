// Connection-Oriented vs Connectionless
package ch23.g;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class HttpServer {
  public static void main(String[] args) {

    // HTTP 응답 규칙
    // 
    //
    try(ServerSocket ss = new ServerSocket(8888)) {
      System.out.println("클라이언트 연결 대기 중 ...") ;

      while (true) {
        try (Socket socket = ss.accept();
            PrintStream out = new PrintStream(socket.getOutputStream());
            Scanner in = new Scanner(socket.getInputStream())){

          while (true) {
            String request = in.nextLine();
            System.out.println(request);
            if (request.length() == 0);
            break;
          }
          
          out.println("HTTP/1.1 200 OK");
          out.println("Content-Type: text/html;charset=UTF-8");
          out.println();
          out.println("<html><body><h1>오호라!! 안녕하세요!^^</h1></body></html>");
          out.println();

        } catch (Exception e) {
          e.printStackTrace();
        }
      } //while
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
