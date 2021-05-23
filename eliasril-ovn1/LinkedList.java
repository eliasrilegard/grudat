/**
 * The LinkedList program implements a list type that stores
 * data using objects linked to each other through a chain.
 * <p>
 * This program was made as a solution to grudat21 uppgift 1.2, 1.3
 *
 * @author Elias Rilegård
 * @version 1.0
 * @since 2020-03-30
 */
public class LinkedList {
  private ListElement first;
  private ListElement last;
  private int size;

  /**
   * Create an empty list
   * Time complexity: O(1)
   */
  public LinkedList() {
    this.size = 0;
  }

  /**
   * Insert the given element at the beginning of this list.
   * Time complexity: O(1)
   *
   * @param data The data the element to add will hold.
   * @return Nothing.
   */
  public void addFirst(String data) {
    ListElement newElement = new ListElement(data);
    if (this.size == 0) {
      this.first = newElement;
      this.last = newElement;
    }
    else {
      newElement.setNext(this.first);
      this.first = newElement;
    }
    this.size++;
  }

  /**
   * Insert the given element at the end of this list.
   * Time complexity: O(1)
   *
   * @param data The data the element to add will hold.
   * @return Nothing.
   */
  public void addLast(String data) {
    if (this.size == 0) {
      this.addFirst(data);
      return;
    }
    this.last.setNext(new ListElement(data));
    this.last = this.last.getNext();
    this.size++;
  }

  /**
   * Return the data of the first element of this list.
   * Return null if the list is empty.
   * Time complexity: O(1)
   *
   * @return The data of the first element in the list, or null if the list is empty.
   */
  public String getFirst() {
    return this.size != 0 ? this.first.getData() : null;
  }

  /**
   * Return the data of the last element of this list.
   * Return null if the list is empty.
   * Time complexity: O(1)
   *
   * @return The data of the last element in the list, or null if the list is empty.
   */
  public String getLast() {
    return this.size != 0 ? this.last.getData() : null;
  }

  /**
   * Return the element at the specified position in this list.
   * Return null if index is out of bounds.
   * Time complexity: O(n)
   *
   * @param index The index of the element to get the data from.
   * @return The data of the element at the specified position in the list, or null if the index is out of bounds.
   */
  public String get(int index) {
    if (index < 0 || index >= this.size) return null;
    ListElement current = this.first;
    for (int i = 0; i < index; i++) {
      current = current.getNext();
    }
    return current.getData();
  }

  /**
   * Remove and returns the first element from this list.
   * Returns null if the list is empty.
   * Time complexity O(1)
   *
   * @return The data of the first element in the list, or null if the list is empty.
   */
  public String removeFirst() {
    if (this.size == 0) return null;
    String data = this.first.getData();
    this.first = this.first.getNext();
    if (--this.size == 0) this.clear();
    return data;
  }
  
  /**
   * Remove all elements from this list.
   * Time complexity: O(1)
   *
   * @return Nothing.
   */
  public void clear() {
    this.first = null;
    this.last = null;
    this.size = 0;
  }
  
  /**
   * Return the number of elements in this list.
   * Time complexity: O(1)
   *
   * @return The number of elements in the list.
   */
  public int size() {
    return this.size;
  }

  /**
   * Return a string representation of this list.
   * The elements are enclosed in square brackets ("[]").
   * Adjacent elements are separated by ", ".
   * Time complexity: O(n)
   *
   * @return A string representation of the list, enclosed in brackets ("[]"), with each element separated by ", ".
   */
  public String string() {
    String list = "[";
    if (this.size != 0) {
      ListElement current = this.first;
      while (current.getNext() != null) {
        list += current.getData() + ", ";
        current = current.getNext();
      }
      list += current.getData();
    }
    list += "]";
    return list;
  }

  private boolean healthy() {
    boolean healthy = true;
    if (this.first != null) {
      int count = 1;
      ListElement current = this.first;
      while (current.getNext() != null) {
        current = current.getNext();
        count++;
      }
      if (count != this.size) healthy = false;
    }
    else if (this.size != 0) healthy = false;

    if ((this.size == 0) && (this.first != null || this.last != null)) healthy = false;
    if ((this.size != 0) && (this.first == null || this.last == null)) healthy = false;

    if ((this.last != null) && (this.last.next != null)) healthy = false;
    return healthy;
  }

  private class ListElement {
    private String data;
    private ListElement next;

    public ListElement(String data) {
      this.data = data;
    }

    public void setNext(ListElement next) {
      this.next = next;
    }

    public String getData() {
      return this.data;
    }

    public ListElement getNext() {
      return this.next;
    }
  }

  /**
   * Unit test. Usage: java -ea LinkedList.java
   */
  public static void main(String args[]) {
    LinkedList list = new LinkedList();
    // Empty list
    assert list.healthy();
    assert list.string().equals("[]");
    assert list.getFirst() == null;
    assert list.getLast() == null;
    assert list.get(0) == null;
    assert list.removeFirst() == null;
    assert list.size() == 0;
    assert list.healthy();
    list.clear();
    assert list.healthy();

    // One element
    list.addFirst("test1");
    list.healthy();
    assert list.string().equals("[test1]");
    assert list.getFirst().equals("test1");
    assert list.getLast().equals("test1");
    assert list.get(0).equals("test1");
    assert list.get(1) == null;
    assert list.get(-1) == null;
    assert list.size() == 1;
    assert list.removeFirst().equals("test1");
    assert list.healthy();

    // Multiple elements, arbitrary adding method
    list.addLast("test2");
    list.addFirst("test1");
    list.addLast("test3");
    assert list.healthy();
    assert list.string().equals("[test1, test2, test3]");
    assert list.getFirst().equals("test1");
    assert list.getLast().equals("test3");
    assert list.get(1).equals("test2");
    assert list.size() == 3;
    assert list.healthy();
    list.clear();

    // Successive addFirst
    list.addFirst("test1");
    list.addFirst("test2");
    list.addFirst("test3");
    assert list.healthy();
    assert list.string().equals("[test3, test2, test1]");
    assert list.getFirst().equals("test3");
    assert list.getLast().equals("test1");
    list.removeFirst();
    list.removeFirst();
    list.removeFirst();
    assert list.healthy();

    // Successive addLast
    list.addLast("test1");
    list.addLast("test2");
    list.addLast("test3");
    list.addLast("test4");
    assert list.healthy();
    assert list.string().equals("[test1, test2, test3, test4]");
    assert list.getFirst().equals("test1");
    assert list.getLast().equals("test4");
    assert list.healthy();
    assert list.removeFirst().equals("test1");
    assert list.healthy();
    list.clear();
    assert list.healthy();
  }
}