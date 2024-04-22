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

  void insertSort(int data) {
    LinkedNode temp = new LinkedNode(data);
    if(head == null || head.data > data) {
      temp.next = head;
      head = temp;
      return;
    }

    LinkedNode current = head;
    while(current.next != null && current.next.data < data) current = current.next;

    temp.next = current.next;
    current.next = temp;
  }
}

class Main {
  public static void main(String[] args) {
    LinkedList l = new LinkedList();
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter no. of elements: ");
    int n = sc.nextInt();

    for(int i=0; i<n; i++) {
      System.out.print("Enter element at position " + (i+1) + ": ");
      l.insertSort(sc.nextInt());
    }
    sc.close();

    l.display();
  }
}
