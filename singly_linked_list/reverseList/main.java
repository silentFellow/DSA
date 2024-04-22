class LinkedNode {
  int data;
  LinkedNode next;

  LinkedNode(int data) {
    this.data = data;
  }
}

class LinkedList {
  LinkedNode head;

  void display() {
    LinkedNode temp = head;
    while(temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
    System.out.println();
  }

  void reverse() {
    LinkedNode current = head;
    LinkedNode prev = null;
    LinkedNode next = null;

    while(current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }

    head = prev; // this is must, so that the head makes points the first of the reversed list
  }
}

class Main {
  public static void main(String[] args) {
    // creation of linked list
    LinkedList l = new LinkedList();

    // values
    l.head = new LinkedNode(9);
    LinkedNode first = new LinkedNode(99);
    LinkedNode second = new LinkedNode(999);

    // connecting
    l.head.next = first;
    first.next = second;

    // printing
    System.out.print("Before: ");
    l.display();

    l.reverse();

    System.out.print("After: ");
    l.display();
  }
}
