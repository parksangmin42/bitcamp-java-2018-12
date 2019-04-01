// 클라이언트가 보낸 데이터 읽기 - 빈 값과 null
package bitcamp.ex04;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ex04/s7")
public class Servlet07 extends GenericServlet {

  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {

    req.setCharacterEncoding("UTF-8");
    
    // 테스트
    // - http://localhost:8080/java-web/ex04/test07.html 실행
    //

    // 파라미터 이름만 넘어 갈 때 getParameter()의 리턴 값은 빈 문자열 객체이다.
    // null이 아니다.
    // 입력 상자에 값을 입력하지 않아도 빈 문자열이 서버에 전송된다는 것이다.
    // => 예) a=aaa&b=
    //

    res.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = res.getWriter();
    
    out.printf("a = %s\n", req.getParameter("a"));
    out.printf("b = %s\n", req.getParameter("b"));
    
    // 파라미터 이름 자체가 없으면 getParameter()는 null을 리턴한다.
    out.printf("c = %s\n", req.getParameter("c"));
    
  }
}

// => HTTP 요청 형식 
//    method sp request-URI sp http_version CRLF
//    *(general header | request header | entity header) CRLF
//    CRLF
//    message-body

// POST 요청 HTTP 프로토콜 예)
// => POST 요청은 데이터를 message-body에 붙여서 보낸다.
// => 데이터 형식과 URL 인코딩은 GET요청과 같다.
// => 예)
/* 
POST /java-web/ex04/s2 HTTP/1.1
Host: localhost:8080
Connection: keep-alive
Content-Length: 33
Pragma: no-cache
Cache-Control: no-cache
Origin: http://localhost:8080
Upgrade-Insecure-Requests: 1
Content-Type: application/x-www-form-urlencoded
User-Agent: Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,;q=0.8
Referer: http://localhost:8080/java-web/ex04/test02.html
Accept-Encoding: gzip, deflate, br
Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7
빈 줄
 */

// URI (Uniform Resource Identifier)
// => 웹 자원의 위치를 가리키는 식별자
// => 종류 
//    URL(Uniform Resource Locator)
//      예) http://localhost:8080/ex04/s1?name=홍길동&age=20
//
//    URN(Uniform Resource Name)
//      예) urn:lex:eu:council:directive:2010-03-09;2010-19-UE  

// HTTP 응답 프로토콜
// => 형식
//    status-Line(HTTP프로토콜 상태코드 간단한문구) CRLF
//    *(general header | response header | entity header) CRLF
//    CRLF
//    message-body
//    
// => 예)
/*
HTTP/1.1 200
Content-Type: text/plain;charset=UTF-8
Content-Length: 27
Date: Thu, 28 Mar 2019 05:46:13 GMT 
CRLF
 */




































