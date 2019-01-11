package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class App {

  public static void main(String[] args) {

    final int LENGTH = 10;
    Scanner keyboard = new Scanner(System.in);
    Lesson[] lessons = new Lesson[LENGTH];
    Member[] members = new Member[LENGTH];
    Board[] boards = new Board[LENGTH];
    
    int i = 0;
    while (i < LENGTH) {

      System.out.println("명령> ");

      String a = keyboard.nextLine().toLowerCase();
      if (a.equals("/lesson/add")) {

        Lesson less = new Lesson();

        System.out.print("번호? ");
        less.no = Integer.parseInt(keyboard.nextLine());
        System.out.print("수업명? ");
        less.title = keyboard.nextLine();

        System.out.print("설명? ");
        less.contents = keyboard.nextLine();

        System.out.print("시작일? ");
        less.startDate = Date.valueOf(keyboard.nextLine());

        System.out.print("종료일? ");
        less.endDate = Date.valueOf(keyboard.nextLine());

        System.out.print("총수업시간? ");
        less.totalHours = Integer.parseInt(keyboard.nextLine());

        System.out.print("일수업시간? ");
        less.dayHours = Integer.parseInt(keyboard.nextLine());
        
        System.out.println("저장하였습니다.");


        lessons[i] = less;
        i++; // 배열의 인덱스를 증가시킨다.
        // 사용자가 입력한 값을 소문자로 변환한다.
      }else if(a.equals("/lesson/list")) {
        for (int j = 0; j < i; j++) {
          System.out.printf("%3d, %-15s, %10s ~ %10s, %4d\n", 
              lessons[j].no, lessons[j].title, lessons[j].startDate, lessons[j].endDate,
              lessons[j].totalHours);
        }
      }else if (a.equals("/member/add")) {
        
        Member mem = new Member();
        
        System.out.print("번호? ");
        mem.no = Integer.parseInt(keyboard.nextLine());
        
        System.out.print("이름? ");
        mem.name = keyboard.nextLine();
        
        System.out.print("이메일? ");
        mem.email = keyboard.nextLine();
        
        System.out.print("암호? ");
        mem.password = keyboard.nextLine();
    
        System.out.print("사진? ");
        mem.photo = keyboard.nextLine();
    
        System.out.print("전화? ");
        mem.tel = keyboard.nextLine();
        
        System.out.println("저장하였습니다.");
    
        mem.registeredDate = new Date(System.currentTimeMillis()); 
        
        members[i] = mem;
        i++;
        
      }else if (a.equals("/member/list")) {
        for (int j = 0; j < i; j++) {
          System.out.printf("%3d, %-4s, %-20s, %-15s, %s\n", 
              members[j].no, members[j].name, members[j].email, members[j].tel, members[j].registeredDate);
        }
        
      }else if(a.equals("/board/add")) {
        
        Board bor = new Board();
        
        
        System.out.print("번호? ");
        bor.no = Integer.parseInt(keyboard.nextLine());
        
        System.out.print("내용? ");
        bor.contents = keyboard.nextLine();
        
        System.out.println("저장하였습니다.");
        
        bor.createdDate = new Date(System.currentTimeMillis()); 
        
        bor.viewCount = 0;
        
        boards[i] = bor;
        i++;
        
      }else if (a.equals("/board/list")) {
        for (int j = 0; j < i; j++) {
          System.out.printf("%3d, %-20s, %s, %4$d\n", 
              boards[j].no, boards[j].contents, boards[j].createdDate, boards[j].viewCount);
        }
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
  }

