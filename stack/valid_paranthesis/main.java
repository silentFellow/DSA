import java.util.Scanner;

class LinkedNode {
  LinkedNode next;
  char data;

  LinkedNode(char data) {
    this.data = data;
  }
}

class Stack {
  LinkedNode top;

  boolean isEmpty() { return top == null; }

  char peek() {
    if(isEmpty()) return '-';
    return top.data;
  }

  void push(char data) {
    LinkedNode temp = new LinkedNode(data);
    if(isEmpty()) {
      top = temp;
      return;
    }

    temp.next = top;
    top = temp;
  }

  void pop() {
    if(isEmpty()) return;
    if(top.next == null) {
      top = null;
      return;
    }

    top = top.next;
  }
}

class Main {
  static boolean checkValidString(String val) {
    Stack st = new Stack();
    for(char c : val.toCharArray()) {
      if(c == '{' || c == '[' || c == '<' || c == '(') st.push(c);
      else {
        if(
          (c == '}' && st.peek() == '{') ||
          (c == ']' && st.peek() == '[') ||
          (c == '>' && st.peek() == '<') ||
          (c == ')' && st.peek() == '(')
        ) st.pop();
        else return false;
      }
    }

    return st.isEmpty();
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter the string: ");
    String val = sc.next();
    sc.close();

    if(checkValidString(val)) System.out.println("Valid");
    else System.out.println("Invalid");
  }
}
