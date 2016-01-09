/**
 * Class: CircularSingleList
 * Author: Chang LIU
 */

package linkedlist;

import static java.lang.System.out;

public class CircularSingleList<T> {

  private ListNode<T> nil = null; // the sentinel of the circular list
  private int length = 0; // the length of the circular list
  
  public CircularSingleList() { }
  
  public CircularSingleList(T data) {
    ListNode<T> newNode = new ListNode<>(data);
    newNode.setNext(newNode);
    nil = newNode;
    length = 1;
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
