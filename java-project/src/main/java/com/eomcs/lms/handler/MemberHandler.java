package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.*;

public class MemberHandler {
  
  public static final int LENGTH = 10;
  public static Scanner keyboard = new Scanner(System.in);
  public static int i = 0;
  public static Member[] members = new Member[LENGTH];
  
  public static void listMember() {
    for (int j = 0; j < i; j++) {
      System.out.printf("%3d, %-4s, %-20s, %-15s, %s\n", 
          members[j].no, members[j].name, members[j].email, members[j].tel, members[j].registeredDate);
    }
  }

  public static int addMember() {
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
    return i;
  }
}
