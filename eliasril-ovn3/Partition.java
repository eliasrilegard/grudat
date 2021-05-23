/**
 * The Partition program implements an in-place algorithm that changes the order of
 * a given array of integers to have all negative values moved to the beginning,
 * without explicitly sorting the entire array.
 * <p>
 * This program was made as a solution to grudat21 uppgift 3.3
 *
 * @author Elias Rilegård
 * @version 1.0
 * @since 2021-04-18
 */

import java.util.Arrays;

class Partition {
  /**
   * Rearranges the array to have all negative values in the beginning.
   * The algorithm is in-place.
   * Do note that this algorithm treats 0 as a positive number.
   * Time complexity: O(n)
   *
   * @param values The array for which to move all of its negative values to the front of.
   * @return The array but with the algorithm applied to.
   */
  public static int[] partition(int[] values) {
    int pivotIndex = 0;
    for (int i = 0; i < values.length; i++) {
      // Invariant: values[0..i] contains all non-negative numbers at the end.
      if (values[i] < 0) {
        int temp = values[i];
        values[i] = values[pivotIndex];
        values[pivotIndex++] = temp;
      }
    }
    return values;
  }

  /**
   * Unit test. Usage: java -ea Partition.java
   */
  public static void main(String[] args) {
    assert Arrays.equals(partition(new int[]{}), new int[]{});
    assert Arrays.equals(partition(new int[]{0}), new int[]{0});
    assert Arrays.equals(partition(new int[]{1, -1}), new int[]{-1, 1});
    assert Arrays.equals(partition(new int[]{-1, -2, 0}), new int[]{-1, -2, 0});
    assert Arrays.equals(partition(new int[]{0, -1, 5, 0, -4, -5, 3, -3}), new int[]{-1, -4, -5, -3, 0, 5, 3, 0});
  }
}