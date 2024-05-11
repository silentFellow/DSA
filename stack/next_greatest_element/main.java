import java.util.Scanner;

class Stack {
  int capacity;
  int length = 0;
  int top = -1;
  int[] arr;

  Stack(int capacity) {
    arr = new int[capacity];
    this.capacity = capacity;
  }

  boolean isEmpty() { return top == -1; }
  boolean isFull() { return length == capacity; }

  void push(int n) {
    if(isFull()) return;
    arr[++top] = n;
    length++;
  }

  int peek() {
    if(isEmpty()) return -1;
    return arr[top];
  }

  void pop() {
    if(isEmpty()) return;
    top--;
    length--;
  }
}

class Main {

  static int[] findNextGreaterElement(int[] arr) {
    int[] res = new int[arr.length];
    Stack st = new Stack(arr.length);

    for(int i=(arr.length - 1); i>=0; i--) {
      while(!st.isEmpty() && st.peek() <= arr[i]) st.pop();

      if(st.isEmpty()) res[i] = -1;
      else res[i] = st.peek();

      st.push(arr[i]);
    }

    return res;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter no. of elements: ");
    int n = sc.nextInt();

    int[] arr = new int[n];
    for(int i=0; i<n; i++) {
      System.out.print("Enter element at position " + (i+1) + ": ");
      arr[i] = sc.nextInt();
    }
    sc.close();

    System.out.println("Before: ");
    for(int i=0; i<n; i++) System.out.print(arr[i] + " ");

    System.out.println();
    System.out.println();

    int[] result = findNextGreaterElement(arr);
    System.out.println("After: ");
    for(int i=0; i<n; i++) System.out.print(result[i] + " ");

    System.out.println();
  }
}
