/**
 * Class: DoubleLinkedList
 * Author: Chang LIU
 */

package linkedlist;

import java.util.Iterator;
import static java.lang.System.out;

public class DoublyLinkedList<T> implements Iterable<T>{

  // the head of the list
  protected DoublyListNode<T> head = null;
  // the tail of the list, dummy node
  protected DoublyListNode<T> dummy = new DoublyListNode<T>();
  // the size of the list
  protected int size = 0;

  public DoublyLinkedList() {
    dummy.setDummy();
    head = dummy;
  }

  /*
   *  Return the head of list
   */
  public DoublyListNode<T> getHead() {
    if (isEmpty()) {
      out.println("The list is empty");
    }
    return head;
  }

  /*
   *  Return the size of list
   */
  public int size() {
    return size;
  }

  /*
   *  Check Empty
   */
  public boolean isEmpty() {
    return (size == 0);
  }

  /*
   *  Clear the whole list
   */
  public void clearList() {
    head = dummy;
    size = 0;
  }

  /*
   *  Return the head of list
   */
  public T peek() {
    if (isEmpty()) {
      return null;
    }
    return head.getData();
  }

  /*
   *  Look at the data at certain position
   */
  public T get(int position) {
    if (position < 0 || position >= size) {
      throw new IndexOutOfBoundsException("Position " + position + " is out of bounds!");
    }

    if (isEmpty()) {
      return null;
    } else {
      DoublyListNode<T> tempNode = head;
      int index = position;
      while(index > 0) {
        tempNode = tempNode.getNext();
        index --;
      }

      return tempNode.getData();
    }
  }

  /*
   *  Return the position of first data appeared.
   */
  public int getPosition(T data) {
    DoublyListNode<T> temp = head;
    int position = 0;

    if (isEmpty()) {
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
  /*
   *  Insert a node at the front of the list
   */
  public void insertAtBegin(T data) {
    DoublyListNode<T> newNode = new DoublyListNode<>(data);

    if (isEmpty()) {
      head = newNode;
      tail = newNode;
    } else {
      newNode.setNext(head);
      head.setPrev(newNode);
      head = newNode;
    }
    size ++;

  }

  /*
   *  Insert a node at the end of the list
   */
  public void insertAtEnd(T data) {
    DoublyListNode<T> newNode = new DoublyListNode<>(data);

    if (isEmpty()) {
      head = newNode;
      tail = newNode;
    } else {
      newNode.setPrev(tail);
      tail.setNext(newNode);
      tail = newNode;
    }
    size ++;

  }

  /*
   *  Insert a node at certain position
   */
  public boolean insert(T data, int position) {
    // Check the position
    if (position < 0 || position >= size) {
      out.println("The position " + position +" is out of range! " + "The size is " + this.size + "!");
      return false;
    }

    DoublyListNode<T> temp = head;
    DoublyListNode<T> newNode = new DoublyListNode<>(data);
    if (isEmpty()) {
      head = newNode;
      tail = newNode;
    } else if (position == 0) {
      newNode.setNext(head);
      head.setPrev(newNode);
      head = newNode;
    } else {
      for (int i=1; i<position; i++){
        temp = temp.getNext();
      }
      newNode.setNext(temp.getNext());
      newNode.setPrev(temp);
      temp.getNext().setPrev(newNode);
      temp.setNext(newNode);
    }

    size ++;
    return true;
  }

  /**
   * --------------------------------
   * Remove node with several methods
   * --------------------------------
   */
  /*
   *  Remove a node from the beginning of the list
   */
  public T removeFirst() {
    if (isEmpty()) {
      out.println("Nothing to be removed!");
      return null;
    } else if (size == 1) {
      DoublyListNode<T> temp = head;
      head = null;
      tail = null;
      size --;
      return temp.getData();
    }

    DoublyListNode<T> temp = head;
    head = head.getNext();
    head.setPrev(null);
    size --;
    return temp.getData();
  }

  /*
   *  Remove a node from the end of the list
   */
  public T removeLast() {
    if (isEmpty()) {
      out.println("Nothing to be removed!");
      return null;
    } else if (size == 1) {
      DoublyListNode<T> temp = head;
      head = null;
      tail = null;
      size --;
      return temp.getData();
    }

    DoublyListNode<T> temp = tail;
    tail = tail.getPrev();
    tail.setNext(null);
    size --;
    return temp.getData();
  }

  /*
   *  Remove a node from certain position
   */
  public T removeFrom(int position) {
    if (position < 0 || position >= size) {
      out.println("The position " + position +" is out of range! " + "The size is " + this.size + "!");
      return null;
    }

    DoublyListNode<T> temp = head;
//    DoublyListNode<T> removedNode = temp.getNext();
    if (isEmpty()) {
      out.println("Nothing to be removed!");
      return null;
    } else if (position == 0) {
      head = head.getNext();
      head.setPrev(null);
      size --;
      return temp.getData();
    } else {
      DoublyListNode<T> removedNode = temp.getNext();
      for (int i=1; i<position; i++){
        temp = temp.getNext();
        removedNode = temp.getNext();
      }
      if (removedNode.getNext() == null) {
        temp.setNext(null);
        tail = temp;
        size --;
        return removedNode.getData();
      }
      temp.setNext(removedNode.getNext());
      removedNode.getNext().setPrev(temp);
      size --;
      return removedNode.getData();
    }
  }

  /*
   * Return the iterator()
   */
  @Override
  public Iterator<T> iterator() {
    return new LinkedListIterator();
  }

  /**
   * Iterable implementation
   */
  private class LinkedListIterator implements Iterator<T> {

    private DoublyListNode<T> tempNode = head;

    @Override
    public boolean hasNext() {
      return !tempNode.isDummy();
    }

    @Override
    public T next() {
      if (hasNext()) {
        T currentData = tempNode.getData();
        tempNode = tempNode.getNext();
        return currentData;
      } else {
        return null;
      }
    }

    @Override
    public void remove() {
       throw new UnsupportedOperationException();
    }
  }

  /*
   * Convert the list into a String
   */
  public String toString() {
    String str = "";
    if (isEmpty()) {
      out.println("The list is empty!");
      return str;
    }

    DoublyListNode<T> temp = head;
    DoublyListNode<T> p;
    str = str + temp.getData();
    while ((p = temp.getNext()) != null) {
      str = str + "," + p.getData();
      temp = temp.getNext();
    }
    return str;
  }


}
