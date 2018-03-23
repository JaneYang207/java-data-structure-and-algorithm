package data_structure;

/**
 * Open addressing: If a spot is already taken, go to next spot
 *     Quadratic Probing: index = hashVal + i * i, where i is the stepNumber.
 *                        No fixed step size.
 */
public class QuadraticProbingHashTable<K, V> {
  Entry<K, V>[] hashArray;
  int capacity;

  /**
   * innter class "KeyValuePair"
   * @param <K> key
   * @param <V> value
   */
  public class Entry<K, V> {
    K key;
    V value;

    public Entry (K key, V value) {
      this.key = key;
      this.value = value;
    }

    public K getKey() {
      return this.key;
    }

    public V getValue() {
      return this.value;
    }
  }

  public QuadraticProbingHashTable(int capacity) {
    this.capacity = capacity;
    this.hashArray = new Entry[capacity];
  }


  /**
   * Convert key to array index
   */
  public int hashFunc(int key) {
    return key % capacity;
  }

  /**
   * put a <key, value> pair. To simplify, always use an integer as key
   * If the spot is already taken, go to next spot until find a empty one;
   * If reach the end of the array, wrap around
   * If the array is full, throws exception
   */
  public void put(K key, V value) throws Exception {

    // use integer as the key to simplify hash function
    if (key instanceof Integer) {

      // get array index (hashVal)
      int hashVal = hashFunc((Integer)key);

      // Quadratic probling: hashVal + i^2
      // i is the stepNumber

      int index = hashVal;
      boolean moveDownwards = true;

      int i = 0;
      while (moveDownwards || index < hashVal) {
        if (hashArray[index] == null) {
          break;
        } else {
          i++;
          index = hashVal + i*i;

          // wrap around index if necessary
          if(index >= capacity) {
            index = index % capacity;
            moveDownwards = false;
          }
        }
      }

      if (!moveDownwards && index >= hashVal) {
        throw new Exception("The array is full.");
      } else {
        Entry<K, V> newPair = new Entry<>(key, value);
        hashArray[index] = newPair;
      }

    }
  }


  public void display() {
    for (int i=0; i < capacity; i++) {
      System.out.print("index: " + i + "   ");

      Entry<K, V> pair = hashArray[i];

      if (pair != null) {
        V value = pair.getValue();
        K key = pair.getKey();

        if (key instanceof Integer && value instanceof String) {
          System.out.print("   key: " + key);
          System.out.print("   value: " + value);
        }
      }
      else
      {
        System.out.print("   value: null");
      }

      System.out.println();
    }
  }

  public static void main(String[] args) {
    QuadraticProbingHashTable<Integer, String> hashTable = new QuadraticProbingHashTable<>(10);

    // put
    try {
      hashTable.put(30, "thirty");
      hashTable.put(31, "thirty one");
      hashTable.put(35, "thirty five");
      hashTable.put(22, "twenty two");
      hashTable.put(24, "twenty four");
      hashTable.put(43, "forty three");
      hashTable.put(40, "forty");
      hashTable.put(45, "forty five");
      hashTable.put(50, "fifty");
      hashTable.display();
    } catch(Exception e) {
      hashTable.display();
      System.out.println(e.getMessage());
    }


  }
}
