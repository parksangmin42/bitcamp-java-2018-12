/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bitcamp.lms;

public class App3 {
  public static void main (String[]agr) {
    
    
    java.util.Scanner keyboard = new java.util.Scanner(System.in);
    java.util.Date today = new java.util.Date();
    
    int[] number = new int[5];
    String[] what = new String[5];


    int index = 0;
    while (index < 5) {
      
      System.out.print("번호?");
      number[index] = keyboard.nextInt();
      keyboard.nextLine();

      System.out.print("내용?");
      what[index] = keyboard.nextLine();

      
      
      index++;

      System.out.println("계속 입력하시겠습니까?(Y/n)");
      String re = keyboard.nextLine();
      if (!re.equalsIgnoreCase("y") && !re.equals(""))
        break;
      
     
    }
    int count = 0;
    keyboard.close();
    
    
    for (int c = 0; c < index; c++) {
      System.out.printf("%d, %s, %3$tY-%3$tm-%3$td, %4$d\n", number[c], what[c], today, 
          count);
    }
    
  }
}
