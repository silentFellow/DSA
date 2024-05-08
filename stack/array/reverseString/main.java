import java.util.Scanner;

class Stack {
  int top = -1;
  int length = 0;
  char[] arr;

  Stack(int capacity) {
    arr = new char[capacity];
  }


  boolean isEmpty() { return length == 0; }
  boolean isFull() { return length == arr.length; }

  void push(char data) {
    if(isFull()) return;
    arr[++top] = data;
    length++;
  }

  char pop() {
    if(isEmpty()) return '-';
    char value = arr[top];
    top--;
    length--;
    return value;
  }
}

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter string to reverse: ");
    String str = sc.next();
    sc.close();

    Stack st = new Stack(str.length());
    for(char c : str.toCharArray()) {
      st.push(c);
    }

    while(!st.isEmpty()) {
      System.out.print(st.pop());
    }
    System.out.println();
  }
}
