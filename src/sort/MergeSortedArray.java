package sort;

/**
 * Merge two sorted array into one
 */
public class MergeSortedArray {

  public int[] merge(int[] arr1, int[] arr2) {
    int size1 = arr1.length;
    int size2 = arr2.length;

    int[] ans = new int[size1 + size2];

    int i = 0, j = 0, k = 0;

    while (i < size1 && j < size2) {
      if (arr1[i] < arr2[j]) {
        ans[k++] = arr1[i++];
      } else {
        ans[k++] = arr2[j++];
      }
    }

    // if i reaches the end of arr1, j doesn't reach the end of arr2
//    if (i == size1 && j < size2) {
//      while (j < size2) {
//        ans[k++] = arr2[j++];
//      }
//    }
    while (j < size2) {
        ans[k++] = arr2[j++];
    }

    // if j reaches the end of arr2, i doesn't reach the end of arr1
//    if (j == size2 && i < size1) {
//      while (i < size1) {
//        ans[k++] = arr2[i++];
//      }
//    }
    while (i < size1) {
      ans[k++] = arr2[i++];
    }

    return ans;
  }

  public void display(int[] arr) {
    for(int i=0; i<arr.length; i++) {
      System.out.print(arr[i]+" ");
    }
  }


  public static void main(String[] args) {

    MergeSortedArray myclass = new MergeSortedArray();

    int[] arr1 = new int[] {1, 7, 10, 12};
    int[] arr2 = new int[] {5, 9, 11, 17, 19, 25};
    int[] ans = myclass.merge(arr1, arr2);

    myclass.display(ans);
  }


 }
