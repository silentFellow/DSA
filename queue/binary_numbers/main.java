import java.util.Scanner;

class LinkedNode {
  String data;
  LinkedNode next;

  LinkedNode(String data) {
    this.data = data;
  }
}

class Queue {
  LinkedNode front, rear;

  void enqueue(String data) {
    LinkedNode temp = new LinkedNode(data);
    if(front == null && rear == null) {
      front = rear = temp;
      return;
    }

    rear.next = temp;
    rear = temp;
  }

  void dequeue() {
    if(front == null && rear == null) return;
    front = front.next;
    if(front == null) rear = null;
  }

  String value() {
    if(front == null && rear == null) return "";
    return front.data;
  }

  boolean isEmpty() { return front == null && rear == null; }
}

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter a number: ");
    int n = sc.nextInt();
    sc.close();

    Queue q = new Queue();
    if(n > 0) q.enqueue("1");
    for(int i=0; i<n; i++) {
      String val = q.value();
      System.out.print(val + " ");
      q.dequeue();
      q.enqueue(val + "0");
      q.enqueue(val + "1");
    }

    System.out.println(q.isEmpty());
  }
}
