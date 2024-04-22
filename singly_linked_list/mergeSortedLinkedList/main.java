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

  static void display(LinkedNode initial) {
    LinkedNode temp = initial;

    while(temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
    System.out.println();
  }

  void sortInsert(int data) {
    LinkedNode temp = new LinkedNode(data);

    if(head == null || head.data >= data) {
      temp.next = head;
      head = temp;
      return;
    }

    LinkedNode current = head;
    while(current.next != null && current.next.data < data) current = current.next;

    temp.next = current.next;
    current.next = temp;
  }

  static LinkedNode merge(LinkedNode a, LinkedNode b) {
    LinkedNode temp = new LinkedNode(0);
    LinkedNode tail = temp;

    while(a != null && b != null) {
      if(a.data >= b.data) {
        LinkedNode current = new LinkedNode(b.data);
        b = b.next;
        tail.next = current;
        tail = current;
      } else {
        LinkedNode current = new LinkedNode(a.data);
        a = a.next;
        tail.next = current;
        tail = current;
      }
    }

    if(a == null) tail.next = b;
    else tail.next = a;

    return temp.next;
  }
}

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter no. of elements for 1st linked list: ");
    int n = sc.nextInt();

    LinkedList l1 = new LinkedList();
    LinkedList l2 = new LinkedList();

    for(int i=0; i<n; i++) {
      System.out.print("Enter element at position " + (i+1) + ": ");
      l1.sortInsert(sc.nextInt());
    }

    System.out.println();
    System.out.print("Enter no. of elements for 2nd linked list: ");
    n = sc.nextInt();

    for(int i=0; i<n; i++) {
      System.out.print("Enter element at position " + (i+1) + ": ");
      l2.sortInsert(sc.nextInt());
    }
    sc.close();

    LinkedNode merged = LinkedList.merge(l1.head, l2.head);
    LinkedList.display(merged);
  }
}
