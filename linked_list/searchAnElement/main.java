import java.util.Scanner;

class LinkedNode {
  int data;
  LinkedNode next;

  LinkedNode(int data) {
    this.data = data;
    this.next = null;
  }
}

class LinkedList {
  LinkedNode head = null;

  boolean findElement(int n) {
    LinkedNode temp = head;

    while(temp != null) {
      if(temp.data == n) return true;
      temp = temp.next;
    }

    return false;
  }
}

class Main {
  public static void main(String[] args) {
    LinkedList l = new LinkedList();
    l.head = new LinkedNode(9);

    // values
    LinkedNode first = new LinkedNode(99);
    LinkedNode second = new LinkedNode(99);

    // connecting
    l.head.next = first;
    first.next = second;

    Scanner sc = new Scanner(System.in);

    System.out.print("Enter no. to search: ");
    int n = sc.nextInt();
    sc.close();

    if(l.findElement(n)) System.out.println("Present");
    else System.out.println("Not found");
  }
}
