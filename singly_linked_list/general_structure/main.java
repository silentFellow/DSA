class LinkedNode {
  int data;
  LinkedNode next;
  LinkedNode(int data) {
    this.data = data;
    this.next = null;
  }
}

class LinkedList {
  LinkedNode head = null;

  void display() {
    LinkedNode temp = head;
    while(temp != null) {
      System.out.println(temp.data);
      temp = temp.next;
    }
  }
}

class Main {
  public static void main(String[] args) {
    LinkedList l = new LinkedList();

    l.head = new LinkedNode(9);

    // values
    LinkedNode first = new LinkedNode(99);
    LinkedNode second = new LinkedNode(999);

    // connecting
    l.head.next = first;
    first.next = second;
    second.next = null;

    // printing elements
    l.display();
  }
}
