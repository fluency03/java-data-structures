/**
 * Class:  SingleLinkedList
 * Author: Chang LIU
 *
 */

package linkedlist;

import java.util.Iterator;
import static java.lang.System.out;

public class SinglyLinkedList<T> implements Iterable<T> {

  // the head of the list
  private ListNode<T> head;
  // the tail of the list, dummy node
  private ListNode<T> dummy = new ListNode<>(null);
  // the length of the list
  private int length = 0;

  // @SuppressWarnings("unchecked")
  public SinglyLinkedList() {
    head = dummy;
  }

  /*
   *  Return the head of list
   */
  public ListNode<T> getHead() {
    return head;
  }

  /*
   *  Return the length of list
   */
  public int size() {
    return length;
  }

  /*
   *  Check Empty
   */
  public boolean isEmpty() {
    return length == 0;
  }

  /*
   *  Clear the whole list
   */
  public void clearList() {
    head = dummy;
    length = 0;
  }

  /*
   *  Return the head of list
   */
  public T peek() {
    return head.getData();
  }

  /*
   * Look at the data at certain position
   */
  public T get(int position) {
    if (position < 0 || position >= length) {
      throw new IndexOutOfBoundsException("Position " + position + " is out of bounds!");
    }

    if (isEmpty()) {
      out.println("The list is empty");
      return null;
    } else {
      ListNode<T> tempNode = head;
      int index = position;
      while(index > 0) {
        tempNode = tempNode.getNext();
        index --;
      }

      return tempNode.getData();
    }
  }

  /*
   * Set at the data at certain position
   */
  public void set(int position, T data) {
    if (position < 0 || position >= length) {
      throw new IndexOutOfBoundsException("Position " + position + " is out of bounds!");
    }

    if (isEmpty()) {
      out.println("The list is empty");
    } else {
      ListNode<T> tempNode = head;
      int index = position;
      while(index > 0) {
        tempNode = tempNode.getNext();
        index --;
      }
      tempNode.setData(data);
    }
  }

  /*
   *  Return the position of first data appeared.
   */
  public int indexOf(T data) {
    if (data == null) {
      throw new NullPointerException("The data is null!");
    }

    if (isEmpty()) {
      out.println("The list is empty");
      return -1;
    }

    ListNode<T> tempNode = head;
    int position = 0;
    while (!tempNode.isDummy() || tempNode.getData() != data) {
      position ++;
      tempNode = tempNode.getNext();
    }

    if (tempNode.isDummy()) {
      return -1;
    } else {
      return position;
    }

  }

  /*
   * Check whether the linked list contains the specific element
   */
  public boolean contains(T data) {
    if (indexOf(data) == -1) {
      return false;
    } else {
      return true;
    }
  }

  /**
   * --------------------------------
   * Insert node with several methods
   * --------------------------------
   */
  /*
   *  Insert a node at beginning of the list
   */
  public void insertAtBegin(T data) {
    if (data == null) {
      throw new NullPointerException("The data is null!");
    }

    ListNode<T> newNode = new ListNode<T>(data);
    newNode.setNext(head);
    head = newNode;
    length ++;
  }

  /*
   *  Insert a node at the end of the list
   */
  public void insertAtEnd(T data) {
    if (data == null) {
      throw new NullPointerException("The data is null!");
    }

    if (isEmpty()) {
      insertAtBegin(data);
    } else {
      ListNode<T> tempNode = head;
      while (!tempNode.getNext().isDummy())  {
        tempNode = tempNode.getNext();
      }
      tempNode.add(data);
      length ++;
    }
  }

  /*
   *  Insert a data at a specified position
   */
  public void insert(T data, int position) {
    if (data == null) {
      throw new NullPointerException("The data is null!");
    }

    // Check the position
    if (position < 0 || position >= length) {
      throw new IndexOutOfBoundsException("Position " + position + " is out of bounds!");
    }

    if (isEmpty() || position == 0) {
      insertAtBegin(data);
    } else {
      ListNode<T> tempNode = head;
      int index = position;
      while(index > 1) {
        tempNode = tempNode.getNext();
        index --;
      }
      tempNode.add(data);
      length ++;
    }
  }


  /**
   * --------------------------------
   * Remove node with several methods
   * --------------------------------
   */
  /*
   *  Remove a node from the begin
   */
  public T removeFirst() throws DummyNodeException {
    if (isEmpty()) {
      out.println("Nothing to be removed!");
      return null;
    }

    length --;
    return head.delete();
  }

  /*
   *  Remove a node from the end
   */
  public T removeLast() throws DummyNodeException {
    if (isEmpty()) {
      out.println("Nothing to be removed!");
      return null;
    } else if (length == 1) {
      return removeFirst();
    }

    ListNode<T> tempNode = head;
    while (!tempNode.getNext().isDummy())  {
      tempNode = tempNode.getNext();
    }
    length --;
    return tempNode.delete();
  }

  /*
   *  Remove the node at certain position
   */
  public T removeAt(int position) throws DummyNodeException {
    if (position < 0 || position >= length) {
      throw new IndexOutOfBoundsException("Position " + position + " is out of bounds!");
    }

    if (isEmpty()) {
      out.println("Nothing to be removed!");
      return null;
    } else if (position == 0 || length == 1) {
      return removeFirst();
    } else {
      ListNode<T> tempNode = head;
      int index = position;
      while (index > 0){
        tempNode = tempNode.getNext();
        index --;
      }
      length --;
      return tempNode.delete();
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

    private ListNode<T> tempNode = head;

    @Override
    public boolean hasNext() {
      return !tempNode.getNext().isDummy();
    }

    @Override
    public T next() {
      if (hasNext()) {
        tempNode = tempNode.getNext();
        return tempNode.getData();
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
   *  Convert the list to String
   */
  public String toString() {
    StringBuffer sBuffer = new StringBuffer("");
    if (isEmpty()) {
      out.println("The list is empty!");
      return sBuffer.toString();
    }

    ListNode<T> tempNode = head;
    while (!tempNode.isDummy()) {
      sBuffer.append((String)tempNode.getData());
      sBuffer.append(" ");
      tempNode = tempNode.getNext();
    }

    return sBuffer.toString();
  }

  /**
   * Main function
   */
  public static void main(String[] args) {

  }

}
