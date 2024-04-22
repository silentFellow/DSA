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

  boolean detectLoop() {
    LinkedNode slowPtr = head, fastPtr = head;

    while(fastPtr != null && fastPtr.next != null) {
      slowPtr = slowPtr.next;
      fastPtr = fastPtr.next.next;
      if(slowPtr == fastPtr) return true;
    }

    return false;
  }

  int getLoopStart() {
    LinkedNode slowPtr = head, fastPtr = head, temp = head;
    while(fastPtr != null && fastPtr.next != null) {
      fastPtr = fastPtr.next.next;
      slowPtr = slowPtr.next;
      if(slowPtr == fastPtr) {
        while(temp != slowPtr) {
          temp = temp.next;
          slowPtr = slowPtr.next;
        }

        break;
      }
    }

    return temp.data;
  }

  void removeLoop() {
    LinkedNode slowPtr = head, fastPtr = head, temp = head;

    while(fastPtr != null && fastPtr.next != null) {
      slowPtr = slowPtr.next;
      fastPtr = fastPtr.next.next;

      if(slowPtr == fastPtr) {
        while(temp.next != slowPtr.next) {
          temp = temp.next;
          slowPtr = slowPtr.next;
        }

        slowPtr.next = null;
        return;
      }
    }
  }

}

class Main {
  public static void main(String[] args) {
    LinkedList l = new LinkedList();

    l.head = new LinkedNode(9);
    LinkedNode first = new LinkedNode(99);
    LinkedNode second = new LinkedNode(999);
    LinkedNode third = new LinkedNode(9999);
    LinkedNode fourth = new LinkedNode(99999);

    l.head.next = first;
    first.next = second;
    second.next = third;
    third.next = fourth;
    fourth.next = second;

    if(l.detectLoop()) {
      System.out.println("loop detected");
      System.out.println("loop at: " + (l.getLoopStart()));

      l.removeLoop();

      if(l.detectLoop()) System.out.println("loop detected");
      else System.out.println("no loop");
    }
    else System.out.println("no loop");
  }
}
