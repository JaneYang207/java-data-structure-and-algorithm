package sort;

/**
 * This is core of QUICK SORT
 * Pick a pivot, partition an array such that all elements that are less than the partitioning element come
 * before all elements that are greater than it.
 * eg. [5, 9, 13, 2, 7, 20] partition by 8 could be [5, 2, 7, 9, 13, 20]
 *
 * time: O(N), space: O(1)
 */
public class Partition {

  /**
   * Pick a random pivot, partition the array, such that all elements that are less than the partitioning element come
   * before all elements that are greater than it.
   * Partition array elements whose index is between given "lowerBound" index and "upperBound" index by a given pivot.
   * After partition, all elements less than pivot in the left, all elements larger than pivot in the right.
   * @param arr
   * @param lowerBound
   * @param upperBound
   * @param pivot
   * @return
   */
  public int partitionByRandomPivot(int[] arr, int lowerBound, int upperBound, int pivot) {

    int i = lowerBound, j = upperBound;

    int temp;

    while(i < j) {
      // move pointer i from begining until reach the element whose value is larger or equal to pivot
//      while ( arr[i] < pivot && i < arr.length) {   // error: this will give outofindex error
      while (i <= upperBound && arr[i] < pivot) {
        i++;
      }

      // move pointer j from end until reach the element whose value is smaller or equal to pivot
//      while (arr[j] > pivot && j >= 0) {   // error: this will give outofindex error
      while (j >= lowerBound && arr[j] > pivot) {
        j--;
      }

      // swap arr[i] and arr[j] (ONLY when i < j)
      if (i < j) {
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        // no need to increase i, j here; they will both be increased in the inner while statement
        // change pointers, continue iteration (ONLY when i < j)
        // Error: this will cause the pivot not at correct position after finished partition. eg. 5, 9, 13, 12, 11, 6 (pivot 10)
//        i++;
//        j--;
      }
    }

    return i; // i might be out of arr index. If all elements are larger than pivot, i = lowerBound, j = lowerBound - 1;
              // if all elements are smaller than pivot, i = upperBound + 1, j = upperBound
  }

  /**
   * Partition array elements whose index is between given "lowerBound" index and "upperBound" index, take the upperBound element as the pivot.
   * Need to make sure the pivot on the correct position. So after partition finished, need to swap pivot and the first element larger than pivot
   * @param lowerBound
   * @param upperBound
   * @param arr
   * @return
   */
  public int partitionByLastElement(int[] arr, int lowerBound, int upperBound) {
    int pivot = arr[upperBound];
    int pivotIndex = partitionByRandomPivot(arr, lowerBound, upperBound-1, pivot);

    // swap pivot with the first element larger than pivot. (If all elements are smaller than pivot, means pivot is already on the correct position, then no need to swap)
    arr[upperBound] = arr[pivotIndex];
    arr[pivotIndex] = pivot;

    return pivotIndex;
  }

  public void display(int[] arr) {
    System.out.print("The array is: ");
    for(int i=0; i<arr.length; i++) {
      System.out.print(arr[i]+" ");
    }
    System.out.println("");
  }

  public void testPartitionByRandomPivot_regualrCase() {
    int[] arr = new int[] {5, 9, 13, 4, 11, 6, 10};
    int pivot = 9;
    testPartitionByRandomPivot(arr, pivot);
  }

  public void testPartitionByRandomPivot_allSmallerCase() {
    int[] arr = new int[] {5, 9, 13, 4, 6, 10};
    int pivot = 15;
    testPartitionByRandomPivot(arr, pivot);
  }

  public void testPartitionByRandomPivot_allLargerCase() {
    int[] arr = new int[] {5, 9, 13, 4, 6, 10};
    int pivot = 1;
    testPartitionByRandomPivot(arr, pivot);
  }

  public void testPartitionByRandomPivot(int[] arr, int pivot) {
    int pivotIndex = partitionByRandomPivot(arr, 0, arr.length - 1, pivot);

    System.out.println("When pivot is " + pivot + ". The partition is at index: " + pivotIndex);
    if (pivotIndex == 0) {
      System.out.println("all elements are larger than pivot: " + pivot);
    } else if (pivotIndex == arr.length) {
      System.out.println("all elements are smaller than pivot: " + pivot);
    }

    display(arr);
  }

  public void testPartitionByLastElement_regularCase() {
    int[] arr = new int[] {42, 89, 63, 12, 94, 27, 78, 3, 58, 36};
    testPartitionByLastElement(arr);
  }

  public void testPartitionByLastElement_allSmallerCase() {
    int[] arr = new int[] {42, 89, 63, 12, 94, 27, 78, 3, 58, 100};
    testPartitionByLastElement(arr);
  }

  public void testPartitionByLastElement_allLargerCase() {
    int[] arr = new int[] {42, 89, 63, 12, 94, 27, 78, 3, 58, 1};
    testPartitionByLastElement(arr);
  }

  public void testPartitionByLastElement(int[] arr) {
    System.out.print("The last element is " + arr[arr.length-1] + ". ");

    int pivotIndex = partitionByLastElement(arr, 0, arr.length - 1);
    System.out.print("It should be at index: " + pivotIndex + " after partition.");
    if (pivotIndex == 0) {
      System.out.println("all elements are larger than the last element. ");
    } else if (pivotIndex == arr.length - 1) {
      System.out.println("all elements are smaller than the last element. ");
    }

    display(arr);
  }

  public static void main(String[] args) {
    Partition myclass = new Partition();
//    myclass.testPartitionByRandomPivot_regualrCase();
//    myclass.testPartitionByRandomPivot_allSmallerCase();
//    myclass.testPartitionByRandomPivot_allLargerCase();

    myclass.testPartitionByLastElement_regularCase();
    myclass.testPartitionByLastElement_allSmallerCase();
    myclass.testPartitionByLastElement_allLargerCase();
  }
}
