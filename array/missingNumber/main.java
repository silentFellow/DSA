import java.util.Scanner;

class ArrayUtil {
  int findMissingNumber(int[] arr) {
    int actualSum = ((arr.length + 1) * (arr.length + 2)) / 2;
    int sum = 0;

    for(int i=0; i<arr.length; i++) sum += arr[i];
    return actualSum - sum;
  }
}

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter no. of elements: ");
    int n = sc.nextInt();

    int[] arr = new int[n];

    for(int i=0; i<n; i++) {
      System.out.print("Enter element at position: ");
      int temp = sc.nextInt();

      if(temp > (n+1)) {
        System.out.println("Invalid Input");
        break;
      }

      arr[i] = temp;
    }

    ArrayUtil au = new ArrayUtil();
    System.out.println("Missing number: " + (au.findMissingNumber(arr)));
  }
}
