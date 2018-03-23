package sort;

/**
 * Quick Sort
 */
public class QuickSort {

  public void quickSort(int[] arr) {
    recQuickSort(0, arr.length-1, arr);
  }

  public void recQuickSort(int startIndex, int endIndex, int[] arr) {
    // Termination condition
    if(startIndex >= endIndex) return;

    Partition partition = new Partition();
    int pivotIndex = partition.partitionByLastElement(arr, startIndex, endIndex);

    recQuickSort(startIndex, pivotIndex - 1, arr);
    recQuickSort(pivotIndex, endIndex, arr);
  }

  // partition: take the most right element as the pivot
//  public int partitionByLastElement(int[] arr, int lowerBound, int upperBound) {
//    int pivot = arr[upperBound];
//
//    int i = lowerBound;
//    int j = upperBound - 1;
//
//    int temp;
//
//    while (i < j) {
//      // move i
//      while(i <= upperBound && arr[i] < pivot) {
//        i++;
//      }
//
//      // move j
//      while(j >= lowerBound && arr[j] > pivot) {
//        j--;
//      }
//
//      if (i < j) {
//        temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//      }
//    }
//
//    // swap pivot with the first element larger than pivot. (If all elements are smaller than pivot, means pivot is already on the correct position, then no need to swap)
//    arr[upperBound] = arr[i];
//    arr[i] = pivot;
//
//    return i; // i might be out of arr index. If all elements are larger than pivot, i = lowerBound, j = lowerBound - 1;
//    // if all elements are smaller than pivot, i = upperBound, j = upperBound-1
//  }

  public void display(int[] arr) {
    for(int i=0; i<arr.length; i++) {
      System.out.print(arr[i]+" ");
    }
  }

  public static void main(String[] args) {
    QuickSort myclass = new QuickSort();
    int[] arr = new int[] {42, 89, 63, 12, 94, 27, 78, 3, 50, 36};
    myclass.quickSort(arr);

    myclass.display(arr);
  }
}
