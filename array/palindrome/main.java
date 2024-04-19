import java.util.Scanner;

class ArrayUtil {
  boolean checkPalidrome(String str) {
    char[] word = str.toCharArray();

    for(int i=0; i<(word.length)/2; i++) if(word[i] != word[word.length - i - 1]) return false;
    return true;
  }
}

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter the string to check: ");
    String str = sc.next();

    ArrayUtil au = new ArrayUtil();

    if(au.checkPalidrome(str)) System.out.println("It is a palindrome.");
    else System.out.println("Not a palindrome.");
  }
}
