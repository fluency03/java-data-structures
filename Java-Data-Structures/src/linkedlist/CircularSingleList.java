/**
 * Class: CircularSingleList
 * Author: Chang LIU
 */

package linkedlist;

public class CircularSingleList<T> {

  private ListNode<T> nil = null;
  private int length = 0;
  
  public CircularSingleList() { }
  
  public CircularSingleList(T data) {
    ListNode<T> newNode = new ListNode<>(data);
    newNode.setNext(newNode);
    nil = newNode;
    length = 1;
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
