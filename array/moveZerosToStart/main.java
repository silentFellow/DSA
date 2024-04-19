import java.util.Scanner;

class ArrayUtil {
  int[] moveZeros(int[] arr) {
    int startIndex = 0, endIndex = arr.length-1;
    int[] result = new int[arr.length];

    for(int i=(arr.length)-1; i>=0; i--) {
      if(arr[i] == 0) result[startIndex++] = 0;
      else result[endIndex--] = arr[i];
    }

    return result;
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
