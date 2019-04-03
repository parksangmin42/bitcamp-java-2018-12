// 세션(Session) 무효화 시키기 - 세션 무효화하기
package bitcamp.ex11;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/ex11/s33")
public class Servlet33 extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, 
      HttpServletResponse response)
          throws ServletException, IOException {

    HttpSession session = request.getSession();
    session.invalidate(); // 세션을 무효화시킨다(로그아웃 할때 세션을 무효화시켜 삭제시킨다)
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("세션을 무효화 시켰습니다.");
  }


}




































