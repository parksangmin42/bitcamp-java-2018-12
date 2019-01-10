package bitcamp.lms;

public class App4 {

  public static void main(String[] args) {
    System.out.println("인수입력 :");
    java.util.Scanner keyboard = new java.util.Scanner(System.in);
    int dan = keyboard.nextInt();
    System.out.println(dan+"단");
    System.out.println("__________________________");
    for (int i = 1; i <= 9; i++) {
      System.out.println(dan+"*"+i+"="+(dan*i));
    }
  }
}
