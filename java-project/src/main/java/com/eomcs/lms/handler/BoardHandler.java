package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.*;

public class BoardHandler {
  
  public static final int LENGTH = 10;
  public static Scanner keyboard = new Scanner(System.in);
  public static int i = 0;
  public static Board[] boards = new Board[LENGTH];
  
  public static void listBoard() {
    for (int j = 0; j < i; j++) {
      System.out.printf("%3d, %-20s, %s, %4$d\n", 
          boards[j].no, boards[j].contents, boards[j].createdDate, boards[j].viewCount);
    }
  }

  public static int addBoard() {
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
    return i;
  }

}
