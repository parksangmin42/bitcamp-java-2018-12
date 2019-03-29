// HTTP 프로토콜 다루기 - MyHttpServlet 클래스 사용하기
package bitcamp.ex05;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex05/s2")
public class Servlet02 extends MyHttpServlet {
  
  private static final long serialVersionUID = 1L;

  @Override
  protected void service(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    // 테스트
    // - http://localhost:8080/java-web/ex05/test02.html 실행
    //
    
    // HTTP 프로토콜로 통신을 하는 Servlet Container
    // service() 메서드를 호출할 때
    // ServletRequest의 값으로 HttpServletRequest를 전달한다.
    // ServletResponse의 값으로 HttpServletResponse를 전달한다.
    // 따라서 service() 메서드의 파라미터 값은 원래
    // HttpServletRequest와 HttpServletResponse이다.
    // 이들 객체에는 HTTP 프로토콜을 다루는 메서드가 추가되어 있다.
    // 따라서 HTTP 프로토콜을 다루고 싶다면 파라미터 값을
    // 원래의 타입으로 변환하라.
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    if (request.getMethod().equals("GET")) {
      out.println("GET 요청입니다.");
      
    } else if ((request.getMethod().equals("POST"))) {
      out.println("POST 요청입니다.");
      
    } else {
      out.println("이 서블릿이 다루지 못하는 요청 방식입니다.");
    }
    
  }
}




































