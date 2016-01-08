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
  
  /**
   * --------------------------------
   * Insert node with several methods
   * --------------------------------
   */
  // Insert a node at the front of the list
  public void insertAtBegin(DoubleListNode<T> node) {
    node.setPrev(head);
    node.setNext(head.getNext());
    node.getNext().setPrev(node);
    head.setNext(node);
    length ++;
  }
  
  // Insert a node at the end of the list
  public void insertAtEnd(DoubleListNode<T> node) {
    tail.getPrev().setNext(node);
    node.setPrev(tail.getPrev());
    node.setNext(tail);
    tail.setPrev(node);
    length ++;
  }
  
  // Insert a node at certain position 
  public void insertAt(T data, int position) {
    if (position < 0 || position >length) {
      System.out.println("The postion is out of range!");
      return;
    }
    
    DoubleListNode<T> temp = head;
    DoubleListNode<T> newNode = new DoubleListNode<>(data);
    if (length == 0) {
      head.setNext(newNode);
      newNode.setPrev(head);
      newNode.setNext(tail);
      tail.setPrev(newNode);
    } else if (position == 0) {
      newNode.setPrev(head);
      newNode.setNext(head.getNext());
      newNode.getNext().setPrev(newNode);
      head.setNext(newNode);
    } else {
      for (int i=1; i<position; i++){
        temp = temp.getNext();
      }
      
      newNode.setPrev(temp);
      newNode.setNext(temp.getNext());
      newNode.getNext().setPrev(newNode);
      temp.setNext(newNode);
    }
    
    length ++;
  }
  
  /**
   * --------------------------------
   * Remove node with several methods
   * --------------------------------
   */
  // Remove a node from the beginning of the list
  public void removeFirst() {
    if (length == 0) {
      System.out.println("Nothing to be removed!");
      return;
    }
    
    DoubleListNode<T> temp = head.getNext();
    head.setNext(temp.getNext());
    temp.getNext().setPrev(head);
    length --;
  }
  
  // Remove a node from the end of the list
  public void removeLast() {
    if (length == 0) {
      System.out.println("Nothing to be removed!");
      return;
    }
    
    DoubleListNode<T> temp = tail.getPrev();
    tail.setPrev(temp.getPrev());
    temp.getPrev().setNext(tail);
    length --;     
  }
  
  // Remove a node from certain position
  public void removeFrom(int position) {
    if (position < 0 || position >length) {
      System.out.println("The postion is out of range!");
      return;
    }
    
    DoubleListNode<T> temp = head;
    if (length == 0) {
      System.out.println("Nothing to be removed!");
      return;
    } else if (position == 0) {
      head.setNext(temp.getNext().getNext());
      temp.getNext().getNext().setPrev(head);
    } else {
      for (int i=1; i<position; i++){
        temp = temp.getNext();
      }
      temp.getNext().setPrev(temp.getPrev());
      temp.getPrev().setNext(temp.getNext());
    }
    
    length --;   
  }
  
  public String toString() {
    String str = "";
    if (length == 0) {
      System.out.println("The list is empty!");
      return str;
    }
    
    DoubleListNode<T> temp = head;
    DoubleListNode<T> p;
    str = str + temp.getData();
    while ((p = temp.getNext()) != null) {
      str = str + "," + p.getData();
      temp = temp.getNext();
    }
    return str;
  }
  
  
  
  
  
}
