/**
 * Class: HashEntry
 * Author: Chang LIU
 */

package hash;

public class HashEntry<K, V> {

  private K key;
  private V value;
  private HashEntry<K, V> next;

  HashEntry (K key, V value) {
    this.key = key;
    this.value = value;
    this.next = null;
  }

  public K getKey() {
    return key;
  }

  public V getValue() {
    return value;
  }

  public HashEntry<K, V> getNext() {
   return next;
  }

}
