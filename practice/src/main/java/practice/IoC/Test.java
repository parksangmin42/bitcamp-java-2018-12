package practice.IoC;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test {
  
  /*
   객체를 저장하는 보관소
   생성자로 부터 받은 dao들의 객체를 담고있음 
  */
  HashMap<String, Object> beanContainer = new HashMap<>();
  
  /*
   파라미터로부터 받은 패키지명과(com.eomcs.lms) 
   Map객체(ServerApp에서 사용할 객체를 담은 / Command 객체가 사용할 DAO)를
   받아서 해당 값들이 null과 0이 아닐 때 키 값들을 전부 담고 해당 키값과 키값으로 꺼낸 
   객체를 addBean해서 객체를 저장하는 저장소에 담아둔다.
  */
  public Test(String packageName, Map<String,Object> beans) throws Exception {
   if (beans != null && beans.size() > 0) {
     Set<String> names = beans.keySet();
     for (String name : names) {
       addBean(name, beans.get(name));
     }
   }
   
//   File packageDir 
   
  }
  
  private void addBean(String name, Object bean) {
    if (name == null || name.length() == 0 || bean == null)
      return;
    beanContainer.put(name, bean);
 // 생성자로 부터 받은 맵 객체들을 클래스 자체적으로 보관하는 보관소에 담아놓는다.
  }
  
  
  
  
  
  
}
























