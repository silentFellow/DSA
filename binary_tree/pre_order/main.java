class LinkedNode {
  TreeNode data;
  LinkedNode next;

  LinkedNode(TreeNode data) {
    this.data = data;
  }
}

class Stack {
  LinkedNode top;

  boolean isEmpty() { return top == null; };

  void push(TreeNode data) {
    LinkedNode temp = new LinkedNode(data);
    if(top == null) {
      top = temp;
      return;
    }

    temp.next = top;
    top = temp;
  }

  void pop() {
    if(top == null) return;
    top = top.next;
  }

  TreeNode peek() {
    if(top == null) return new TreeNode(-1);
    return top.data;
  }
}

class TreeNode {
  int data;
  TreeNode left, right;

  TreeNode(int data) {
    this.data = data;
  }
}

class Tree {
  TreeNode root;

  void recursion(TreeNode root) {
    if(root == null) return;
    System.out.print(root.data + " ");
    recursion(root.left);
    recursion(root.right);
  }

  void iteration() {
    if(root == null) return;

    Stack st = new Stack();
    st.push(root);
    while(!st.isEmpty()) {
      TreeNode temp = st.peek();
      st.pop();

      System.out.print(temp.data + " ");
      if(temp.right != null) st.push(temp.right);
      if(temp.left != null) st.push(temp.left);
    }
    System.out.println();
  }
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

    // preorder
    // t.recursion(t.root);
    t.iteration();
    System.out.println();
  }
}
