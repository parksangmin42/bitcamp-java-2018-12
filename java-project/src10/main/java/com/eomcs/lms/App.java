package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class App {

  static final int LENGTH = 10;
  static Scanner keyboard = new Scanner(System.in);
  static int i = 0;
  static Board[] boards = new Board[LENGTH];
  static Member[] members = new Member[LENGTH];
  static Lesson[] lessons = new Lesson[LENGTH];

  public static void main(String[] args) {


    int i = 0;
    while (i < LENGTH) {

      String a = prompt();
      
      if (a.equals("/lesson/add")) {

        addLesson();

      }else if(a.equals("/lesson/list")) {
        listLesson();
      }else if (a.equals("/member/add")) {

        addMember();

      }else if (a.equals("/member/list")) {
        listMember();

      }else if(a.equals("/board/add")) {

        addBoard();

      }else if (a.equals("/board/list")) {

        listBoard();

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

