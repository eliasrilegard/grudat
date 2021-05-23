/**
 * The CountingSort program implements an algorithm to sort a given array of
 * small integers ranging from 0 to k in O(n + k) time, where n is the length
 * of the array.
 * <p>
 * This program was made as a solution to grudat21 uppgift 4.2
 *
 * @author Elias Rilegård
 * @version 1.0
 * @since 2021-04-28
 */

import java.util.*;

class CountingSort {
  /**
   * Sorts the input array by counting the occurences of each element,
   * and then building another array with the elements in (stable) sorted order.
   * Time complexity: O(n+k), where k is the biggest value
   *
   * @param arr The input array of non-negative integers to be sorted.
   * @return The sorted array.
   * @throws IllegalArgumentException if the array contains negative numbers or if the array is empty.
   */
  public static int[] sort(int[] arr) {
    IntSummaryStatistics stat = Arrays.stream(arr).summaryStatistics(); // O(n)
    
    if (stat.getMin() < 0) throw new IllegalArgumentException("The array must not contain negative values.");
    else if (arr.length == 0) throw new IllegalArgumentException("An empty array cannot be sorted.");

    int max = stat.getMax() + 1; // This would be k

    int[] count = new int[max];
    for (int item : arr)
      count[item]++;
    for (int i = 1; i < max; i++)
      count[i] += count[i-1];
      // count[i] now is the index of the item i in output
    
    int[] output = new int[arr.length];
    for (int i = arr.length - 1; i >= 0; i--) // Iterating backwards makes algorithm stable
      output[--count[arr[i]]] = arr[i];
      // Decrease count (now index) [arr[i]] by one to set up for next occurance of that element.
    return output;
  }

  /**
   * Unit test. Usage: java -ea CountingSort.java
   */
  public static void main(String[] args) {
    try {
      sort(new int[]{-1});
    }
    catch (IllegalArgumentException e) {
      assert e.getMessage().equals("The array must not contain negative values.");
    }
    try {
      sort(new int[]{});
    }
    catch (IllegalArgumentException e) {
      assert e.getMessage().equals("An empty array cannot be sorted.");
    }
    
    assert Arrays.toString(sort(new int[]{0})).equals("[0]");
    assert Arrays.toString(sort(new int[]{0,1,2,3,4})).equals("[0, 1, 2, 3, 4]");
    assert Arrays.toString(sort(new int[]{4,3,2,1,0})).equals("[0, 1, 2, 3, 4]");
    assert Arrays.toString(sort(new int[]{1,1,1,1,0})).equals("[0, 1, 1, 1, 1]");
    assert Arrays.toString(sort(new int[]{2,3,1,2,1})).equals("[1, 1, 2, 2, 3]");
  }
}