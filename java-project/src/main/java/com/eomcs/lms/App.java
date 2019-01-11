package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.handler.*;

public class App {

  static Scanner keyboard = new Scanner(System.in);
 static final int LENGTH = 10;
 
  public static void main(String[] args) {
    

    int i = 0;
    while (i < LENGTH) {

      String a = prompt();
      
      if (a.equals("/lesson/add")) {

        LessonHandler.addLesson();

      }else if(a.equals("/lesson/list")) {
        LessonHandler.listLesson();
      }else if (a.equals("/member/add")) {

        MemberHandler.addMember();

      }else if (a.equals("/member/list")) {
        MemberHandler.listMember();

      }else if(a.equals("/board/add")) {

        BoardHandler.addBoard();

      }else if (a.equals("/board/list")) {

        BoardHandler.listBoard();

      }else if(a.equals("quit")) {
        break;
      }else {
        System.out.println("명령어를 실행할 수 없습니다.");
      }

      System.out.println();


    }
    keyboard.close();

    System.out.println(); // 빈 줄 출력

  }

  static String prompt() {
    System.out.println("명령> ");
    return keyboard.nextLine().toLowerCase();
  }

 



}

