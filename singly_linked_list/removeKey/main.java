import java.util.Scanner;

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

  void prepend(int data) {
    LinkedNode temp = new LinkedNode(data);
    if(head == null) {
      head = temp;
      return;
    }

    temp.next = head;
    head = temp;
  }

  void findAndRemove(int data) {
    if(head == null) return;

    if(head.data == data) {
      head = head.next;
      return;
    }

    LinkedNode current = head;
    LinkedNode prev = null;

    while(current != null && current.data != data) {
      prev = current;
      current = current.next;
    }

    if(prev.next != null && current.next != null) prev.next = current.next;
  }
}

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    LinkedList l = new LinkedList();

    System.out.print("Enter no. of elements: ");
    int n = sc.nextInt();

    for(int i=0; i<n; i++) {
      System.out.print("Enter element at position " + (i+1) + ": ");
      l.prepend(sc.nextInt());
    }

    l.display();

    System.out.print("Enter data to be removed: ");
    l.findAndRemove(sc.nextInt());
    sc.close();

    l.display();
  }
}
