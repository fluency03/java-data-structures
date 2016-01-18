/**
 * Class: HashMap
 * Description: A exercise version of the source code of HashMap of Java
 */

package hash;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Map;
import java.io.*;

public class HashMap<K, V> 
  extends AbstractMap<K, V>
  implements Map<K, V>, Cloneable, Serializable
{
  /*
   *  Default value of capacity, which should be the power of 2. 
   */
  static final int DEFAULT_INITIAL_CAPACITY = 16;
  
  /*
   *  Maximal capacity
   */
  static final int MAXIMUM_CAPACITY = 1 << 30;
  
  /*
   *  Default load factor
   */
  static final float DEFAULT_LOAD_FACTOR = 0.75f;
  
  /*
   *  The Table, the length should be the power of 2
   */
  transient Entry[] table;
  
  /*
   * The number of key-value mappings in this map
   */
  transient int size;
  
  /*
   * threshold is equal to the capacity * load factor
   */
  int threshold;
  
  /*
   * The actual load factor
   */
  final float loadFactor;
  
  /*
   * The number of times that HashMap is modified. 
   */
  transient int modCount;
  
  
  /*
   * Constructor specifying the capacity and load factor
   */
  public HashMap(int initialCapacity, float loadFactor) {
    // Check whether the initial capacity is larger than 0
    if (initialCapacity < 0) {
      throw new IllegalArgumentException("Illegal initial capacity: " + initialCapacity);
    }
    
    // Check whether the initial capacity is less than maximum value; if not, set it to the restriction. 
    if (initialCapacity > MAXIMUM_CAPACITY) {
      initialCapacity = MAXIMUM_CAPACITY;
    }
    
    // Check if load factor is legal .
    if (loadFactor <= 0 || Float.isNaN(loadFactor)) {
      // isNaN() returns true if loadFactor is Not-a-Number
      throw new IllegalArgumentException("Illegal load factor: " + loadFactor);
    }
    
    // set the actual capacity as the minimum value 
    // which is larger than initialCapacity and is the power of 2
    int capacity = 1;
    while (capacity < initialCapacity) {
      capacity <<= 1;
    }
    
    // set load factor
    this.loadFactor = loadFactor;
    
    // set threshold
    threshold = (int)(capacity * loadFactor);
    
    // creat Entry
    table = new Entry[capacity];
    
    init(); 
  }
	
  /*
   * Constructor with specified capacity
   */
  public HashMap(int initialCapacity) {
    this(initialCapacity, DEFAULT_LOAD_FACTOR);
  }
  
  /*
   * Default constructor
   */
  public HashMap() {
    // set default load factor 
    this.loadFactor = DEFAULT_LOAD_FACTOR;
    
    // set default threshold
    threshold = (int)(DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
    
    // creat a new table
    table = new Entry[DEFAULT_INITIAL_CAPACITY];
    
    init(); 
  }
  
  /*
   * Constructor with parameter of a Map<K, V>
   */
  // TODO
  
  
  /**
   * TODO
   * According to source code: 
   * Initialization hook for subclasses. This method is called
   * in all constructors and pseudo-constructors (clone, readObject)
   * after HashMap has been initialized but before any entries have
   * been inserted.  (In the absence of this method, readObject would
   * require explicit knowledge of subclasses.)
   */
  void init() { }
  
  /**
   * TODO
   * According to the source
   * Applies a supplemental hash function to a given hashCode, which
   * defends against poor quality hash functions.  This is critical
   * because HashMap uses power-of-two length hash tables, that
   * otherwise encounter collisions for hashCodes that do not differ
   * in lower bits. Note: Null keys always map to hash 0, thus index 0.
   */
  static int hash(int h) {
    // This function ensures that hashCodes that differ only by
    // constant multiples at each bit position have a bounded
    // number of collisions (approximately 8 at default load factor).
    h ^= (h >>> 20) ^ (h >>> 12);
    return h ^ (h >>> 7) ^ (h >>> 4);
  }
  
  /*
   * Calculate the index of hash code h
   */
  static int indexFor(int h, int length) {
    return (h & (length - 1));
  }
  
  /*
   * Returns the number of key-value mappings in this map.
   */
  public int getSize() {
    return size;
  }
  
  /*
   * Check empty
   */
  public boolean isEmpty() {
    return (size == 0);
  }
  
  /*
   * Get the value of certain key
   */
  public V getValue(Object key) {
    if (key == null) {
      return getValueForNullKey();
    }
    
    // Get the hash code of the key
    int hash = hash(key.hashCode());
    for (Entry<K, V> e = table[indexFor(hash, table.length)];
         e != null;
         e = e.next) {
        Object k;
        if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
          return e.value;
      } 
    }
    return null;
  }
  
  /* 
   * Return the value if key==null
   * HashMap will store key of null at table[0]！
   */
  private V getValueForNullKey() {
    for (Entry<K, V> e = table[0]; e != null; e = e.next) {
      if (e.key == null) {
        return e.value;
      }
    }
    return null;
  }
  
  /*
   * Check whether the HashMap contains a certain key
   */
  public boolean containsKey(Object key) {
    return (getEntry(key) != null);
  }
  
  /*
   * Get the pair of certain key
   */
  final Entry<K, V> getEntry(Object key) {
    /*
     *  Get hash code
     *  If key == null, which stored at table[0], set the hash to 0;
     *  If key != null, calculate the hash code using hash function
     */
    int hash = (key == null) ? 0 : hash(key.hashCode());
    
    // at the linked list regarding above hash, and check the e.key == key
    for (Entry<K, V> e = table[indexFor(hash, table.length)];
         e != null;
         e = e.next
        ) {
        Object k;
        if (e.hash == hash && 
            ((k = e.key) == key || (key != null && key.equals(k) ))) {
          // TODO check the condition once more
            return e;
      }
    }
    return null;
  }
  
  /*
   * Put a pair of key-value into the HashMap
   * If the key is not existing, return null finally;
   * If the key is existing, return the old value under this key
   */
  public V put(K key, V value) {
    // if key == null, put it at table[0]
    if (key == null) {
      putForNullKey(value);
    }
    
    // if key != null, calculate the hash code
    int hash = hash(key.hashCode());
    int i = indexFor(hash, table.length);
    for (Entry<K, V> e = table[i]; e != null; e = e.next) {
      Object k;
      // If the key is existing, return the old value under this key
      if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
        V oldValue = e.value;
        e.value = value;
        e.recordAccess(this);
        return oldValue;
      }
    }
    
    // If the key is not existing, return null finally
    modCount ++;
    addEntry(hash, key, value, i);
    return null;
  }
  
  
  
  /*
   * Put a pair of key-value into the HashTable
   * where key == null and put it into table[0]
   */
  private V putForNullKey(V value) {
    for (Entry<K, V> e = table[0]; e != null; e = e.next) {
      if (e.key == null) {
        V oldValue = e.value;
        e.value = value;
        e.recordAccess(this);
        return oldValue;
      }
    }
    // If the key is not existing, return null finally
    // will not be executed
    modCount ++;
    addEntry(0, null, value, 0);
    return null;
  }
  
  
  
  
  // TODO
  
  
  
  /*
   * Class: Entry, Singly Linked List
   * implements APIs from Map.Entry, e.g., getKey(), getValue(), setValue(V value), equals(Object o), hashCode()
   */
  static class Entry<K, V> implements Map.Entry<K, V> {
    final K key; 
    // TODO why final?
    V value;
    Entry<K, V> next;
    final int hash;
    
    Entry(int h, K k, V v, Entry<K, V> n) {
      hash = h;
      value = v;
      key = k;
      next = n;
    }
    
    public final K getKey() {
      return key;
    }
    
    public final V getValue() {
      return value;
    }
    
    public final V setValue(V newValue) {
      V oldValue = value;
      value = newValue;
      return oldValue;
    }
    
    /*
     * Check whether two Entry are equal
     * Check both key and value
     */
    public final boolean equals(Object o) {
      if (!(o instanceof Map.Entry)) {
        return false;
      }
      
      Map.Entry e = (Map.Entry)o;
      Object k1 = getClass();
      Object k2 = e.getKey();
      if (k1 == k2 || (k1 != null) && k1.equals(k2)) {
        Object v1 = getValue();
        Object v2 = e.getValue();
        if (v1 == v2 || (v1 != null) && v1.equals(v2)) {
          return true;
        }
      }
      return false;
    }
    
    /*
     * hash code generate
     */
    public final int hashCode() {
      return (key == null   ? 0 : key.hashCode()) ^ 
             (value == null ? 0: value.hashCode());
    }
    
    public String toString() {
      return (getKey() + "" + getValue());
    }
    
    /**
     * According to the source: 
     * This method is invoked whenever the value in an entry is
     * overwritten by an invocation of put(k,v) for a key k that's already
     * in the HashMap.
     */
    void recordAccess(HashMap<K,V> m) { }
    
    /**
     * According to the source: 
     * This method is invoked whenever the entry is
     * removed from the table.
     */
    void recordRemoval(HashMap<K,V> m) { }
  }
  
  /*
   * Add a new Entry, with a new key-value pair and index
   */
  void addEntry(int hash, K key, V value, int index) {
    
    
    
    
  }
	
  /*
   * Create a new Entry, with a new key-value pair and index
   * (i) addEntry() normally used when adding new Entry could lead to be over threshold
   * (ii) createEntry() normally used when adding new Entry will not lead to be over threshold
   */
  void creatEntry(int hash, K key, V value, int index) {
    
    
    
    
    
    
  }
  
  
  
  
  
  
  
  
	
  // TODO


  
  
  
  
  
  
  
  
  
}
