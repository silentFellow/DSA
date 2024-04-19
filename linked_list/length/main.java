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

  int findLength() {
    int count = 0;
    LinkedNode temp = head;

    while(temp != null) {
      count++;
      temp = temp.next;
    }

    return count;
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

    // finding length
    System.out.println("Length: " + l.findLength());
  }
}
