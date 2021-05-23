/**
 * The Factorial program implements a function to calculate n factorial recursively.
 * <p>
 * This program was made as a solution to grudat21 uppgift 3.1
 *
 * @author Elias Rilegård
 * @version 1.0
 * @since 2020-04-18
 */

class Factorial {
  /**
   * Recursively calculates n factorial.
   *
   * @param n The value to calculate the factorial of.
   * @return n factorial
   * @throws IllegalArgumentException if factorial isn't defined for a given input.
   */
  public static long factorial(int n) {
    if (n < 0) throw new IllegalArgumentException("n! is only defined for n >= 0.");
    return (n == 0) ? 1 : n * factorial(n - 1);
  }

  /**
   * Unit test. Usage: java -ea Factorial.java
   */
  public static void main(String[] args) {
    assert factorial(0) == 1;
    assert factorial(5) == 120;
    assert factorial(20) == 2432902008176640000L;
    try {
      factorial(-1);
    }
    catch (IllegalArgumentException e) {
      assert e.getMessage().equals("n! is only defined for n >= 0.");
    }
  }
}