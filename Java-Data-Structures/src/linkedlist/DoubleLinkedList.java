/**
 * Class: DoubleLinkedList
 * Author: Chang LIU
 */

package linkedlist;

public class DoubleLinkedList<T> {

  private DoubleListNode<T> head = null;
  private DoubleListNode<T> tail = null;
  private int length = 0;
  
  public DoubleLinkedList() { 
    head = new DoubleListNode<T>(null,null,null);
    tail = new DoubleListNode<T>(null,head,null);
    head.setNext(tail);
  }
  
  public DoubleLinkedList(DoubleListNode<T> node) { 
    head = new DoubleListNode<T>(null,null,node);
    tail = new DoubleListNode<T>(null,node,null);
    node.setPrev(head);
    node.setNext(tail);
    length = 1;
  }
  
  // Return the head of list
  public DoubleListNode<T> getHead() {
    return head;
  }
  
  // Return the head of list
  public DoubleListNode<T> getTail() {
    return tail;
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
    head = new DoubleListNode<T>(null,null,null);
    tail = new DoubleListNode<T>(null,head,null);
    head.setNext(tail);
    length = 0;
  }
  
  // Insert a node at the front of the list
  public void insertAtBegin() {
    
  }
  
  // Insert a node at the end of the list
  public void insertAtEnd() {
    
  }
  
  // Insert a node at certain position 
  public void insertAt(T data, int position) {
    
  }
  
  
  
  
  
  
  
  
  
  
  
  
}
