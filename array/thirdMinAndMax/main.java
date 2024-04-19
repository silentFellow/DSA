import java.util.Scanner;

class ArrayUtil {
  int findThirdMin(int[] arr) {
    if(arr.length < 3) {
      System.out.println("More number of elements required.");
      return 0;
    }

    int min = Integer.MAX_VALUE;
    int secondMin = Integer.MAX_VALUE;
    int thirdMin = Integer.MAX_VALUE;

    for(int i=0; i<arr.length; i++) {
      if(min > arr[i]) {
        thirdMin = secondMin;
        secondMin = min;
        min = arr[i];
      } else if(secondMin > arr[i] && arr[i] != min) {
        thirdMin = secondMin;
        secondMin = arr[i];
      } else if(thirdMin > arr[i] && arr[i] != secondMin && arr[i] != min) thirdMin = arr[i];
    }

    return thirdMin;
  }

  int findThirdMax(int[] arr) {
    if(arr.length < 3) {
      System.out.println("More number of elements required.");
      return 0;
    }

    int max = Integer.MIN_VALUE;
    int secondMax = Integer.MIN_VALUE;
    int thirdMax = Integer.MIN_VALUE;

    for(int i=0; i<arr.length; i++) {
      if(max < arr[i]) {
        thirdMax = secondMax;
        secondMax = max;
        max = arr[i];
      } else if(secondMax < arr[i] && arr[i] != max) {
        thirdMax = secondMax;
        secondMax = arr[i];
      } else if(thirdMax < arr[i] && arr[i] != secondMax && arr[i] != max) thirdMax = arr[i];
    }

    return thirdMax;
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

    System.out.println("Third min: " + au.findThirdMin(arr));
    System.out.println("Third max: " + au.findThirdMax(arr));
  }
}
