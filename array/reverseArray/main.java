import java.util.Scanner;

class ArrayUtil {
  int[] usingForLoop(int[] arr) {
    for(int i=0; i<(arr.length)/2; i++) { // div by 2 is required, otherwise swap twice
      int temp = arr[i];
      arr[i] = arr[arr.length - i - 1];
      arr[arr.length - i - 1] = temp;
    }

    return arr;
  }

  int[] usingWhiltLoop(int[] arr) {
    int start = 0, end = arr.length - 1;

    while(start < end) { // to ensure not swap twice
      int temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;
      start++;
      end--;
    }

    return arr;
  }
}

class Main {
  public static void main(String args[]) {
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
    int[] finalArray = au.usingForLoop(arr);
    // int[] finalArray = au.usingWhiltLoop(arr);

    for(int i=0; i<finalArray.length; i++) System.out.println(finalArray[i]);
  }
}
