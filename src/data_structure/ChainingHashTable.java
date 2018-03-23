package data_structure;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jyang on 11/11/17.
 */
public class ChainingHashTable<K, V> {

//  Entry[] hashArray;
  List<Entry<K, V>>[] hashArray;
  int capacity;

  public class Entry<K, V> {
    K key;
    V value;

    public Entry(K key, V value) {
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

  public ChainingHashTable(int capacity) {
    this.capacity = capacity;

    // Generic array creation
//    hashArray = new ArrayList<Entry>[capacity];

    hashArray = new ArrayList[capacity]; // all elements are null
  }

  public int hashFunc(K key) {
    if(key instanceof Integer) {
      return (Integer)key % capacity;
    }
    return -1;
  }

  public void put(K key, V value) {
    Entry pair = new Entry(key, value);

    // find hashVal
    int hashVal = hashFunc(key);

    if (hashVal < 0)
      return;

    // put entry pair
    List<Entry<K,V>> list = hashArray[hashVal]; // list is null because all elements of hashArray is null

    if (list == null) {
      list = new ArrayList<Entry<K, V>>();
      hashArray[hashVal] = list;
    }

    list.add(pair);
  }

  public void display() {
    for (int i=0; i < capacity; i++) {
      System.out.print("index: " + i + "   ");

      List<Entry<K, V>> list = hashArray[i];

      if (list != null && !list.isEmpty()) {
        for(Entry<K, V> pair : list) {
          V value = pair.getValue();
          K key = pair.getKey();

          if (key instanceof Integer && value instanceof String) {
            System.out.print("   key: " + key);
            System.out.print("--->");
            System.out.print("value: " + value);
          }
        }

      }
      else
      {
        System.out.print("empty");
      }

      System.out.println();
    }
  }

  public static void main(String[] args) {
    ChainingHashTable myclass = new ChainingHashTable(10);
    myclass.put(40, "forty");
    myclass.put(43, "forty three");
    myclass.put(30, "thirty");

    myclass.display();

//    List<String>[] arr;
//    arr = new ArrayList<String>[2];
//
//
//    List<String>[] arr2 = new ArrayList<String>[2];
//
//    List<String>[] arr3 = new ArrayList[2];
  }

}
