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

  int revEle(int pos) {
    LinkedNode main = head;
    LinkedNode ref = head;

    int count = 0;
    while(count < pos) {
      ref = ref.next;
      count++;
    }

    while(ref != null) {
      ref = ref.next;
      main = main.next;
    }

    return main.data;
  }
}

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter n: ");
    int n = sc.nextInt();

    // creation of linked list
    LinkedList l = new LinkedList();

    // values
    l.head = new LinkedNode(9);
    LinkedNode first = new LinkedNode(99);
    LinkedNode second = new LinkedNode(999);
    LinkedNode third = new LinkedNode(9999);
    LinkedNode fourth = new LinkedNode(99999);

    // connecting
    l.head.next = first;
    first.next = second;
    second.next = third;
    third.next = fourth;

    // printing
    System.out.println("Value at nth postion in reverse: " + l.revEle(n));
  }
}
