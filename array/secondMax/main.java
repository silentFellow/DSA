import java.util.Scanner;

// another way to solve this is by sorting the array and print arr[arr.length - 2];

class ArrayUtil {
  int findSecondMax(int[] arr) {
    int max = Integer.MIN_VALUE;
    int secondMax = Integer.MIN_VALUE;

    for(int i=0; i<arr.length; i++) {
      if(max < arr[i]) {
        secondMax = max;
        max = arr[i];
      } else if(secondMax < arr[i] && arr[i] != max) secondMax = arr[i];
    }

    return secondMax;
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
    System.out.println("Second max: " + au.findSecondMax(arr));
  }
}
