import java.util.Scanner;

class ArrayUtil {
  int[] moveZeros(int[] arr) {
    int j = 0;

    for(int i=0; i<arr.length; i++) {
      if(arr[i] != 0 && arr[j] == 0) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
      if(arr[j] != 0) j++;
    }

    return arr;
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
    int[] finalArray = au.moveZeros(arr);

    for(int i=0; i<finalArray.length; i++) System.out.println(finalArray[i]);
  }
}
