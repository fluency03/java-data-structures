/**
 * Class: HashMap
 * Author: Chang LIU
 */

package hash;

public class HashMap<K, V> {
  private final static int TABLE_SIZE = 128;

  HashEntry<K, V>[] table;

  HashMap() {
    table = (HashEntry<K, V>[])new Object[TABLE_SIZE];
    for (int i = 0; i < TABLE_SIZE; i++) {
      table[i] = null;
    }
  }

  public V get(K key){
     int hash = (key.hashCode() % TABLE_SIZE);
     while (table[hash] != null && table[hash].getKey() != key) {
       hash = (hash + 1) % TABLE_SIZE;
     }
     if (table[hash] != null  ) {
       return null;
     }
     else {
       return table[hash].getValue();
     }
  }

  public void put(K key, V value) {
    int hash = (key.hashCode() % TABLE_SIZE);
    while (table[hash] != null && table[hash].getKey() != key) {
      hash = (hash + 1) % TABLE_SIZE;
    }
    table[hash] = new HashEntry<K, V>(key, value);
  }

}
