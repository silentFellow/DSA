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

  void insertSorted(int data) {
    LinkedNode temp = new LinkedNode(data);

    if(head == null || head.data >= data) {
      if(head == null) head = tail = temp;
      else {
        temp.next = head;
        head.prev = temp;
        head = temp;
      }
      return;
    }

    LinkedNode prev = head;
    while(prev.next != null && (prev.next.data < data)) prev = prev.next;

    if(prev == tail) {
      temp.prev = tail;
      prev.next = temp;
      tail = temp;
      return;
    }

    prev.next.prev = temp;
    temp.next = prev.next;
    temp.prev = prev;
    prev.next = temp;
  }

  void deleteValue(int data) {
    if(head == null && tail == null) return;
    if(head.data == data) {
      head.next.prev = null;
      head = head.next;
      return;
    }

    LinkedNode temp = head;
    while(temp != null && (temp.data != data)) temp = temp.next;

    if(temp == null) return;
    if(temp == tail) {
      temp.prev.next = null;
      temp.prev = null;
      tail = tail.prev;
      return;
    }

    temp.prev.next = temp.next;
    temp.next.prev = temp.prev;
    temp.next = temp.prev = null;
  }
}

class Main {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter no. of elements: ");
    int n = sc.nextInt();

    LinkedList l = new LinkedList();

    for(int i=0; i<n; i++) {
      System.out.print("Enter value at position " + (i+1) + ": ");
      l.insertSorted(sc.nextInt());
    }

    l.display();

    System.out.print("Enter element to delete: ");
    l.deleteValue(sc.nextInt());

    l.display();
  }
}
