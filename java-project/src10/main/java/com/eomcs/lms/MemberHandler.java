package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;


public class MemberHandler {
  
  static final int LENGTH = 10;
  static Scanner keyboard = new Scanner(System.in);
  static int i = 0;
  static Member[] members = new Member[LENGTH];
  
  static void listMember() {
    for (int j = 0; j < i; j++) {
      System.out.printf("%3d, %-4s, %-20s, %-15s, %s\n", 
          members[j].no, members[j].name, members[j].email, members[j].tel, members[j].registeredDate);
    }
  }

  static int addMember() {
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
