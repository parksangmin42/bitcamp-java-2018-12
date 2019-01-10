package bitcamp.lms;

import java.util.Date;

public class App2 {

  public static void main(String[] args) {
    
    java.util.Scanner keyboard = new java.util.Scanner(System.in);
    java.util.Date today = new java.util.Date();
    
    int[] number = new int[5];
    String[] name = new String[5];
    String[] mail = new String[5];
    int[] password = new int[5];
    String[] poto = new String[5];
    String[] phon = new String[5];

    int index = 0;
    while (index < 5) {
      System.out.print("번호?");
      number[index] = keyboard.nextInt();
      keyboard.nextLine();

      System.out.print("이름?");
      name[index] = keyboard.nextLine();

      System.out.print("이메일");
      mail[index] = keyboard.nextLine();

      System.out.print("암호?");
      password[index] = keyboard.nextInt();
      keyboard.nextLine();
      
      System.out.print("사진?");
      poto[index] = keyboard.nextLine();
      
      System.out.print("전화?");
      phon[index] = keyboard.nextLine();
      
      index++;

      System.out.println("계속 입력하시겠습니까?(Y/n)");
      String re = keyboard.nextLine();
      if (!re.equalsIgnoreCase("y") && !re.equals(""))
        break;
    }
    keyboard.close();
    
    for (int c = 0; c < index; c++) {
      System.out.printf("%d, %s, %s, %4$tY-%4$tm-%4$td\n", number[c], name[c],
          phon[c], today);
    }
    
    

  }  
}
