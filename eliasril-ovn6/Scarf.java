/**
 * The Scarf program implements a function (with insane time complexity)
 * to calculate the maximum profit of selling scarves.
 * <p>
 * This program was made as a solution to grudat21 uppgift 6.1.2
 *
 * @author Elias Rilegård
 * @version 1.0
 * @since 2021-05-17
 */

import java.util.*;

public class Scarf {
  /**
   * An implementation of the assignment's described function.
   *
   * @param n The length of yarn avalible in meters.
   * @return The maximum income
   * @throws IllegalArgumentException if the argument is negative.
   */
  public static int price(int n) {
    if (n == 0) return 0;
    else if (n < 0) throw new IllegalArgumentException("This function is only defined for positive numbers.");

    int[] results = new int[n];
    for (int i = 1; i <= n; i++) {
      results[i-1] = h(i) + price(n-i);
    }
    return Arrays.stream(results).summaryStatistics().getMax();
  }

  private static int h(int n) {
    int[] list = new int[]{0,2,5,6,9};
    try {
      return list[n];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      return 0;
    }
  }

  /**
   * Unit test. Usage: java -ea Scarf.java
   */
  public static void main(String[] args) {
    try {
      price(-1);
    }
    catch (IllegalArgumentException e) {
      assert e.getMessage().equals("This function is only defined for positive numbers.");
    }

    assert price(0) == 0;
    assert price(1) == 2;
    assert price(5) == 12;
    assert price(10) == 25;
  }
}