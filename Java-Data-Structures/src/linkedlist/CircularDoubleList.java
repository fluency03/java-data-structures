/**
 * Class: CircularDoubleList
 * Author: Chang LIU
 */

package linkedlist;

import static java.lang.System.out;

public class CircularDoubleList<T> {

  private DoubleListNode<T> head = null; // the sentinel of the circular list
  private int length = 0; // the length of the circular list
  
  public CircularDoubleList() { }
  
  public CircularDoubleList(T data) {
    DoubleListNode<T> newNode = new DoubleListNode<>(data);
    newNode.setNext(newNode);
    newNode.setPrev(newNode);
    head = newNode;
    length = 1;
  }
  
  // Return the head of list
  public DoubleListNode<T> getHead() {
    if (length == 0) {
      out.println("The list is empty");
    }
    return head;
  }
  
  // Return the length of list
  public int getLength() {
    return length;
  }
  
  // Check Empty
  public boolean isEmpty() {
    return length == 0;
  }
  
  // Clear the whole list
  public void clearList() {
    head = null;
    length = 0;
  }
  
  // Look at the data at certain position
  public T peekAt(int position) {
    if (position < 0 || position >= length) {
      out.println("The postion " + position + " is out of range! " + "The length is " + this.length + "!");
      return null;
    }
    
    DoubleListNode<T> temp = head;
    if (length == 0) {
      out.println("The list is empty");
      return null;
    } else {
      for (int i=0; i<position; i++){
        temp = temp.getNext();
      }
      return temp.getData();
    }
  }
  
  // Return the position of first data appeared.
  public int getPosition(T data) {
    DoubleListNode<T> temp = head;
    int position = 0;
    
    if (length == 0) {
      out.println("The list is empty");
      return -1;
    }
    
    while (temp != null) {
      if (temp.getData() == data) {
        return position;
      }
      position ++;
      temp = temp.getNext();
    }
    
    // Return Integer.MIN_VALUE if not found
    out.println("The data " + data + " is not found!");
    return -1;
    
  }
  
  /**
   * --------------------------------
   * Insert node with several methods
   * --------------------------------
   */
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
