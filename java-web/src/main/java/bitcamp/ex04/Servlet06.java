// 클라이언트가 보낸 데이터 읽기 - 여러 개의 데이터를 같은 이름으로 보낸 경우 
package bitcamp.ex04;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ex04/s6")
public class Servlet06 extends GenericServlet {

  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {

    req.setCharacterEncoding("UTF-8");
    // 테스트
    // - http://localhost:8080/java-web/ex04/test06.html 실행
    //

    // 같은 이름으로 여러 개의 데이터를 보낼 수 있다.
    // => 예) name=aaa&name=bbb&name=ccc
    //

    String[] names = req.getParameterValues("name");

    res.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = res.getWriter();

    for (String name : names ) {
      out.printf("이름=%s\n", name);
    }


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




































