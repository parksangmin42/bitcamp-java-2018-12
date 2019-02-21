// 16단계: 스레드 풀 적용하기
package com.eomcs.lms;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import com.eomcs.lms.dao.BoardDaoImpl;
import com.eomcs.lms.dao.LessonDaoImpl;
import com.eomcs.lms.dao.MemberDaoImpl;
import com.eomcs.lms.service.BoardDaoSkel;
import com.eomcs.lms.service.LessonDaoSkel;
import com.eomcs.lms.service.MemberDaoSkel;
import com.eomcs.lms.service.Service;

// 풀링(pooling) 기법
// => 자주 사용하는 인스턴스는 미리 생성하여 목록으로 보관하고 있다가 
//    필요할 때 빌려 쓰고, 사용 후 반납하는 방식으로 인스턴스를 관리한다.
// => 기존에 생성된 인스턴스를 재사용하기 때문에 가비지가 줄어 들어 메모리를 보다 효율적으로 사용할 수 있다.
// => 기존의 객체를 재사용 하기 때문에 인스턴스 시간이 많이 소요되능 경우에
//    실헹시간을 줄일 수 있다.
// => flyweight 디자인 패턴" 의 응용이다.
//
// 스레드 풀
// => 한 번 생성한 스레드는 실행 후 버리지 않고 재사용 한다.
// => 스레드 목록 관리에 폴링 기법을 적용하였다.
//
//
public class ServerApp {

  static BoardDaoImpl boardDao; 
  static MemberDaoImpl memberDao;
  static LessonDaoImpl lessonDao;

  static HashMap<String,Service> serviceMap;
  static Set<String> serviceKeySet;

  // 스레드 풀
  static ExecutorService esecutorService = Executors.newCachedThreadPool();

  public static void main(String[] args) {

    try {
      boardDao = new BoardDaoImpl("board.bin");
      boardDao.loadData();
    } catch (Exception e) {
      System.out.println("게시물 데이터 로딩 중 오류 발생!");
    }

    try {
      memberDao = new MemberDaoImpl("member.bin");
      memberDao.loadData();
    } catch (Exception e) {
      System.out.println("회원 데이터 로딩 중 오류 발생!");
    }

    try {
      lessonDao = new LessonDaoImpl("lesson.bin");
      lessonDao.loadData();
    } catch (Exception e) {
      System.out.println("수업 데이터 로딩 중 오류 발생!");
    }

    serviceMap = new HashMap<>();
    serviceMap.put("/board/", new BoardDaoSkel(boardDao));
    serviceMap.put("/member/", new MemberDaoSkel(memberDao));
    serviceMap.put("/lesson/", new LessonDaoSkel(lessonDao));

    serviceKeySet = serviceMap.keySet();

    try (ServerSocket serverSocket = new ServerSocket(8888)) {
      System.out.println("서버 시작!");

      while (true) {
        // 스레드 풀에 독립적으로 해야할 일을 스레드 풀에 맡긴다.
        // 독립적으로 실행 일을 스레드 풀에 맡긴다.
        // => 스페드 풍릉ㄴ현재 놀고 있는  스레기를 꺼내서
        //    파리미터르 넘겨 받은 RequestHandelr의 rum()을 호춣개된다
        esecutorService.submit(new RequestHandler(serverSocket.accept()));
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  static class RequestHandler implements Runnable {

    static int count = 0;

    Socket socket;
    String name;

    public RequestHandler(Socket socket) {
      this.socket = socket;
      this.name = "핸들러-" + count++;
      System.out.printf("[%s:%s] 스레드가 생성됨\n",
          Thread.currentThread().getName(),
          this.getName());
    }

    public String getName() {
      return this.name;
    }

    // 독립적으로 수행할 코드를 run() 메서드에 작성한다.
    @Override
    public void run() {
      try (Socket socket = this.socket;
          ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
          ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {

        System.out.printf("[%s:%s] 클라이언트와 연결되었음.\n", this.getName());

        String request = in.readUTF();
        System.out.printf("[%s:%s]", this.getName(), request);

        Service service = getService(request);

        if (service == null) {
          out.writeUTF("FAIL");

        } else {
          service.execute(request, in, out);
        }
        out.flush();

      } catch (Exception e) {
        e.printStackTrace();
      }
      System.out.printf("[%s:%s]] 클라이언트와의 연결을 끊었음.\n", this.getName());
    }

    static Service getService(String request) {
      for (String key : serviceKeySet) {
        if (request.startsWith(key)) {
          return serviceMap.get(key);
        }
      }
      return null;
    }
  }
}














