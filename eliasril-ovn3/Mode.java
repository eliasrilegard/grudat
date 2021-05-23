/**
 * The Mode program implements a function to calculate the mode (most common entry) of a given integer array.
 * <p>
 * This program was made as a solution to grudat21 uppgift 3.2
 *
 * @author Elias Rilegård
 * @version 1.0
 * @since 2020-04-18
 */

import java.util.HashMap;

class Mode {
  /**
   * Calculates the mode (most common entry) of an array with integers.
   * Time complexity: O(n)
   *
   * @param values The integer array to calculate the mode of.
   * @return The lowest value which occurs the most number of times in the array.
   * @throws IllegalArgumentException if the passed array is empty.
   */
  public static int mode(int[] values) {
    if (values.length == 0) throw new IllegalArgumentException("No values in array found.");
    HashMap<Integer,Integer> index = new HashMap<>();
    int mode = 0, modeCount = 0;
    for (int val : values) {
      int count = 1;
      if (index.containsKey(val)) count = index.get(val) + 1;
      index.put(val, count);
      if (count > modeCount || (count == modeCount && val < mode)) {
        mode = val;
        modeCount = count;
      }
    }
    return mode;
  }

  /**
   * Unit test. Usage: java -ea Mode.java
   */
  public static void main(String[] args) {
    try {
      mode(new int[]{});
    }
    catch (IllegalArgumentException e) {
      assert e.getMessage().equals("No values in array found.");
    }
    assert mode(new int[]{1, 2, 3, 4, 4, 5}) == 4;
    assert mode(new int[]{1, 2, 3, 4, 4, 5, 5}) == 4;
    assert mode(new int[]{1, 5, 2, 3, 5, 2}) == 2;
    assert mode(new int[]{9, 9, 9, 9, -2, -2}) == 9;
    assert mode(new int[]{-1, -1, -5, -5, 1, 1}) == -5;
  }
}