package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.*;

public class LessonHandler {
  
  public static final int LENGTH = 10;
  public static Scanner keyboard = new Scanner(System.in);
  public static Lesson[] lessons = new Lesson[LENGTH];
  public static int i = 0;
  
  public static void listLesson() {
     for (int j = 0; j < i; j++) {
      System.out.printf("%3d, %-15s, %10s ~ %10s, %4d\n", 
          lessons[j].no, lessons[j].title, lessons[j].startDate, lessons[j].endDate,
          lessons[j].totalHours);
    }
  }

  public static int addLesson() {
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
    return i;
  }
}
