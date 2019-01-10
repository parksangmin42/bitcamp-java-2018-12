package bitcamp.lms;

import bitcamp.lms.Lesson;

public class App {
  public static void main(String[] args) {
    java.util.Scanner keyboard = new java.util.Scanner(System.in);
    
    final int LENGTH = 10;
    Lesson[] less = new Lesson[LENGTH];
    
    int i = 0;
    while (i < 10) {
      
      less[i] = new Lesson();
      
      System.out.print("번호?");
      less[i].number = keyboard.nextInt();
      keyboard.nextLine();

      System.out.print("수업명?");
      less[i].classname = keyboard.nextLine();

      System.out.print("수업내용");
      less[i].classwhat = keyboard.nextLine();

      System.out.print("시작일?");
      less[i].start = keyboard.nextLine();

      System.out.print("종료일?");
      less[i].end = keyboard.nextLine();

      System.out.print("총수업시간?");
      less[i].total = keyboard.nextInt();
      keyboard.nextLine();

      System.out.print("일수업시간?");
      less[i].day = keyboard.nextInt();
      keyboard.nextLine();

      i++;

      System.out.println("계속 입력하시겠습니까?(Y/n)");
      String re = keyboard.nextLine();
      if (!re.equalsIgnoreCase("y") && !re.equals(""))
        break;
    }
    keyboard.close();
    
    for (int c = 0; c < i; c++) {
      System.out.printf("%d, %s, %s ~ %s, %d\n", less[c].number, less[c].classname,
          less[c].start, less[c].end, less[c].total);
    }
    
  } //end main
} //end class
