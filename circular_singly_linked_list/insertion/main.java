import java.util.Scanner;

class LinkedNode {
  LinkedNode next;
  int data;

  LinkedNode(int data) {
    this.data = data;
  }
}

class LinkedList {
  LinkedNode last;

  void display() {
    if(last == null) return;
    LinkedNode temp = last.next;
    while(temp != last) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
    System.out.println(temp.data);
  }

  void insertBegin(int data) {
    LinkedNode temp = new LinkedNode(data);
    if(last == null) {
      last = temp;
      last.next = temp;
      return;
    }

    temp.next = last.next;
    last.next = temp;
  }

  void insertEnd(int data) {
    LinkedNode temp = new LinkedNode(data);
    if(last == null) {
      last = temp;
      last.next = temp;
      return;
    }

    temp.next = last.next;
    last.next = temp;
    last = temp;
  }

  void insertMiddle(int data, int pos) {
    LinkedNode temp = new LinkedNode(data);
    if(pos == 1) {
      insertBegin(data);
      return;
    }

    int counter = 1;
    if(last == null) return;
    LinkedNode curr = last.next;
    while((last != curr) && (counter != (pos - 1))) {
      curr = curr.next;
      counter++;
    }

    if(counter != (pos - 1)) return;
    if(curr == last) {
      insertEnd(data);
      return;
    }

    temp.next = curr.next;
    curr.next = temp;
  }
}

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter number of elements: ");
    int n = sc.nextInt();

    LinkedList l = new LinkedList();

    for(int i=0; i<n; i++) {
      System.out.print("Enter element at " + (i+1) + " position: ");
      // l.insertBegin(sc.nextInt());
      // l.insertEnd(sc.nextInt());

      int value = sc.nextInt();
      System.out.print("Enter position to insert: ");
      l.insertMiddle(value, sc.nextInt());
      System.out.println();
    }

    l.display();
  }
}
