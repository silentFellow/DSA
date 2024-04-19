import java.util.Scanner;

// another way to solve this is by sorting the array and print arr[arr.length - 2];

class ArrayUtil {
  int findSecondMin(int[] arr) {
    int min = Integer.MAX_VALUE;
    int secondMin = Integer.MAX_VALUE;

    for(int i=0; i<arr.length; i++) {
      if(min > arr[i]) {
        secondMin = min;
        min = arr[i];
      } else if(secondMin > arr[i] && arr[i] != min) secondMin = min;
    }

    return secondMin;
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
    System.out.println("Second min: " + au.findSecondMin(arr));
  }
}
