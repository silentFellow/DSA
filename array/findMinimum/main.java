import java.util.Scanner;

class ArrayUtil {
  int usingForLoop(int[] arr) {
    int min = arr[0];

    for(int i=0; i<arr.length; i++) {
      if(arr[i] < min) min = arr[i];
    }

    return min;
  }

  int usingWhileLoop(int[] arr) {
    int min = arr[0], i=0;

    while(i < (arr.length)) {
      if(min > arr[i]) min = arr[i];
      i++;
    }

    return min;
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
    sc.close();

    ArrayUtil au = new ArrayUtil();
    // int minimum = au.usingForLoop(arr);
    int minimum = au.usingWhileLoop(arr);

    System.out.println("Minimum: " + minimum);
  }
}
