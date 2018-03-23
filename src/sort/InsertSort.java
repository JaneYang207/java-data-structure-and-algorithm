package sort;

/**
 * Insertion Sort
 */
public class InsertSort {

  public void insertSort(int[] arr) {
    int size = arr.length;

    int temp;

    if (size < 2)
      return;

    for(int i = 0; i < size; i++) {

      // compare arr[i] with all elements before it
      // assume all elements before arr[i] are already sorted
      for(int j = 0; j < i; j++) {

        if (arr[j] > arr[i]) {

          // backup arr[i]
          temp = arr[i];

          // move all elements between j and i-1 backwards so that we can put the arr[i] at the right spot
          // (move arr[j] to arr[j+1], move arr[i-1] to arr[i])
          for (int k = i; k >= j + 1; k--) {
            arr[k] = arr[k-1];
          }

          // arr[j] is now empty, put the original arr[i] at the empty spot
          arr[j] = temp;
        }
      }
    }

  }

  public void display(int[] arr) {
    System.out.print("The array is: ");
    for(int i=0; i<arr.length; i++) {
      System.out.print(arr[i]+" ");
    }
    System.out.println("");
  }

  public static void main(String[] args) {
    InsertSort myclass = new InsertSort();
    int[] arr = new int[]{5, 2, 8, 1, 4, 6, 9};
    myclass.insertSort(arr);
    myclass.display(arr);
  }
}
