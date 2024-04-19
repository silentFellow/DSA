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

  void removeMiddle(int position) {
    if(head == null) return;
    else if(position == 1) {
      head = head.next;
    } else {
      LinkedNode temp = head;

      // for loop
      // for(int i=0; i<(position - 2); i++) {
      //   if(temp.next == null) return;
      //   temp = temp.next;
      // }

      // while loop
      int count = 1;
      while(count != (position - 1)) {
        if(temp.next == null) return;
        temp = temp.next;
        count++;
      }

      temp.next = temp.next.next;
    }
  }
}

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter position: ");
    int pos = sc.nextInt();

    // creating linked list
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

    // printing
    System.out.print("Before: ");
    l.display();

    l.removeMiddle(pos);

    System.out.print("After: ");
    l.display();
  }
}
