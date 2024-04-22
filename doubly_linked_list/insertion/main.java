import java.util.Scanner;

class LinkedNode {
  int data;
  LinkedNode next, prev;

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

  void insertStart(int data) {
    LinkedNode temp = new LinkedNode(data);

    if(head == null && tail == null) {
      head = tail = temp;
      return;
    }

    head.prev = temp;
    temp.next = head;
    head = temp;
  }

  void insertEnd(int data) {
    LinkedNode temp = new LinkedNode(data);

    if(head == null && tail == null) {
      head = tail = temp;
      return;
    }

    tail.next = temp;
    temp.prev = tail;
    tail = temp;
  }

  void insertMiddle(int data, int pos) {
    LinkedNode temp = new LinkedNode(data);

    if(head == null && tail == null) {
      head = tail = temp;
      return;
    }

    if(pos == 1) {
      temp.next = head;
      head.prev = temp;
      head = temp;
      return;
    }

    LinkedNode prev = head;
    for(int i=0; i<(pos - 2) && (prev.next != null); i++) {
      prev = prev.next;
    }

    if(prev != null) {
      temp.next = prev.next;
      if(prev.next != null) {
        prev.next.prev = temp;
      } else {
        tail = temp;
      }
      temp.prev = prev;
      prev.next = temp;
    } else {
      System.out.println("Invalid Position");
    }
  }

}

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter no. of elements: ");
    int n = sc.nextInt();

    LinkedList l = new LinkedList();
    for(int i=0; i<n; i++) {
      System.out.print("Enter element at position " + (i+1) + ": ");
      // l.insertStart(sc.nextInt());
      // l.insertEnd(sc.nextInt());

      int val = sc.nextInt();
      System.out.print("Enter position to insert: ");
      int pos = sc.nextInt();
      System.out.println();
      l.insertMiddle(val, pos);
    }
    sc.close();

    System.out.println("Linked List: ");
    l.display();

    System.out.println("Linked List in reverse: ");
    l.displayReverse();
  }
}
