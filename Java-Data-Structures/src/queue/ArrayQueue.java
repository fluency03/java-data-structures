/**
 * Class: ArrayQueue
 * Author: Chang LIU
 */

package queue;

import static java.lang.System.out;

import linkedlist.ListNode;

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
   * Enqueue a data into the tail
   */
  public void enqueue(T data) {
    if (!full) {
      array[tail = ((++tail) % array.length) ] = data;
    }
    if (head == tail) {
      full = true;
    }
  }

  /*
   * Dequeue a data from the head
   */
  public T dequeue() {
    if ((head == tail) && !full) {
      return null;
    } else if (full == true) {
      full = false;
    }
    T removed = array[head];
    array[head] = null;
    head = (++head) % array.length;
    return (removed);
  }

  /*
   * Return the head data
   */
  public T getHead() {
    return array[head];
  }

  /*
   * Return the tail data
   */
  public T getTail() {
    return array[tail];
  }

  /*
   *  Check Empty
   */
  public boolean isEmpty() {
    return ((head == tail) && !full);
  }

  /*
   * Return the length of the queue
   */
  public int getLength() {
    if (full) {
      return array.length;
    } else if (head == tail) {
      return 0;
    } else if (tail >= head) {
      return (tail - head);
    } else {
      return (array.length - head + tail);
    }
  }

  /*
   * Convert the queue into a String
   */
  public String toString() {
    String str = "";

    int count = head;
    while (array[count] != null) {
      str = str + array[count];
      count = (++count) % array.length;
    }

    return str;
  }

























}
