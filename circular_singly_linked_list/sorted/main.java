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

  void insertSorted(int data) {
    LinkedNode temp = new LinkedNode(data);
    if(last == null) {
      last = temp;
      temp.next = temp;
      return;
    }
    if(last.next.data >= data) {
      temp.next = last.next;
      last.next = temp;
      return;
    }
    if(last.data < data) {
      temp.next = last.next;
      last.next = temp;
      last = temp;
      return;
    }

    LinkedNode cur = last.next;
    while(cur.next.data < data) cur = cur.next;

    temp.next = cur.next;
    cur.next = temp;
  }

  void removeSorted(int data) {
    if(last == null) return;
    if(last.data == data) {
      LinkedNode temp = last.next;
      while(temp.next != last) temp = temp.next;
      temp.next = last.next;
      last = temp;
      return;
    }
    if(last.next.data == data) {
      last.next = last.next.next;
      return;
    }

    LinkedNode temp = last.next;
    while((temp != last) && (temp.next.data != data)) temp = temp.next;
    if(temp.next.data != data) return;

    temp.next = temp.next.next;
  }
}

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter no. of elements: ");
    int n = sc.nextInt();

    LinkedList l = new LinkedList();
    for(int i=0; i<n; i++) {
      System.out.print("Enter element at position " + (i+1) + ": ");
      l.insertSorted(sc.nextInt());
    }
    sc.close();

    l.display();

    l.removeSorted(3);
    l.display();
  }
}
