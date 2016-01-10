/**
 * Class: LinkedQueue
 * Author: Chang LIU
 */

package queue;

import static java.lang.System.out;
import linkedlist.ListNode;

public class LinkedQueue<T> {

  private ListNode<T> head = null;
  private ListNode<T> tail = null;
  private int length = 0;
  
  public LinkedQueue() { }
  
  public LinkedQueue(T data) {
    ListNode<T> newNode = new ListNode<>(data, null);
    head = newNode;
    tail = newNode;
    length = 1;
  }
  
  // Enqueue a data into the tail
  public void enqueue(T data) {
    ListNode<T> newNode = new ListNode<>(data);
    if (length == 0) {
      head = newNode;
      tail = newNode;
    } else {
      tail.setNext(newNode);
      tail = newNode;
    }
    length ++;
  }
  
  // Dequeue a data from the head
  public T dequeue() {
    if (length == 0) {
      out.println("The queue is empty!");
      return null;
    }
    
    ListNode<T> temp = head;
    head = head.getNext();
    if (head == null) {
      tail = null;
    }
    length --;
    return temp.getData();
  }
  
  // Return the head data
  public T getHead() {
    if (length == 0) {
      out.println("The queue is empty!");
      return null;
    }
    
    return head.getData();
  }
  
  // Return the tail data
  public T getTail() {
    if (length == 0) {
      out.println("The queue is empty!");
      return null;
    }
    
    return tail.getData();
  }
  
  // Check whether the queue is empty
  public boolean isEmpty() {
    return (length == 0);
  }
  
  // Return the length of the queue
  public int getLength() {
    return length;
  }
  
  // Convert the queue into a String
  public String toString() {
    String str = "";
    if (length == 0) {
      out.println("The list is empty!");
      return str;
    }
    
    ListNode<T> temp = head;
    ListNode<T> p;
    str = str + temp.getData();
    while ((p = temp.getNext()) != null) {
      str = str + ", " + p.getData();
      temp = temp.getNext();
    }
    
    return str;
  }

}
