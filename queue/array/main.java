import java.util.Scanner;

class Queue {
  int length = 0;
  int capacity;
  int front = -1;
  int rear = -1;
  int[] arr;

  Queue(int capacity) {
    arr = new int[capacity];
    this.capacity = capacity;
  }

  boolean isFull() { return length == capacity; }
  boolean isEmpty() { return length == 0; }

  void enqueue(int data) {
    if(isFull()) { return; }
    if(front == -1 && rear == -1) front = rear = 0;
    else rear++;
    arr[rear] = data;
    length++;
  }

  void dequeue() {
    if(isEmpty()) { return; }
    if(front == rear) front = rear = -1;
    else front++;
    length--;
  }

  int value() {
    if(isEmpty()) return -1;
    return arr[front];
  }

  void display() {
    while(!isEmpty()) {
      System.out.print(value() + " ");
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

    Queue q = new Queue(n);
    for(int i=0; i<n; i++) {
      System.out.print("Enter value at position " + (i+1) + ": ");
      q.enqueue(sc.nextInt());
    }
    sc.close();

    q.display();
  }
}
