package play_around;

import java.util.ArrayList;
import java.util.List;

/**
 * Java generic array creation error
 */
public class Generics {


  public static void main(String[] args) {
    Integer[] arr1 = new Integer[5];
//    List<Integer>[] arr = new ArrayList<Integer>[5]; // compile error: generic array creation

    Object[] arr2 = new Object[5];
//    Integer[] arr3 = new Object[5]; // compile error: required java.long.Integer[], found java.lang.Object[]
    Integer[] arr3 = (Integer[]) new Object[5];
//    arr3[0] = 1; // java classCastException: cannot cast java.lang.Object to java.lang.Integer
    arr3[0] = (Integer)1;

    System.out.println("the first element in arr3 is "+ arr3[0]);
  }
}
