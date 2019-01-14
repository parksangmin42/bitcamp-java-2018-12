package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.handler.BoardHandler;
import com.eomcs.lms.handler.LessonHandler;
import com.eomcs.lms.handler.MemberHandler;

public class App {
  
  static final int LENGTH = 10;
 static Scanner keyboard = new Scanner(System.in);
 
 

  public static void main(String[] args) {


    LessonHandler.keyboard = keyboard;
    MemberHandler.keyboard = keyboard;
    BoardHandler.keyboard = keyboard;
    
    while (true) {
      
      String command = prompt();
      
      if (command.equals("/lesson/add")) {
        
        LessonHandler.addlesson();
        
      } else if (command.equals("/lesson/list")) {
        
        LessonHandler.listlesson();
      
      } else if (command.equals("/member/add")) {
        
        MemberHandler.addmember();
        
      } else if (command.equals("/member/list")) {
        
        MemberHandler.listmember();
        
      } else if (command.equals("/board/add")) {
        
        BoardHandler.addboard();
        
      } else if (command.equals("/board/list")) {
        
        BoardHandler.listboard();
        
      } else if (command.equals("quit")) {
        System.out.println("안녕!");
        break;
      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }
      System.out.println(); // 결과 출력 후 빈 줄 출력
    }
    keyboard.close();
  } // end main
  
  static String prompt () {
    
    System.out.print("명령> ");
    return  keyboard.nextLine().toLowerCase();
  }
} // end class
