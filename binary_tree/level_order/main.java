class LinkedNode {
  TreeNode data;
  LinkedNode next;

  LinkedNode(TreeNode data) {
    this.data = data;
  }
}

class Queue {
  LinkedNode front, rear;

  boolean isEmpty() { return front == null; }

  void enqueue(TreeNode data) {
    LinkedNode temp = new LinkedNode(data);
    if(front == null) {
      front = rear = temp;
      return;
    }

    rear.next = temp;
    rear = temp;
  }

  void dequeue() {
    if(isEmpty()) return;
    front = front.next;
    if(front == null) rear = null;
  }

  TreeNode poll() {
    if(isEmpty()) return new TreeNode(-1);
    return front.data;
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

  void levelOrder() {
    if(root == null) return;

    Queue q = new Queue();
    q.enqueue(root);
    while(!q.isEmpty()) {
      TreeNode value = q.poll();
      q.dequeue();

      System.out.print(value.data + " ");
      if(value.left != null) q.enqueue(value.left);
      if(value.right != null) q.enqueue(value.right);
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

    // level order
    t.levelOrder();
  }
}
