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

  boolean isEmpty() { return head == null; }

  static void display(LinkedNode head) {
    LinkedNode temp = head;
    while(temp != null) {
      System.out.print(temp.data + "");
      temp = temp.next;
    }
    System.out.println();
  }

  void insertEnd(int data) {
    LinkedNode temp = new LinkedNode(data);
    if(isEmpty()) {
      head = temp;
      return;
    }

    LinkedNode prev = head;
    while(prev.next != null) prev = prev.next;
    prev.next = temp;
  }

  static LinkedNode reverse(LinkedNode head) {
    LinkedNode current = head;
    LinkedNode next = null;
    LinkedNode prev = null;

    while(current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }

    return prev;
  }

  LinkedNode multiply(int n) {
    if(n == 0) return new LinkedNode(0);

    LinkedNode temp = head;;
    LinkedNode dummy = new LinkedNode(0);
    LinkedNode tail = dummy;
    int carry = 0;

    while(temp != null) {
      int mul = (temp.data * n) + carry;
      int data = mul % 10;
      carry = mul / 10;

      tail.next = new LinkedNode(data);
      tail = tail.next;
      temp = temp.next;
    }

    if(carry != 0) tail.next = new LinkedNode(carry);

    return dummy.next;
  }
}

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter multiplicant: ");
    String val = sc.next();

    System.out.print("Enter multiplier: ");
    int n = sc.nextInt();
    sc.close();

    LinkedList l = new LinkedList();
    for(char c : val.toCharArray()) {
      int numericVal = Character.getNumericValue(c);
      l.insertEnd(numericVal);
    }

    l.head = LinkedList.reverse(l.head);
    LinkedNode result = LinkedList.reverse(l.multiply(n));
    LinkedList.display(result);
  }
}
