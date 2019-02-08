package com.eomcs.lms.context;

import java.util.Map;

public interface ApplicationListener {
  
  // 어플리케이션이 시작될 때 호출
  void startApplication(Map<String, Object> context);
  
  // 어플리케이션이 종료될 때 호출
  void endApplication(Map<String, Object> context);
  
}
