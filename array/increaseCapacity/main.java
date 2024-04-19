import java.util.Scanner;

class ArrayUtil {
  int[] resizeArray(int[] arr, int capacity) {
    if(capacity < arr.length) {
      System.out.println("Invalid capacity");
      return arr;
    }

    int[] temp = new int[capacity];

    for(int i=0; i<arr.length; i++) {
      temp[i] = arr[i];
    }

    return temp;
  }
}

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter no. of elements: ");
    int n = sc.nextInt();

    int[] arr = new int[n];

    for(int i=0; i<n; i++) {
      System.out.print("Enter element at position " + (i+1) + ": ");
      arr[i] = sc.nextInt();
    }

    System.out.println("Length: " + arr.length);

    System.out.print("Enter new capacity: ");
    int capacitiy = sc.nextInt();
    sc.close();

    ArrayUtil au = new ArrayUtil();
    arr = au.resizeArray(arr, capacitiy);

    System.out.println("Length: " + arr.length);
  }
}
