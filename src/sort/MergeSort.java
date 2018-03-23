package sort;

public class MergeSort {

  public static int[] mergeSort(int[] arr) {
    int[] workspace = new int[arr.length];
    devideAndSort(0, arr.length-1, arr, workspace);
    return arr;
  }

  private static void devideAndSort(int lowerBound, int upperBound, int[] arr, int[] workspace) {

    // base condition: lowerBound == upperBound
    if (lowerBound == upperBound) return;

    // devide and conquer
    int mid = (lowerBound + upperBound) / 2;
    devideAndSort(lowerBound, mid, arr, workspace);
    devideAndSort(mid + 1, upperBound, arr, workspace);

    // merge devided array into one
    merge(lowerBound, mid, upperBound, arr, workspace);
  }

  /**
   *  merge two sorted array to one
   *        the first array index: lowerBound ~ mid
   *        the second array index: mid + 1 ~ upperBound
   *  use aother array "workspace" to store the sorted values; then copy "workspace" back to the original array
   */
  private static void merge(int lowerBound, int mid, int upperBound, int[] originalArr, int[] workspace) {

    // int[] workspace = new int[arr.length]; // this is bad, because every recursion, this will introduce a new array, thus this takes up a lot of memory


    // the following is wrong. eg. lowerBound = 10, mid = 15, size1 = 6, i = 10, while loop never gets run, because i > size1
//    int size1 = mid - lowerBound + 1;
//    int size2 = upperBound - mid;
//
//    int i = lowerBound, j = mid + 1, k = lowerBound;
//
//    while( i < size1 && j < size2 ) {
//      // compare originalArr[i] and originalArr[j], put the smaller one to workspace[k]
//      if (originalArr[i] < originalArr[j]) {
//        workspace[k++] = originalArr[i++];
//      } else {
//        workspace[k++] = originalArr[j++];
//      }
//    }
//
//    // It's possible that size1 and size2 are not the same. Eg, size1 = 2, size2 = 3;
//    while (j<size2) {
//      workspace[k++] = originalArr[j++];
//    }
//
//    while (i<size1) {
//      workspace[k++] = originalArr[i++];
//    }


    int i = lowerBound, j = mid + 1, k = lowerBound;

    while( i <= mid && j <= upperBound ) {
      // compare originalArr[i] and originalArr[j], put the smaller one to workspace[k]
      if (originalArr[i] < originalArr[j]) {
        workspace[k++] = originalArr[i++];
      } else {
        workspace[k++] = originalArr[j++];
      }
    }

    // It's possible that size1 and size2 are not the same. Eg, size1 = 2, size2 = 3;
    while (j <= upperBound) {
      workspace[k++] = originalArr[j++];
    }

    while (i <= mid) {
      workspace[k++] = originalArr[i++];
    }

    // copy workspace back to originalArr (only the sorted part)
    for(int index = lowerBound; index <= upperBound; index++) {
      originalArr[index] = workspace[index];
    }

  }


  public static void display(int[] arr) {
    for(int i=0; i<arr.length; i++) {
      System.out.print(arr[i]+" ");
    }
  }


  public static void main(String[] args) {

    int[] arr = new int[] {14, 21, 33, 70, 12, 85, 44, 3};
    int[] ans = MergeSort.mergeSort(arr);

    MergeSort.display(ans);
  }

}
