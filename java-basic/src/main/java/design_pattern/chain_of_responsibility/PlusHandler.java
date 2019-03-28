package design_pattern.chain_of_responsibility;

public class PlusHandler extends AbstractHandler {
  @Override
  public void handler(int a, int b, String op) {
    if (op.equals("+")) {
      System.out.printf("%d + %d = %d\n", a, b, (a + b));
      return;
    } 

    next.handler(a, b, op);
  }

}
