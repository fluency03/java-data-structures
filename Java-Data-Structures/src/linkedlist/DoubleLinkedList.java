/**
 * Class: DoubleLinkedList
 * Author: Chang LIU
 */

package linkedlist;

public class DoubleLinkedList<T> {

  private DoubleListNode<T> head = null;
  private DoubleListNode<T> tail = null;
  private int length = 0;
  
  public DoubleLinkedList() { }
  
  public DoubleLinkedList(T data) { 
    DoubleListNode<T> newNode = new DoubleListNode<>(data);
    head = newNode;
    tail = newNode;
    length = 1;
  }
  
  // Return the head of list
  public DoubleListNode<T> getHead() {
    if (length == 0) {
      System.out.println("The list is empty");
    }
    return head;
  }
  
  // Return the head of list
  public DoubleListNode<T> getTail() {
    if (length == 0) {
      System.out.println("The list is empty");
    }
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
  
  // Look at the data at certain position
  public T peekAt(int position) {
    if (position < 0 || position >= length) {
      System.out.println("The postion " + position + " is out of range! " + "The length is " + this.length + "!");
      return null;
    }
    
    DoubleListNode<T> temp = head;
    if (length == 0) {
      System.out.println("The list is empty");
      return null;
    } else {
      for (int i=0; i<position; i++){
        temp = temp.getNext();
      }
      return temp.getData();
    }
  }
  
  
  /**
   * --------------------------------
   * Insert node with several methods
   * --------------------------------
   */
  // Insert a node at the front of the list
  public void insertAtBegin(T data) {
    DoubleListNode<T> newNode = new DoubleListNode<>(data);
    
    if (length == 0) {
      head = newNode;
      tail = newNode;
    } else {
      newNode.setNext(head);
      head.setPrev(newNode);
      head = newNode;
    } 
    length ++;
    
  }
  
  // Insert a node at the end of the list
  public void insertAtEnd(T data) {
    DoubleListNode<T> newNode = new DoubleListNode<>(data);
    
    if (length == 0) {
      head = newNode;
      tail = newNode;
    } else {
      newNode.setPrev(tail);
      tail.setNext(newNode);
      tail = newNode;
    }
    length ++;
    
  }
  
  // Insert a node at certain position 
  public boolean insert(T data, int position) {
    // Check the position
    if (position < 0 || position >= length) {
      System.out.println("The position " + position +" is out of range! " + "The length is " + this.length + "!");
      return false;
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
    return true;
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
    if (position < 0 || position >= length) {
      System.out.println("The position " + position +" is out of range! " + "The length is " + this.length + "!");
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
