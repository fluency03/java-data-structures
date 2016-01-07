/**
 * Class:  SingleLinkedList
 * Author: Chang LIU
 *
 */


package linkedlist;

public class SingleLinkedList<T> {

  private ListNode<T> head = null;
  private ListNode<T> tail = null;
  private int length = 0;
  
  public SingleLinkedList() { }
  
  public SingleLinkedList(ListNode<T> node) {
    head = node;
    tail = node;
  }
  
  // Return the head of list
  public ListNode<T> getHead() {
    return head;
  }
  
  // Return the head of list
  public ListNode<T> getTail() {
    return tail;
  }
  
  // Return the length of list
  public int getLength() {
    return length;
  }
  
  // Insert a node at beginning of the list
  public void insertAtBegin(ListNode<T> node) {
    if (head == null || tail == null) {
      head = node;
      tail = node;
    } else {
      node.setNext(head);
      head = node;
    } 
    
    length ++;
  }

  // Insert a node at the end of the list
  public void insertAtEnd(ListNode<T> node) {
    if (head == null || tail == null) {
      head = node;
      tail = node;
    } else {
      ListNode<T> last = tail;
      last.setNext(node);
      tail = node;
    }
    
    length ++;
  }
  
  public boolean insert(T data, int position ) {
    // Check the position
    if (position < 0 || position > length) {
      System.out.println("The position is out of range! ");
      return false;
    }
    
    if (head == null || tail == null) {
      head = new ListNode<T>(data);
      tail = head;
    } else if (position == 0) {
      ListNode<T> node = new ListNode<>(data);
      node.setNext(head);
      head = node;
    } else {
      ListNode<T> node = head;
      ListNode<T> newNode = new ListNode<>(data);
      
      for (int i=1; i<position; i++) {
        node = node.getNext();
      }
      
      newNode.setNext(node.getNext());
      node.setNext(newNode);
    }
    
    length ++;
    return true;
  }
  
  
  
  
  
  
  
  

}
