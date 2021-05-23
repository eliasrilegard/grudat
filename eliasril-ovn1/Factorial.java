/**
* The Factorial program implements a function to calculate n factorial.
* <p>
* This program was made as a solution to grudat21 uppgift 1.1
*
* @author Elias Rilegård
* @version 1.0
* @since 2020-03-30
*/
public class Factorial {
  /**
   * Recursively calculates n factorial.
   *
   * @param n The value to calculate the factorial of.
   * @return n factorial
   * @throws IllegalArgumentException if factorial isn't defined for a given input.
   */
  public static long factorial(int n) {
    if (n < 0) throw new IllegalArgumentException("n >= 0");
    long result = 1;
    for (int i = 2; i <= n; i++) {
      result *= (long) i;
    }
    return result;
  }
  
  /**
   * Unit test. Usage: java -ea Factorial.java
   */
  public static void main(String args[]) {
    assert factorial(1) == 1;
    assert factorial(0) == 1;
    assert factorial(2) == 2;
    assert factorial(5) == 120;
    try {
      long test = factorial(-1);
    }
    catch (IllegalArgumentException e) {
      assert e.getMessage().equals("n >= 0");
    }
  }
}