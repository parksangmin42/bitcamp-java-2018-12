package bitcamp.lms;


public class App {
  public static void main(String[] args) {
    java.util.Scanner keyboard = new java.util.Scanner(System.in);

    int[] number = new int[10];
    String[] classname = new String[10];
    String[] classwhat = new String[10];
    String[] start = new String[10];
    String[] finish = new String[10];
    int[] total = new int[10];
    int[] day = new int[10];

    int i = 0;
    while(i <= 10) {
      System.out.print("번호?");
      number[i] = keyboard.nextInt();
      keyboard.nextLine();

      System.out.print("수업명?");
      classname[i] = keyboard.nextLine();

      System.out.print("수업내용?");
      classwhat[i] = keyboard.nextLine();

      System.out.print("시작일?");
      start[i] = keyboard.nextLine();

      System.out.print("종료일?");
      finish[i] = keyboard.nextLine();

      System.out.print("총수업시간?");
      total[i] = keyboard.nextInt();
      keyboard.nextLine();

      System.out.print("일수업시간?");
      day[i] = keyboard.nextInt();
      keyboard.nextLine();

      i = ++i;

      System.out.print("\n계속 입력하시겠습니까?(Y/n) ");
      String answer = keyboard.nextLine().toLowerCase();
      if (!answer.equals("y") && answer.length() > 0) {
        break;
      } //end if

    } // end while
    i = 0;
    while( i <= 3) {
      System.out.printf("%d, %s   ,%s ~ %s, %d\n", number[i], classname[i], start[i], finish[i], total[i]);
      i = ++i;
    } // end while2
  } //end main
} //end class
