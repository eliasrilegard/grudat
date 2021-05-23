/**
 * The ScarfCached program implements the same algorithm as Scarf.java
 * to calculate the maximum profit of selling scarves, but with a much
 * better time complexity. It also gives a list of the possible scarves
 * that gives the maximum profit.
 * <p>
 * This program was made as a solution to grudat21 uppgift 6.1.5
 *
 * @author Elias Rilegård
 * @version 1.0
 * @since 2021-05-17
 */

import java.util.*;

public class ScarfCached {
  /**
   * A better implementation of the assignment's described function.
   * What differentiates this one is that this is an based on an
   * iterative process, instead of a recursive. Thus we can cache the
   * previous results and work upwards instead, saving on a lot of
   * unnecessary function calls.
   *
   * @param n The length of yarn avalible in meters.
   * @return An array where index 0 is the maximum income, and index 1 onwards is a tally of which scarves achieves that.
   * @throws IllegalArgumentException if the argument is negative.
   */
  public static int[] price(int n) {
    if (n < 0) throw new IllegalArgumentException("This function is only defined for positive numbers.");
    int[] maxPrices = new int[n+1];
    int[][] tally = new int[n+1][n+1];
    maxPrices[0] = 0;                   // p(0) = 0
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        int price = h(j) + maxPrices[i - j];
        if (price > maxPrices[i]) {
          maxPrices[i] = price;

          for (int k = 0; k < n+1; k++) {
            tally[i][k] = tally[i-j][k];
          }
          tally[i][j]++;
        }
      }
    }
    int[] returnArr = new int[n+1];
    returnArr[0] = maxPrices[n];
    for (int i = 1; i < returnArr.length; i++) {
      returnArr[i] = tally[n][i];
    }
    return returnArr;
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

    assert Arrays.toString(price(0)).equals("[0]");
    assert Arrays.toString(price(1)).equals("[2, 1]");
    assert Arrays.toString(price(5)).equals("[12, 1, 2, 0, 0, 0]");
    assert Arrays.toString(price(10)).equals("[25, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0]");
  }
}