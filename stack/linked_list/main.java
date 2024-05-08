class LinkedNode {
  int data;
  LinkedNode next;

  LinkedNode(int data) {
    this.data = data;
  }
}

class Stack {
  LinkedNode top;
  int length = 0;

  void push(int data) {
    LinkedNode temp = new LinkedNode(data);
    length++;
    if(top == null) {
      top = temp;
      return;
    }

    temp.next = top;
    top = temp;
  }

  int pop() {
    int value = -1;
    if(top == null) return value;

    value = top.data;
    length--;
    if(top.next == null) {
      top = null;
      return value;
    }
    top = top.next;
    return value;
  }
}

class Main {
  public static void main(String[] args) {
    Stack st = new Stack();

    st.push(9);
    st.push(99);
    st.push(999);
    System.out.println(st.pop());
    System.out.println(st.pop());
    System.out.println(st.pop());
  }
}
