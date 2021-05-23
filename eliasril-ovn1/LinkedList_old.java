// Elias Rilegård, grudat21 upg 1.2

public class LinkedList {
  ListElement firstElement;
  ListElement lastElement;
  int size;

  public LinkedList() {
    this.size = 0;
  }
  /*
  public void addFirst(ListElement T) {
    if (this.size == 0) {
      this.firstElement = T;
    }
    else {
      ListElement newElement = T;
      newElement.next = this.firstElement;
      this.firstElement = newElement;
    }
    this.size++;
  }*/

  public void addFirst(String T) {
    if (this.size == 0) {
      this.firstElement = new ListElement(T);
    }
    else {
      ListElement newElement = new ListElement(T);
      newElement.next = this.firstElement;
      this.firstElement = newElement;
    }
    this.size++;
  }

  public void addLast(String T) {
    ListElement current = this.firstElement;
    while (current.next != null) {
      current = current.next;
    }
    current.next = new ListElement(T);
    this.size++;
  }

  public ListElement getFirst() {
    return this.size != 0 ? this.firstElement : null; // Return first element, or null if size == 0
  }

  public ListElement getLast() {
    ListElement current = this.firstElement;
    while (current.next != null) {
      current = current.next;
    }
    return current;
  }

  public ListElement get(int index) {
    if (index < 0 || index >= this.size) return null;
    ListElement current = this.firstElement;
    for (int i = 0; i < index; i++) {
      current = current.next;
    }
    return current;
  }

  public ListElement removeFirst() { // This should be able to be done in a cleaner way
    ListElement temp = this.firstElement;
    this.firstElement = this.firstElement.next;
    return temp;
  }

  public void clear() {
    this.firstElement = null; // Manual garbage collection necessary?
    this.size = 0;
  }

  public int size() {
    return this.size;
  }

  public void string() {
    System.out.print("[");
    if (this.size != 0) {
      ListElement current = this.firstElement;
      while (current.next != null) {
        System.out.print(current.data + ", ");
        current = current.next;
      }
      System.out.print(current.data);
    }
    System.out.println("]");
  }


  private class ListElement {
    String data;
    ListElement next;
  
    public ListElement(String item) {
      this.data = item;
    }
  }


  public static void main(String args[]) {
    LinkedList list = new LinkedList();
    // TODO: Figure out a way of passing ListElements to addFirst/Last()
    list.addFirst("first");
    list.addLast("second");
    list.addFirst("third");
    list.string();
    System.out.println(list.get(0).data);
    list.clear();
    list.string();
  }
}