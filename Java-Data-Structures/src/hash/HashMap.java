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
   * According to source code: 
   * Initialization hook for subclasses. This method is called
   * in all constructors and pseudo-constructors (clone, readObject)
   * after HashMap has been initialized but before any entries have
   * been inserted.  (In the absence of this method, readObject would
   * require explicit knowledge of subclasses.)
   */
  void init() { }
  
  
  /**
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
  
  
  
  
  
  
  
  
  
  
  
	
	
	
	
	
}
