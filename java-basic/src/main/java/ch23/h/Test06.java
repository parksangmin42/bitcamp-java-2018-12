// Apache HttpComponent 사용 - HttpGet 사용 
package ch23.h;

import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Test06 {

  public static void main(String[] args) throws Exception{

    // HttpGet 클래스
    // => www.apache.org 사이트에서 제공하는 외부 HttpComponent 라이브러리에 들어있는 클래스이다.
    // => 사용하려면 먼저 외부 라이브러리를 프로젝트로 가져와야 한다. 
    //   1) manrepository.com 에서 apache http 키워드로 검색한다.

    // 1) HTTP 요청을 수행할 객체를 준비한다.
    CloseableHttpClient httpClient = HttpClients.createDefault();

    // 2) HTTP GET 요청 정보를 준비한다.
    HttpGet get = new HttpGet("https://www.naver.com");

    // 3) HttpClient 객체를 사용하여 GET 요청을 실행한다.
    //  => 리턴 값은 웹 서버의 응답 데이터를 다루는 도구이다.
    CloseableHttpResponse response = httpClient.execute(get);

    // 4) 응답 도구를 이용하여 서버가 보낸 데이터를 꺼낸다.
    HttpEntity entity = response.getEntity();

    if (entity != null) {
      // 5) HttpEntity 객체에 들어 있는 값을 문자열로 변환하여 출력한다.
      System.out.printf("응답 데이터 크기 => %d\n",
          entity.getContentLength());
      System.out.printf("응답 데이터의 MIME 타입 => %s\n",
          entity.getContentType());
      System.out.println("-------------------------------------------");
      // HttpEntity에 들어있는 서버 응답 데이터를 꺼내려면 getContent()를 사용해야 한다.
      // getContent()의 리턴 값은 InputStream 객체이다.
      // InputStream을 가지고 데이터를 일긍려면 다시 입출력 코딩을 작성해야 한다.
      // => 이 부분을 대신해 주는 도우미 클래스가 있다.
      String content = EntityUtils.toString(entity);
      System.out.println(content);
    }
  }
}













