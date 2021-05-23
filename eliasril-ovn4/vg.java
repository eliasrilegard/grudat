import java.util.*;

class vg {
  public static int[] sort(int[] arr) {
    HashMap<Integer,Integer> map = new HashMap<>(); // 1
    for (int item : arr) { // n
      int count = 1;
      if (map.containsKey(item)) count = map.get(item) + 1;
      map.put(item, count);
    }
    ArrayList<Integer> keys = new ArrayList<>(map.keySet()); // k
    Collections.sort(keys); // k*log(k)
    
    ArrayList<Integer> out = new ArrayList<>();
    for (int key : keys) {
      for (int i = 0; i < map.get(key); i++) {
        out.add(key);
      }
    }
    return out.stream().mapToInt(i -> i).toArray();
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(sort(new int[]{7,8,4,5,8,9,7,6,3,7,2,3,0,3,4,11,5,6,3,8,1,2,6,5,9,5,6,1,3})));
  }
}