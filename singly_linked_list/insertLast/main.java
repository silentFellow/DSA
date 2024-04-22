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
      System.out.println(temp.data);
      temp = temp.next;
    }
  }

  void insertEnd(int data) {
    LinkedNode temp = new LinkedNode(data);

    if(head == null) head = temp;
    else {
      LinkedNode current = head;
      while(current.next != null) current = current.next;
      current.next = temp;
    }
  }
}

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter no. of elements: ");
    int n = sc.nextInt();

    // creation of linked list
    LinkedList l = new LinkedList();

    // inserting elements
    for(int i=0; i<n; i++) {
      System.out.print("Enter element at position " + (i+1) + ": ");
      l.insertEnd(sc.nextInt());
    }
    sc.close();

    // display elements
    l.display();
  }
}
