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

  void deleteFirst() {
    if(last == null) return;
    if(last == last.next) {
      last = null;
      return;
    }

    LinkedNode curFirst = last.next;
    last.next = curFirst.next;
    curFirst.next = null;
  }

  void deleteLast() {
    if(last == null) return;
    if(last == last.next) {
      last = null;
      return;
    }

    LinkedNode temp = last.next;
    while(temp.next != last) temp = temp.next;

    temp.next = last.next;
    last.next = null;
    last = temp;
  }

  void deletePos(int pos) {
    if(last == null) return;
    if(pos == 1) {
      deleteFirst();
      return;
    }

    if(last.next == last) return;

    int counter = 1;
    LinkedNode temp = last.next;
    while(temp.next != last && (counter < (pos - 1))) {
      temp = temp.next;
      counter++;
    }

    if(counter != (pos - 1)) return;
    if(temp.next == last) {
      deleteLast();
      return;
    }

    LinkedNode deletable = temp.next;
    temp.next = deletable.next;
    deletable.next = null;
  }

  void deleteValue(int data) {
    if(last == null) return;
    if(last.next.data == data) {
      deleteFirst();
      return;
    }
    if(last.data == data) {
      deleteLast();
      return;
    }

    LinkedNode temp = last.next;
    while(temp.next != last && temp.next.data != data) temp = temp.next;

    if(temp.next.data != data) return;
    temp.next = temp.next.next;
  }
}

class Main {
  public static void main(String[] args) {
    LinkedList l = new LinkedList();

    // creating list
    LinkedNode first = new LinkedNode(9);
    LinkedNode second = new LinkedNode(99);
    l.last = new LinkedNode(999);

    // connecting
    first.next = second;
    second.next = l.last;
    l.last.next = first;

    // printing
    System.out.print("List Before : ");
    l.display();

    System.out.println();

    System.out.print("List After: ");
    // l.deleteFirst();
    // l.deleteLast();
    // l.deletePos(2);
    l.deleteValue(9999);
    l.display();
  }
}
