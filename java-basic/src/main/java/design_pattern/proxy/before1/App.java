package design_pattern.proxy.before1;

public class App {

  public static void main(String[] args) {
    Calculator clac = new Calculator();
    
    System.out.println(clac.plus(100, 200));
    System.out.println(clac.minus(100, 200));
    
  }

}
