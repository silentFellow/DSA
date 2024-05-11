class TreeNode {
  int data;
  TreeNode left, right;

  TreeNode(int data) {
    this.data = data;
  }
}

class Tree {
  TreeNode root;
}

class Main {
  public static void main(String[] args) {
    Tree t = new Tree();

    // creating values
    t.root = new TreeNode(9);
    TreeNode first = new TreeNode(99);
    TreeNode second = new TreeNode(999);
    TreeNode third = new TreeNode(9999);
    TreeNode fourth = new TreeNode(99999);
    TreeNode fifth = new TreeNode(999999);
    TreeNode sixth = new TreeNode(9999999);

    // connecting values
    t.root.left = first;
    t.root.right = second;
    first.left = third;
    first.right = fourth;
    second.left = fifth;
    second.right = sixth;
  }
}
