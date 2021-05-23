/**
 * The Treap program implements a data structure that stores (unique)
 * strings using objects linked to each other through a randomized
 * binary tree.
 * <p>
 * This program was made as a solution to grudat21 uppgift 2.5
 *
 * @author Elias Rilegård
 * @version 1.0
 * @since 2021-04-12
 */
public class Treap {
  private Node root;
  private int size;

  /**
   * Creates a new empty tree.
   * Time complexity: O(1)
   */
  public Treap() {
    this.size = 0;
  }

  /**
   * Inserts a given (unique) string into the tree, and performs rotations if necessary to keep the tree balanced.
   * Time complexity of complete insertion: O(n)
   *
   * @param data The string to be inserted into the tree. This cannot exactly match any other string that is already stored.
   * @return Nothing.
   * @throws IllegalStateException If a string that already exists in the tree is added.  
   */
  public void insert(String data) {
    try {
      this.root = insert(data, this.root);
    }
    catch (IllegalStateException e) {
      throw e;
    }
    this.size++;
  }

  /**
   * Returns the size of the tree, ie the number of stored elements (strings).
   * Time complexity: O(1)
   *
   * @return The number of elements in the tree.
   */
  public int size() {
    return this.size;
  }

  /**
   * Generates a string representation of the tree.
   * The string is enclosed with "[]".
   * The string also has all elements sorted alphabetically, which ares separated by ", ".
   * Elements starting with an uppercase letter is sorted before the lowercase corresponding letter.
   * Time complexity: O(n), since StringBuilder.append() is amortized O(1)
   *
   * @return A string with all elements in sorted order.
   */
  public String stringSorted() {
    StringBuilder out = new StringBuilder("[");
    if (this.root != null) out.append(traverse(this.root));
    out.append("]");
    return out.toString();
  }

  private Node insert(String data, Node node) {
    if (node == null) return new Node(data);
    // NOTE: If toLowerCase() isn't used, strings starting with capital letters
    // will always be sorted before strings starting with lowercase letters.
    int compare = node.getData().toLowerCase().compareTo(data.toLowerCase());
    if (compare == 0) compare = node.getData().compareTo(data); // If lowercase matches, replace comparison to include uppercase
    if (compare > 0) {
      node.setLeft(insert(data, node.getLeft()));
      if (node.getLeft().getPriority() < node.getPriority())
        node = rotateLeft(node);
    }
    else if (compare < 0) {
      node.setRight(insert(data, node.getRight()));
      if (node.getRight().getPriority() < node.getPriority())
        node = rotateRight(node);
    }
    else if (compare == 0) throw new IllegalStateException("String already exists in tree.");
    return node;
  }

  private StringBuilder traverse(Node node) {
    StringBuilder sb = new StringBuilder();
    if (node.getLeft() != null) {
      sb.append(traverse(node.getLeft()));
      sb.append(", ");
    }
    sb.append(node.getData());
    if (node.getRight() != null) {
      sb.append(", ");
      sb.append(traverse(node.getRight()));
    }
    return sb;
  }

  private Node rotateLeft(Node node) {
    Node left = node.getLeft();
    node.setLeft(left.getRight());
    left.setRight(node);
    return left;
  }

  private Node rotateRight(Node node) {
    Node right = node.getRight();
    node.setRight(right.getLeft());
    right.setLeft(node);
    return right;
  }

  private class Node {
    private String data;
    private double priority;
    private Node left;
    private Node right;

    public Node(String data) {
      this.data = data;
      this.priority = Math.random();
    }

    public String getData() {
      return this.data;
    }

    public double getPriority() {
      return this.priority;
    }

    public Node getLeft() {
      return this.left;
    }
    
    public Node getRight() {
      return this.right;
    }

    public void setLeft(Node node) {
      this.left = node;
    }

    public void setRight(Node node) {
      this.right = node;
    }
  }

  /**
   * Unit test. Usage: java -ea Treap.java
   */
  public static void main(String[] args) {
    // Empty tree
    Treap tree = new Treap();
    assert tree.size() == 0;
    assert tree.stringSorted().equals("[]");

    // One element
    tree.insert("Test");
    assert tree.size() == 1;
    assert tree.stringSorted().equals("[Test]");

    // More elements
    tree.insert("test");
    tree.insert("another element");
    tree.insert("Even more!");
    tree.insert("oNE mOrE FoR GOoD meASurE");
    assert tree.size() == 5;
    assert tree.stringSorted().equals("[another element, Even more!, oNE mOrE FoR GOoD meASurE, Test, test]");

    // Can't insert duplicates
    tree.insert("duplicate");
    try {
      tree.insert("duplicate");
    }
    catch (IllegalStateException e) {
      assert e.getMessage().equals("String already exists in tree.");
    }
    assert tree.size() == 6;
  }
}