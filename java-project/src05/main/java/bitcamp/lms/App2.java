/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bitcamp.lms;

public class App2 {
    public static void main(String[] args) {
      java.util.Scanner keyboard = new java.util.Scanner(System.in);
      java.util.Date today = new java.util.Date();
      
      System.out.println("번호 :");
      int number = keyboard.nextInt();
      
      keyboard.nextLine();
      
      System.out.println("이름 : ");
      String name = keyboard.nextLine();
      
      System.out.println("이메일 : ");
      String mail = keyboard.nextLine();
      
      System.out.println("암호 : ");
      int pass = keyboard.nextInt();
      
      keyboard.nextLine();

      
      System.out.println("사진 : ");
      String pic = keyboard.nextLine();
      
      System.out.println("전화번호 : ");
      String phon = keyboard.nextLine();
      
      System.out.printf("번호 : %d\n", number);
      System.out.printf("이름 : %s\n", name);
      System.out.printf("이메일 : %s\n", mail);
      System.out.printf("암호 : %d\n", pass);
      System.out.printf("사진 : %s\n", pic);
      System.out.printf("전화 : %s\n", phon);
      System.out.printf("가입일 : %1$tY-%1$tm-%1$td\n", today );






      
       
    }
}