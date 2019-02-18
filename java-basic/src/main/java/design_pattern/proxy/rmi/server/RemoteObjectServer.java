// RMI 기술 사용하기 - 원격 객체를 RMI 레지스트리 서버에 등록하기
package design_pattern.proxy.rmi.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RemoteObjectServer {
  public static void main(String[] args) {
    // 실행방법 
    // 먼저 RMI Registry 서버를 실행하라.
    // > rmiregistry
    // 주의!!!  RMI Registry 서버가 클래스를 찾을 수 있도록 .class 파일이 있는 디렉토리에서 실행하라.
    // java-basic/bin/main > rmiregistry
    // 그리고 이 클래스를 실행한다.
    
    
    // 보안 관리자 등록
    // => 원격에서 접속할 때 사용할 수 있는 자원의 범위를 통제하는 객체
//    if (System.getSecurityManager() == null) {
//      System.setSecurityManager(new SecurityManager());
//    }
    
    try {
      // 원격 객체 생성(실제 일을 한는 객체)
      Calculator calcObj = new CalculatorImpl();
      
      // 원격 객체와 통신을 담당할 프록시(클라이언트 측 ORB)를 생성한다.
      // => 첫 번째 파라미터는 : 원격 객체
      // => 두 번째 파라미터는 : 원격 객체. 0으로 지정하면 임의의 유효한 포트 번호가 지정된다.
      // => 이렇게 RMI 기술을 사용하면 개발자가 skeleton(서버측 대행자 "ORB") 이나 
      //   stub(클라이언트 측 대행자 "ORB")을 작성할 필요가 없다.
      Calculator stub = (Calculator) UnicastRemoteObject.exportObject(calcObj, 0);
      
      // RMI Registry 서버에 스텁 객체를 등록해줄 도구를 준비한다.
      Registry registry = LocateRegistry.getRegistry("study.bitcamp.co.kr");
      
      // Registry 도구를 사용하여 RMI Registry 서버에 stub을 등록한다.
      registry.rebind("calc", stub);
      
      System.out.println("Calculator 객체의 프록시(stub)가 RMI Registry 서버에 등록 되었다.");
    } catch (Exception e) {
      e.printStackTrace();
      
    }
  }
}











