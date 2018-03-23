package data_structure;

public class CustomArray<T extends Comparable<T>>
{
	private T[] arr;
	private int numberOfElements;

	public CustomArray(int capacity) {
//		this.arr = (T[]) new Object[size]; // [Ljava.lang.Object; cannot be cast to [Ljava.lang.Comparable
		this.arr = (T[]) new Comparable[capacity]; // [Ljava.lang.Object; cannot be cast to [Ljava.lang.Comparable
		this.numberOfElements = 0;
	}

	public void insert(T value) {
		arr[numberOfElements] = value;
		numberOfElements++;
	}

	// liner search
	// worst case: O(N),
	// best case: O(1),
	// normal case: O(N/2)
	// ignore constants: O(N)
	public int find(T value) {
		for (int i=0; i<numberOfElements; i++) {
			if(value.compareTo(arr[i]) == 0) {
				System.out.println("find element at index " +i);
				return i;
			}
		}
		System.out.println("can not find the element");
		return -1;
	}

	// binary search
	// O(log(N))
	public int binaryFind(T value) {
		int lowerBound = 0;
		int upperBound = this.numberOfElements - 1;

		while (lowerBound <= upperBound) {
			// find middle
			int middle = (lowerBound + upperBound) / 2;

			// compare middle with the value
			if (arr[middle] == value) {
				System.out.println("find value at index "+middle);
				return middle;
			}

			if (value.compareTo(arr[middle]) > 0) {
				lowerBound = middle + 1;
			}
			else {
				upperBound = middle - 1;
			}
		}

		System.out.println("unable to find the value");
		return -1;
	}

	public void deleteAfterFind(T value) {
		// step 1. find the index
		int idx = this.find(value);

		// step 2. remove
		if (idx == -1) {
			System.out.println("the value does not exist in the array.");
		}
		else {
			for(int j = idx; j < numberOfElements-1; j++) {
				arr[j] = arr[j+1];
			}

			// step 3. decrease size
			numberOfElements--;

			System.out.println("the value was at index "+idx+" , and it has been removed.");
		}
	}

	public boolean deleteWhenFind(T value) {
		for (int i=0; i<numberOfElements; i++) {
			if(arr[i].equals(value)){
				for(int j=i; j<numberOfElements-1; j++){
					arr[j] = arr[j+1];
				}
				arr[numberOfElements-1] = null;
				numberOfElements--;
				return true;
			}
		}
		System.out.println("Unable to delete: the object does not exist");
		return false;
	}

	public CustomArray<T> insertAt(int targetIndex, T value) throws Exception{
		// case 2. targetIndex > count
		if (targetIndex > numberOfElements-1) {
			arr[targetIndex] = value;
			numberOfElements = targetIndex+1;
		}
		// case 3. 0 <= targetIndex <= numberOfElements-1
		else {
			for (int i=numberOfElements-1; i>=targetIndex; i--) {
				arr[i+1] = arr[i];
			}
			arr[targetIndex] = value;
			numberOfElements++;
		}

		return this;
	}

	public CustomArray<T> insertAfter(T targetValue, T insertValue) {
		for (int i=0; i < numberOfElements; i++) {
			if(arr[i].equals(targetValue)) {
				for(int j = numberOfElements - 1; j > i; j--) {
					arr[j+1] = arr[j];
				}
				arr[i+1] = insertValue;
				numberOfElements++;
				return this;
			}
		}
		System.out.println("unable to insert: the value does not exist");
		return this;
	}

	public void display () {
		for (int i=0; i<numberOfElements; i++) {
			System.out.println(arr[i]);
		}
	}


	public static void main(String args[]) {
		CustomArray<Integer> arr = new CustomArray<>(15);
		arr.insert(0);
		arr.insert(1);
		arr.insert(2);
		arr.insert(3);
		arr.insert(4);
		arr.insert(5);
		arr.insert(6);
		arr.insert(8);
		arr.insert(9);
//
//		arr.display();
//
//		arr.find(3);
//		arr.binaryFind(3);
//		arr.find(7);
//		arr.binaryFind(7);
//
//		arr.deleteWhenFind(2);
//		arr.insertAt(2, 100);
//		arr.insertAt(17, 200);
//		arr.insertAt(12, 200);
		try {
//			arr.insertAt(16, 100);
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Exception "+e+" was caught!");
		}

		arr.display();

//
//		arr.delete(0);
//		arr.delete(5);
//		arr.display();
//
//		arr.delete(9);

//		arr.insert('a');
//		arr.insert('b');
//		arr.insert('c');
//		arr.insert('d');
//		arr.insert('e');
//		arr.display();
//
//		arr.find('c');
//
//		arr.delete('e');
//		arr.display();

//
//		CustomArray<String> arr = new CustomArray<>(10);
//		arr.insert("ab");
//		arr.insert("bc");
//		arr.insert("cd");
//		arr.insert("de");
//		arr.insert("ef");
//		arr.display();
//
//		arr.find("cd");
//
//		arr.delete("ef");
//		arr.display();

	}

}
