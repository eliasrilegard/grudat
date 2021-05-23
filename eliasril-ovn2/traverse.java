// Remove before hand in - stolen lol
public String show() {
  if (this.root == null) return "";

  StringBuilder sb = new StringBuilder();
  sb.append(this.root.getData() + ":" + (float)this.root.getPriority());

  String pointerRight = "└─r─";
  String pointerLeft = (this.root.getRight() != null) ? "├─l─" : "└─l─";

  traverseNodes(sb, "", pointerLeft, this.root.getLeft(), this.root.getRight() != null);
  traverseNodes(sb, "", pointerRight, this.root.getRight(), false);

  return sb.toString();
}

private static void traverseNodes(StringBuilder sb, String padding, String pointer, Node node, boolean hasRightSibling) {
  if (node != null) {
      sb.append("\n");
      sb.append(padding);
      sb.append(pointer);
      sb.append(node.getData() + ":" + (float)node.getPriority());

      StringBuilder paddingBuilder = new StringBuilder(padding);
      if (hasRightSibling) {
          paddingBuilder.append("│   ");
      } else {
          paddingBuilder.append("    ");
      }

      String paddingForBoth = paddingBuilder.toString();
      String pointerRight = "└─r─";
      String pointerLeft = (node.getRight() != null) ? "├─l─" : "└─l─";

      traverseNodes(sb, paddingForBoth, pointerLeft, node.getLeft(), node.getRight() != null);
      traverseNodes(sb, paddingForBoth, pointerRight, node.getRight(), false);
  }
}
// Remove before hand in - stolen lol

private String traverse(Node node) {
  return (node.getLeft() != null ? traverse(node.getLeft()) + ", " : "") + node.getData() + (node.getRight() != null ? ", " + traverse(node.getRight()) : "");
}
