package bitcamp.lms;

import java.util.Date;
import bitcamp.lms.Member;

public class App2 {

  public static void main(String[] args) {
    
    java.util.Scanner keyboard = new java.util.Scanner(System.in);
    java.util.Date today = new java.util.Date();
    
    final int LENGTH = 10;
    Member[] m = new Member[LENGTH];

    int i = 0;
    while (i < LENGTH) {
      
      
      Member m1 = new Member();
      
      System.out.print("번호?");
      m1.number = keyboard.nextInt();
      keyboard.nextLine();

      System.out.print("이름?");
      m1.name = keyboard.nextLine();

      System.out.print("이메일");
      m1.mail = keyboard.nextLine();

      System.out.print("암호?");
      m1.password = keyboard.nextInt();
      keyboard.nextLine();
      
      System.out.print("사진?");
      m1.poto = keyboard.nextLine();
      
      System.out.print("전화?");
      m1.phon = keyboard.nextLine();
      
      m[i] = m1;
      i++;
      System.out.println("계속 입력하시겠습니까?(Y/n)");
      String re = keyboard.nextLine();
      if (!re.equalsIgnoreCase("y") && !re.equals(""))
        break;
    }
    keyboard.close();
    
    for (int c = 0; c < i; c++) {
      System.out.printf("%d, %s, %s, %4$tY-%4$tm-%4$td\n", m[c].number, m[c].name,
          m[c].phon, today);
    }
    
    

  }  
}
