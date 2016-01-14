/**
 * Class: ArrayQueue
 * Author: Chang LIU
 */

package queue;

//import static java.lang.System.out;

public class ArrayQueue<T> {
	
  private T[] array;
  private int head = 0;
  private int tail = 0;
  private boolean full = false;
  
  public ArrayQueue(int size) {
    // @SuppressWarnings("unchecked")
  	array = (T[])new Object[size];
	}
  
  /*
   *  Check Empty
   */
  public boolean isEmpty() {
    return ((head == tail) && !full);
  }
  
  
  
  
  
}
