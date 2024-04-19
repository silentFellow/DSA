import java.util.Scanner;

class ArrayUtils {
  int[] removeOddElements(int[] arr) {
    int n = arr.length;
    int evenCount = 0, newArrayCount = 0;

    for(int i=0; i<n; i++) {
      if(arr[i] % 2 == 0) evenCount++;
    }

    int[] finalArray = new int[evenCount];

    for(int i=0; i<n; i++) {
      if(arr[i] % 2 == 0) {
        finalArray[newArrayCount] = arr[i];
        newArrayCount++;
      }
    }

    return finalArray;
  }
}

class Main {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter no. of elements: ");
    int n = sc.nextInt();

    int[] arr = new int[n];

    for(int i=0; i<n; i++) {
      System.out.print("Enter value at position " + (i+1) + ": " );
      arr[i] = sc.nextInt();
    }
    sc.close();

    ArrayUtils au = new ArrayUtils();
    int[] finalArray = au.removeOddElements(arr);

    for(int i=0; i<finalArray.length; i++) System.out.println(finalArray[i]);
  }
}
