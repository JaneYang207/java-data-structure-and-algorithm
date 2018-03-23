package play_around;

import java.util.Arrays;
import java.util.Comparator;

/**
 * This class must be declared as abstract or implement abstract method compare(T1, T2) of Comparator Interface
 */
public class ImplementComparableInterface implements Comparator<String> {

  /**
   * This methord is from Comparator interface. Must implement this method, otherwise, this class should
   * be defined as abstract
   * @param s1
   * @param s2
   * @return
   */
  public int compare(String s1, String s2) {
    // return s1.compareTo(s2);

    // Sort the strings, if the sorted strings are the same, then s1, s2 are anagrams
    // call Arrays.sort(char[] chs) to sort characters in a string
    // then convert char[] back to String
    char[]  chars1 = s1.toCharArray();
    Arrays.sort(chars1);
    String sortedS1 = new String(chars1);

    char[]  chars2 = s2.toCharArray();
    Arrays.sort(chars2);
    String sortedS2 = new String(chars2);

    // Call compareTo method of String
    return sortedS1.compareTo(sortedS2);
  }


  public static void sortStrings(String[] arr) {
    // Arrays.sort(Object[] arr): sort array in natural order. The "Object" should implement "Comparable" interface
    Arrays.sort(arr);
  }

  public static void display(String[] arr) {
    for(String s : arr) {
      System.out.print(s+"   ");
    }
    System.out.println("");
  }

  public static void main(String[] args) {
    String[] arr = new String[]{"abc", "e", "ghih", "abdm", "cba"};
    ImplementComparableInterface.sortStrings(arr);
    ImplementComparableInterface.display(arr);

  }
}
