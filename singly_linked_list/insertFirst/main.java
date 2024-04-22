import java.util.Scanner;

class LinkedNode {
  int data;
  LinkedNode next = null;

  LinkedNode(int data) {
    this.data = data;
  }
}

class LinkedList {
  LinkedNode head = null;

  void display() {
    LinkedNode temp = head;
    while(temp != null) {
      System.out.println(temp.data);
      temp = temp.next;
    }
  }

  void insertAtBegin(int data) {
    // creation of new node
    LinkedNode temp = new LinkedNode(data);

    // connection
    if(head == null) head = temp;
    else {
      temp.next = head;
      head = temp;
    }
  }
}

class Main {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter no. of elements: ");
    int n = sc.nextInt();

    // creation of linked list
    LinkedList l = new LinkedList();

    // add elements to the list
    for(int i=0; i<n; i++) {
      System.out.print("Enter element at position " + (i+1) + ": ");
      l.insertAtBegin(sc.nextInt());
    }

    // printing
    l.display();
  }
}
