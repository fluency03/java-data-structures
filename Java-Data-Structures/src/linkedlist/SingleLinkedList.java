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
    head.setNext(node);
    node.setNext(tail);
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
  
  // Check Empty
  public boolean isEmpty() {
    return length == 0;
  }
  
  // Clear the whole list
  public void clearList() {
    head = null;
    tail = null;
    length = 0;
  }

  
  /**
   * Insert node with several methods
   */
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
  
  // Insert a data at a specified position
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
  
  
  /**
   * Remove node with several methods
   */
  // Remove a node from the begin
  public ListNode<T> removeFromBegin() {
    if (head == null || tail == null) {
      return null;
    }
    
    ListNode<T> node = head;
    head = node.getNext();
    node.setNext(null);
       
    length --;
    return node;
  }
  
  // Remove a node from the end
  public ListNode<T> removeFromEnd() {
    if (head == null || tail == null) {
      return null;
    }
    
    ListNode<T> first = head;
    ListNode<T> temp = null;
    
    while ((temp = first.getNext()) != null)  {
      first = first.getNext();
    }
    
    length --;
    return temp; 
  }
  
  // Remove the node at certain position
  public ListNode<T> remove(int position) {
    if (position < 0 || position >length) {
      System.out.println("The postion is out of range!");
      return null;
    }
    
    ListNode<T> temp = head;
    ListNode<T> removedNode = head;
    if (head == null || tail == null) {
      return null;
    } else if (position == 0) {
      head = head.getNext();
    } else {
      for (int i=1; i<position; i++){
        temp = temp.getNext();
      }
      removedNode = temp.getNext();
      removedNode.setNext(null);
      temp.setNext(temp.getNext().getNext());
    }
    
    length --;
    return removedNode;
  }
  
  // Look at the data at certain position
  public T peekAt(int position) {
    if (position < 0 || position >length) {
      System.out.println("The postion is out of range!");
      return null;
    }
    
    ListNode<T> temp = head;
    T returnedData = null;
    if (head == null || tail == null) {
      return null;
    } else if (position == 0) {
      returnedData = head.getData();
    } else {
      for (int i=1; i<position; i++){
        temp = temp.getNext();
      }
      returnedData = temp.getData();
    }

    return returnedData;
  }
  
  // Return the position of first data appeared.
  public int getPosition(T data) {
    ListNode<T> temp = head;
    int position = 0;
    
    while (temp != null) {
      if (temp.getData() == data) {
        return position;
      }
      position ++;
      temp = temp.getNext();
    }
    
    // Return Integer.MIN_VALUE if not found
    return Integer.MIN_VALUE;
    
  }
  
  // Convert the list to String
  public String toString() {
    String str = "";
    if (head == null || tail == null) {
      return str;
    }
    
    ListNode<T> temp = head;
    ListNode<T> q;
    str = str + temp.getData();
    while ((q = temp.getNext()) != null) {
      str = str + "," + q.getData();
      temp = temp.getNext();
    }
    
    return str;
  }
  
}
