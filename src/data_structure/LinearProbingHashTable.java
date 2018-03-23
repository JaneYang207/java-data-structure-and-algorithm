package data_structure;

/**
 * Open addressing: If a spot is already taken, go to next spot
 *     Linear probing: index = hashVal + i * stepSize, where stepSize = 1, i is the stepNumber
 *                     index = index + stepSize, where stepSize = 1
 */
public class LinearProbingHashTable<K, V> {
  Entry<K, V>[] hashArray;
  int capacity;

//  K[] keys;

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

  public LinearProbingHashTable(int capacity) {
    this.capacity = capacity;

    // java classCastException: cannot cast java.lang.Object to ...
//    this.hashArray = (Entry<K, V>[])new Object[capacity];

    // Generic array creation
//    this.hashArray = new Entry<K,V>[capacity];

    this.hashArray = new Entry[capacity];

    // Type K cannot be instantiated correctly. The compiler doesn't know which type of K represents.
    // this.keys = new K[capacity];
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

      // insert at the hashVal; if already taken, go to next empty spot
      int index = hashVal;
      boolean moveDownwards = true;

      while (moveDownwards || index < hashVal) {
        if (hashArray[index] == null) {
          break;
        }
        else
        {
          index++;

          // wrap around if neccessary
          if (index == capacity) {
            index = index%capacity;
            moveDownwards = false;
          }
        }
      }

      if (!moveDownwards && index == hashVal) {
        throw new Exception("The array is full.");
      } else {
        Entry<K, V> newPair = new Entry<>(key, value);
        hashArray[index] = newPair;
      }

    }
  }

  public V get(K key) throws Exception {
    if (key instanceof Integer) {
      int hashVal = hashFunc((Integer)key);

      int i = hashVal;
      Entry<K, V> pair;
      boolean moveDownwards = true;

      while(moveDownwards || i < hashVal) {
        pair = hashArray[i];

        if (pair.getKey() == key) {
          System.out.println("found value of " + key + ": " + pair.getValue());
          return pair.getValue();
        }
        else
        {
          i++;

          // wrap around if needed
          if (i == capacity) {
            i = i % capacity;
            moveDownwards = false;
          }
        }
      }

      System.out.println("Key " + key + " not exist.");
      return null;
    }
    else
    {
      System.out.println("Key is not integer. We don't hash other types of keys.");
      return null;
    }

  }

  public void delete(int key) {
  }

  public void display() {
    for (int i=0; i < capacity; i++) {
      System.out.print("index: " + i + "   ");

      Entry<K, V> pair = hashArray[i];

      if (pair != null) {
        V value = pair.getValue();

        if (value instanceof Integer || value instanceof String) {
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
    LinearProbingHashTable<Integer, String> hashTable = new LinearProbingHashTable<>(5);

    // put
    try {
      hashTable.put(30, "thirty");
      hashTable.put(31, "thirty one");
      hashTable.put(35, "thirty five");
      hashTable.put(22, "twenty two");
      hashTable.put(24, "twenty four");
//      hashTable.put(43, "forty three");
      hashTable.display();
    } catch(Exception e) {
      hashTable.display();
      System.out.println(e.getMessage());
    }

    try {
      hashTable.get(32);
      hashTable.get(35);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }



  }
}
