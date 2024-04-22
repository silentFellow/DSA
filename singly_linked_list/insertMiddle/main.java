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

  void insertMiddle(int data, int position) {
    LinkedNode temp = new LinkedNode(data);

    if(head == null) head = temp;
    else {
      LinkedNode prev = head;

      // for loop
      // for(int i=1; i<(position - 1); i++) {
      // if(prev.next == null) break;
      //   prev = prev.next;
      // }

      // while loop
      int count = 1;
      while(count != (position - 1) && prev.next != null) {
        prev = prev.next;
        count++;
      }

      temp.next = prev.next;
      prev.next = temp;
    }
  }
}

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // creation of linked list
    LinkedList l = new LinkedList();

    // values
    l.head = new LinkedNode(9);
    LinkedNode first = new LinkedNode(99);
    LinkedNode second = new LinkedNode(999);
    LinkedNode third = new LinkedNode(9999);

    // connecting nodes
    l.head.next = first;
    first.next = second;
    second.next = third;

    System.out.print("Enter element to be added: ");
    int element = sc.nextInt();

    System.out.print("Enter position: ");
    int position = sc.nextInt();
    sc.close();

    System.out.print("Before: ");
    l.display();

    l.insertMiddle(element, position);
    System.out.print("After: ");
    l.display();
  }
}
