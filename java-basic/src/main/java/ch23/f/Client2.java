// Connection-Oriented vs Connectionless
package ch23.f;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client2 {
  @SuppressWarnings("static-access")
  public static void main(String[] args) {

    // Connectionless
    // => 서버와 연결없이 데이터를 보내고 받을 수 있다.
    // => DatagramSocket, DatagramPacket을 사용하여 처리

    // 데이터 송수신을 담당할 소켓을 먼저 준비한다.
    try (DatagramSocket socket = new DatagramSocket()) {

      for (int i = 0; i < 100; i++) {
        // 데이터를 패킷에 담는다
        byte[] bytes = String.format("Hello! - %d", i).getBytes("UTF-8");
        
        DatagramPacket packet = new DatagramPacket(
            bytes, // 보내는 데이터 (바이트 배열)
            bytes.length,
            InetAddress.getByName("localhost"), // 받는 이의 주소
            8888 // 받는 이의 포트 번호
            );

        // 소켓을 이용하여 패킷을 네트워크로 내 보낸다.
        socket.send(packet);
        System.out.println(i + " - 데이터 전송 완료(단 상대편이 해당 패킷을 받았는지는 보장 못함!)");
        
        Thread.currentThread().sleep(500);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
