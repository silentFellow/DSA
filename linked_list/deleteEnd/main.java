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

  void removeLast() {
    if(head == null) return;
    else {
      LinkedNode current = head;
      LinkedNode prev = null;

      while(current.next != null) {
        prev = current;
        current = current.next;
      }

      prev.next = null;
    }
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
    LinkedNode third = new LinkedNode(9999);

    // connecting
    l.head.next = first;
    first.next = second;
    second.next = third;

    // printing values
    System.out.print("Before: ");
    l.display();

    l.removeLast();
    System.out.print("After: ");
    l.display();
  }
}
