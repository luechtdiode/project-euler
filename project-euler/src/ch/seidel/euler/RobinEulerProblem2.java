package ch.seidel.euler;

public class RobinEulerProblem2 {
  public static void main(String[] args) {
    long millis = System.currentTimeMillis();
    doImperatively();
    System.out.println("calculated in " + (System.currentTimeMillis() - millis) + " ms");
    millis = System.currentTimeMillis();
    doFunctional();
    System.out.println("calculated in " + (System.currentTimeMillis() - millis) + " ms");
  }

  private static void doImperatively() {
    System.out.println("Summiere alle geraden Fibonacci Zahlen kleiner 4 Millionen:");
    int sum = 2;
    int a   = 1;
    int b   = 2;
    int c   = a + b;
    System.out.println("  2");
    
    while(c < 4000000) {
      if(c % 2 == 0){
        sum = sum + c;
        System.out.println("+ " + c);
      }
      c = a + b;
      a = b;
      b = c;
    }

    System.out.println("Summe ist " + sum);
  }
  
  public static abstract class Selector {
    public abstract boolean take(int value);
  }
  public static abstract class Operation {
    public abstract int calculate(final int aOperand1, final int aOperand2);
  }
  public static class Fibonaccis {
    private final int upperbounce;
    private final Operation operation;
    private final Selector selector;
    
    private Fibonaccis(final int upperbounce) {
      this.upperbounce = upperbounce;
      operation = null;
      selector = null;
    }
    private Fibonaccis(final int upperbounce, final Selector selector) {
      this.upperbounce = upperbounce;
      this.selector = selector;
      operation = null;
    }
    private Fibonaccis(final int upperbounce, final Selector selector, final Operation operation) {
      this.upperbounce = upperbounce;
      this.selector = selector;
      this.operation = operation;
    }
    
    public static Fibonaccis createLowerThan(final int ub) {
      return new Fibonaccis(ub);
    }
    public Fibonaccis select(final Selector selector) {
      return new Fibonaccis(upperbounce, selector);
    }
    
    public int calculate(Operation operation) {
      return new Fibonaccis(upperbounce, selector, operation).collect(1, 2, 0);
    }
    private int collect(final int lastFib, final int currentFib, final int accumulator) {
      if(currentFib > upperbounce) {
        return accumulator;
      }
      else if(selector == null || selector.take(currentFib)) {
        System.out.println("+ " + currentFib);
        return collect(currentFib, lastFib + currentFib, operation.calculate(accumulator, currentFib));
      }
      else {
        return collect(currentFib, lastFib + currentFib, accumulator);
      }
    }
  }
  public static class EvenSelector extends Selector {
    public boolean take(int value) {
      return value % 2 == 0;
    }
  }
  public static class Sum extends Operation {
    public int calculate(final int summand1, final int summand2) {
      return summand1 + summand2;
    }
  }
  
  private static void doFunctional() {
    System.out.println("Summiere alle geraden Fibonacci Zahlen kleiner 4 Millionen:");
    int sum = Fibonaccis.createLowerThan(4000000).select(new EvenSelector()).calculate(new Sum());
    System.out.println("Summe ist " + sum);
  }
}
