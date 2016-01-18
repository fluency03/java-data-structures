/**
 * Class: HashMap
 * Description: A exercise version of the source code of HashMap of Java
 */

package hash;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
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
    // The following code will not be executed
    modCount ++;
    addEntry(0, null, value, 0);
    return null;
  }
  
  /*
   * Put method when creating HashMap
   * internal method, instead of put() which is external method
   */
  private void putForCreat(K key, V value) {
    
    // TODO

  }
  
  /*
   * Put all elements of Map m into this
   * Used for creating new map
   * internal method, instead of putAll() which is external method
   */
  private void putAllForCreate(Map<? extends K, ? extends V> m) {
    
    // TODO

  }

  
  /*
   * Resahpe the size of the table regarding capacity
   */
  void resize(int newCapacity) {
    Entry[] oldTable = table;
    int oldCapacity = oldTable.length;
    if (oldCapacity == MAXIMUM_CAPACITY) {
      threshold = Integer.MAX_VALUE;
      return;
    }
    
    // Create a new table
    // and cope all old elements into the new one
    Entry[] newTable = new Entry[newCapacity];
    transferTo(newTable);
    table = newTable;
    threshold = (int)(newCapacity * loadFactor);
  }
  
  /*
   * transfer the old elements into new table
   */
  void transferTo(Entry[] newTable) {
    Entry[] src = table;
    int newCapacity = newTable.length;
    for (int j = 0; j < src.length; j++) {
      Entry<K, V> e = src[j];
      if (e != null) {
        src[j] = null;
        do {
          Entry<K, V> next = e.next;
          int i = indexFor(e.hash, newCapacity);
          e.next = newTable[i];
          newTable[i] = e;
          e = next;
        } while(e != null);
      }
    }
  }
  
  /*
   * Put all elements at m into this 
   */
  public void putAll(Map<? extends K, ? extends V> m) {
  
  // TODO
    
  }
  
  /*
   * Remove the element with certain key
   * And return the value regarding that key
   */
  public V remove(Object key) {
    Entry<K, V> e = removeEntryForKey(key);
    return (e == null ? null : e.value);
  }
  
  /*
   * Remove the element with certain key
   * And return the Entry regarding that key
   * (only remove one node, not a whole linked list)
   */
  public Entry<K, V> removeEntryForKey(Object key) {
    // Get the hash code
    int hash = (key == null) ? 0: hash(key.hashCode());
    int i = indexFor(hash, table.length);
    Entry<K, V> prev = table[i];
    Entry<K, V> e = prev;
    
    while (e != null) {
      Entry<K, V> next = e.next;
      Object k;
      if (e.hash == hash && 
          ((k = e.key) == key || (key != null && key.equals(k)))) {
            modCount++;
            size--;
            if (prev == e) {
              table[i] = next;
            } else {
              prev.next = next;
            }
            e.recordRemoval(this);
            return e;
      }
      prev = e;
      e = next;
    }
    return e;
  }
  
  /*
   * Remove the pair of key-value (a mapping)
   * And return the Entry regarding that key-value pair
   * (only remove one node, not a whole linked list)
   */
  final Entry<K, V> removeMapping(Object o) {
    if (!(o instanceof Map.Entry)) {
      return null;
    }
    
    Entry<K, V> entry = (Entry<K, V>) o;
    Object key = entry.getKey();
    int hash = hash(key.hashCode());
    int i = indexFor(hash, table.length);
    Entry<K, V> prev = table[i];
    Entry<K, V> e = prev;
    
    while (e != null) {
      Entry<K, V> next = e.next;
      if (e.hash == hash && e.equals(entry)) {
        modCount++;
        size--;
        if (prev == e) {
          table[i] = next;
        } else {
          prev.next = next;
        }
        e.recordRemoval(this);
        return e;
      }
      prev = e;
      e = next;
    }
    return e;
  }
  
  /*
   * Clear the HashMap
   */
  public void clear() {
    modCount++;
    // TODO why do not use table directly
    Entry[] tab = table;
    for (int i = 0; i <tab.length; i++) {
      tab[i] = null;
    }
//    table = tab;
    size = 0;
  }
  
  /*
   * Check whether this contains certain value
   */
  public boolean containsValue(Object value) {
    if (value == null) {
      return containsNullValue(value);
    }
    
    Entry[] tab = table;
    for (int i = 0; i < tab.length; i++) {
      for (Entry<K, V> e = tab[i]; e != null; e = e.next) {
        if (value.equals(e.value)) {
          return true;
        }
      }
    }
    return false;
  }
  
  /*
   * Check whether this contains value null
   */
  public boolean containsNullValue(Object vlaue) {
    Entry[] tab = table;
    for (int i = 0; i < tab.length; i++) {
      for (Entry<K, V> e = tab[i]; e != null; e = e.next) {
        if (e == null) {
          return true;
        }
      }
    }
    return false;
  }
  
  
  /*
   * Clone a HashMap, and return an Objact
   */
  public Object clone() {
    HashMap<K, V> result = null;
    
    try {
      result = (HashMap<K,V>)super.clone();
    } catch(CloneNotSupportedException e) {
      // assert error
    }

    result.table = new Entry[table.length];
    result.entrySet = null;
    result.modCount = 0;
    result.size = 0;
    result.init();
    result.putAllForCreate(this);
    
    return result;
  }

  
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
    // store the current Entry @index into temporal value e
    Entry<K, V> e = table[index];
    // create a new Entry into the position @index
    // and set the e as the next
    table[index] = new Entry<K,V>(hash, key, value, e);
   
    // Check if the threshold is overed. 
    if (size++ >= threshold) {
      resize(2 * table.length);
    }
  }
	
  /*
   * Create a new Entry, with a new key-value pair and index
   * (i) addEntry() normally used when adding new Entry could lead to be over threshold
   * (ii) createEntry() normally used when adding new Entry will not lead to be over threshold
   */
  void creatEntry(int hash, K key, V value, int index) {
    // store the current Entry @index into temporal value e
    Entry<K, V> e = table[index];
    // create a new Entry into the position @index
    // and set the e as the next
    table[index] = new Entry<K,V>(hash, key, value, e);
    size ++;
  }
  
  
  /* ------------------
   * TODO: HashIterator
   * ------------------
   */
  
  
  /*
   * The abstract super class for the following three classes:
   * KeyIterator, ValueIterator, EntryIterator
   */
  private abstract class HashIterator<E> implements Iterator<E> {
    Entry<K, V> next;
    
    // good for fast-fail ? TODO
    int expectedModCount;
    // current index
    int index;
    // current element
    Entry<K, V> current;
    
    HashIterator() {
      expectedModCount = modCount;
      // TODO
      
      
      
      
    }
    
    public final boolean hasNext() {
      return (next != null);
    }
    
    final Entry<K, V> nextEntry() {
      if (modCount != expectedModCount) {
        throw new ConcurrentModificationException();
      }
      
      Entry<K, V> e = next;
      if (e == null) {
        throw new NoSuchElementException();
      }
      
      // If the next is not null, then point to next
      // If next is null, then point to next linked list
      if ((next = e.next) == null) {
        Entry[] t = table;
        while (index < t.length && (next = t[index++]) == null)
          ;
      }
      current = e;
      return e;
    }
    
    public void remove() {
      
      // TODO

    }
  }
  
  
  
  /*
   * Iterator of values
   */
  private final class ValueIterator extends HashIterator<V> {
    public V next() {
      return nextEntry().value;
    }
  }
  
  /*
   * Iterator of keys
   */
  private final class KeyIterator extends HashIterator<K> {
    public K next() {
      return nextEntry().getKey();
    }
  }
  
  /*
   * Iterator of Entry
   */
  private final class EntryIterator extends HashIterator<Map.Entry<K, V>> {
    public Map.Entry<K, V> next() {
      return nextEntry();
    }
  }
  
  
  /* ------------------
   * TODO: HashIterator
   * ------------------
   */
  
  
  
  /*
   * Set of Entry
   */
  private transient Set<Map.Entry<K, V>> entrySet = null;
  
  /*
   * Return the set of key
   */
  public Set<K> keySet() {
    Set<K> ks = keySet;
    return (ks != null ? ks : (keySet = new KeySet())); 
  }
  
  /*
   * Set of keys
   */
  private final class KeySet extends AbstractSet<K> {
    public Iterator<K> iterator() {
      return newKeyIterator();
    }
    
    public int size() {
      return size;
    }
    
    public boolean contains(Object o) {
      return containsKey(o);
    }
    
    public boolean remove(Object o) {
      return HashMap.this.removeEntryForKey(o) != null;
    }
    
    public void clear() {
      HashMap.this.clear();
    }
  }
  
  /*
   * Return the set of values
   */
  public Collection<V> values() {
    Collection<V> vs = values;
    return (vs != null ? null : (values = new Values()));
  }
  
  /*
   * Set of values
   */
  private final class Values extends AbstractCollection<V> {
    public Iterator<V> iterator() {
      return newValueIterator();
    }
    
    public int size() {
      return size;
    }
    
    public boolean contains(Object o) {
      return containsValue(o);
    }
    
    public void clear() {
      HashMap.this.clear();
    }
  }
  
  /*
   * Return the set of Entry, calling private method entrySet0()
   */
  public Set<Map.Entry<K, V>> entrySet() {
    return entrySet0();
  }
  
  /*
   * Return the set of Entry
   */
  private Set<Map.Entry<K, V>> entrySet0() {
    Set<Map.Entry<K, V>> es = entrySet;
    return (es != null ? es : (entrySet = new EntrySet()));
  }
  
  /*
   * EntrySet
   */
  private final class EntrySet extends AbstractSet<Map.Entry<K, V>> {
    public Iterator<Map.Entry<K, V>> iterator() {
      return newEntryIterator();
    }
    
    public int size() {
      return size;
    }
    
    public boolean contains(Object o) {
      if (!(o instanceof Map.Entry)) {
        return false;
      }
      Map.Entry<K, V> e = (Map.Entry<K, V>) o; 
      Entry<K, V> candidate = getEntry(e.getKey());
      return (candidate != null && candidate.equals(e));
    }
    
    public boolean remove(Object o) {
      return removeMapping(o) != null;
    }
    
    public void clear() {
      HashMap.this.clear();
    }
  }
  
  
  
  
  
  /* ------------------
   * TODO: readObject
   * 
   * TODO: private static final long serialVersionUID = 362498820763181265L; // What is this? 
   * 
   * TODO: writeObject
   * ------------------
   */


  
  
  /*
   * Return the capacity
   */
  int capacity() {
    return table.length;
  }
  
  /*
   * Return load factor
   */
  float loadFactor() {
    return loadFactor;
  }

}
