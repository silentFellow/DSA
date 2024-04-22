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

  static void display(LinkedNode init) {
    LinkedNode temp = init;
    while(temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
    System.out.println();
  }

  void insertEnd(int data) {
    LinkedNode temp = new LinkedNode(data);

    if(head == null) {
      head = temp;
      return;
    }

    LinkedNode current = head;
    while(current.next != null) current = current.next;
    current.next = temp;
  }

  void reverse() {
    LinkedNode current = head, next = null, prev = null;

    while(current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }

    head = prev;
  }

  static LinkedNode sum(LinkedNode a, LinkedNode b) {
    LinkedNode dummy = new LinkedNode(0);
    LinkedNode tail = dummy;
    int carry = 0;

    while(a != null || b != null) {
      int x = (a != null) ? a.data : 0;
      int y = (b != null) ? b.data : 0;

      int sum = carry + x + y;
      carry = (sum / 10);
      tail.next = new LinkedNode((sum % 10));
      tail = tail.next;

      if(a != null) a = a.next;
      if(b != null) b = b.next;
    }

    if(carry > 0) tail.next = new LinkedNode(carry);

    return dummy.next;
  }
}

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter no. of digit for first no.: ");
    int n = sc.nextInt();

    LinkedList l1 = new LinkedList();
    LinkedList l2 = new LinkedList();

    for(int i=0; i<n; i++) {
      System.out.print("Enter digit at position " + (i+1) + ": ");
      l1.insertEnd(sc.nextInt());
    }

    System.out.println();

    System.out.print("Enter no. of digit for second no.: ");
    n = sc.nextInt();

    for(int i=0; i<n; i++) {
      System.out.print("Enter digit at position " + (i+1) + ": ");
      l2.insertEnd(sc.nextInt());
    }

    l1.reverse();
    l2.reverse();

    LinkedNode sum = LinkedList.sum(l1.head, l2.head);
    LinkedList.display(sum);
  }
}
