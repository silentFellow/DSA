import java.util.Scanner;

class LinkedNode {
  int data;
  LinkedNode next;

  LinkedNode(int data) {
    this.data = data;
  }
}

class Queue {
  LinkedNode front, rear;

  void enqueue(int data) {
    LinkedNode temp = new LinkedNode(data);
    if(front == null && rear == null) {
      front = rear = temp;
      return;
    }

    rear.next = temp;
    rear = temp;
  }

  void dequeue() {
    if(front == null) return;
    front = front.next;
    if(front == null) {
      rear = null;
    }
  }

  void display() {
    while(front != null && rear != null) {
      System.out.print(front.data + " ");
      dequeue();
    }
    System.out.println();
  }
}

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter no. of elements: ");
    int n = sc.nextInt();

    Queue q = new Queue();
    for(int i=0; i<n; i++) {
      System.out.print("Enter the element at position " + (i+1) + ": ");
      q.enqueue(sc.nextInt());
    }

    q.display();
  }
}
