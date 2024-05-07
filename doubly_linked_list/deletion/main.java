import java.util.Scanner;

class LinkedNode {
  LinkedNode next, prev;
  int data;

  LinkedNode(int data) {
    this.data = data;
  }
}

class LinkedList {
  LinkedNode head, tail;

  void display() {
    LinkedNode temp = head;
    while(temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
    System.out.println();
  }

  void displayReverse() {
    LinkedNode temp = tail;
    while(temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.prev;
    }
    System.out.println();
  }

  void deleteFirst() {
    if(head == null) return;
    if(head.next == null) {
      head = tail = null;
      return;
    }

    head.next.prev = null;
    head = head.next;
  }

  void deleteEnd() {
    if(tail == null) return;
    if(tail.prev == null) {
      head = tail = null;
      return;
    }

    tail.prev.next = null;
    tail = tail.prev;
  }

  void deletePosition(int pos) {
    if(head == null || tail == null) return;
    if(pos == 1) {
      deleteFirst();
      return;
    }

    LinkedNode temp = head;
    int count = 1;
    while(temp != null && (count != pos)) {
      temp = temp.next;
      count++;
    }
    if(count != pos) return;
    if(temp == tail) {
      deleteEnd();
      return;
    }
    temp.prev.next = temp.next;
    temp.next.prev = temp.prev;
  }

  void deleteValue(int data) {
    if(head == null || tail == null) return;
    if(head.data == data) {
      deleteFirst();
      return;
    }
    if(tail.data == data) {
      deleteEnd();
      return;
    }

    LinkedNode temp = head;
    while(temp.next != null && (temp.data != data)) {
      temp = temp.next;
    }

    if(temp.data == data) {
      temp.prev.next = temp.next;
      temp.next.prev = temp.prev;
    }
  }

}

class Main {
  public static void main(String args[]) {
    LinkedList l = new LinkedList();

    // values
    l.head = new LinkedNode(9);
    LinkedNode first = new LinkedNode(99);
    l.tail = new LinkedNode(999);

    // connecting
    l.head.next = first;
    first.next = l.tail;
    first.prev = l.head;
    l.tail.prev = first;

    // l.deleteFirst();
    // l.deleteEnd();
    // l.deletePosition(2);
    l.deleteValue(9999);

    // display
    l.display();
  }
}
