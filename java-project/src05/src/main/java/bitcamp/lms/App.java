package bitcamp.lms;


public class App {
  public static void main(String[] args) {
    java.util.Scanner keyboard = new java.util.Scanner(System.in);
    int[] number = new int[5];
    String[] classname = new String[5];
    String[] classwhat = new String[5];
    String[] start = new String[5];
    String[] end = new String[5];
    int[] total = new int[5];
    int[] day = new int[5];

    int index = 0;
    while (index < 5) {
      System.out.print("번호?");
      number[index] = keyboard.nextInt();
      keyboard.nextLine();

      System.out.print("수업명?");
      classname[index] = keyboard.nextLine();

      System.out.print("수업내용");
      classwhat[index] = keyboard.nextLine();

      System.out.print("시작일?");
      start[index] = keyboard.nextLine();

      System.out.print("종료일?");
      end[index] = keyboard.nextLine();

      System.out.print("총수업시간?");
      total[index] = keyboard.nextInt();
      keyboard.nextLine();

      System.out.print("일수업시간?");
      number[index] = keyboard.nextInt();
      keyboard.nextLine();

      index++;

      System.out.println("계속 입력하시겠습니까?(Y/n)");
      String re = keyboard.nextLine();
      if (!re.equalsIgnoreCase("y") && !re.equals(""))
        break;
    }
    keyboard.close();
    
    for (int c = 0; c < index; c++) {
      System.out.printf("%d, %s, %s ~ %s, %d\n", number[c], classname[c],
          start[c], end[c], total[c]);
    }
    
    

  } //end main
} //end class
