/**
 * Class:  SingleLinkedList
 * Author: Chang LIU
 *
 */

package linkedlist;

import static java.lang.System.out;

public class SinglyLinkedList<T> {

  // the head of the list, dummy node
  private ListNode<T> head = new ListNode<>(null);
  // the tail of the list, dummy node
  private ListNode<T> tail = new ListNode<>(null);
  // the length of the list
  private int length = 0;

  public SinglyLinkedList() {
    head.setNext(tail);
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
  public int getLength() {
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
    head.setNext(tail);
    length = 0;
  }

  /*
   * Look at the data at certain position
   */
  public T get(int position) {
    if (position < 0 || position >= length) {
      throw new IndexOutOfBoundsException("Position " + position + " is out of bounds!");
    }

    if (length == 0) {
      out.println("The list is empty");
      return null;
    } else {
      ListNode<T> tempNode = head;
      int index = position;
      while(index >= 0) {
        tempNode = tempNode.getNext();
        index --;
      }

      return tempNode.getData();
    }
  }

  /*
   *  Return the position of first data appeared.
   */
  public int indexOf(T data) {
    int position = 0;

    if (length == 0) {
      out.println("The list is empty");
      return -1;
    }

    ListNode<T> temp = head.getNext();
    while (temp.getData() != null || temp.getData() != data) {
      position ++;
      temp = temp.getNext();
    }

    if (temp.getData() == null) {
      // Return Integer.MIN_VALUE if not found
      out.println("The data " + data + " is not found!");
      return -1;
    } else {
      return position;
    }

  }

  /*
   * Check whether the linked list contains the specific element
   */
  public boolean contains(T data) {
    ListNode<T> temp = head.getNext();
    while (temp.getData() != null || temp.getData() != data) {
      temp = temp.getNext();
    }

    if (temp.getData() == null) {
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
    head.add(data);
    length ++;
  }

  /*
   *  Insert a node at the end of the list
   */
  public void insertAtEnd(T data) {
    if (length == 0) {
      head.add(data);
    } else {
      ListNode<T> temp = head;
      while (temp.getNext().getData() != null)  {
        temp = temp.getNext();
      }
      temp.add(data);
    }

    length ++;
  }

  /*
   *  Insert a data at a specified position
   */
  public void insert(T data, int position) throws IndexOutOfBoundsException {
    // Check the position
    if (position < 0 || position >= length) {
      throw new IndexOutOfBoundsException("Position " + position + " is out of bounds!");
    }

    if (length == 0 || position == 0) {
      head.add(data);
    } else {
      ListNode<T> temp = head;
      int index = position;
      while(index > 0) {
        temp = temp.getNext();
        index --;
      }
      temp.add(data);
    }

    length ++;
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
    if (length == 0) {
      out.println("Nothing to be removed!");
      return null;
    }

    ListNode<T> temp = head.getNext();
    length --;
    return temp.delete();
  }

  /*
   *  Remove a node from the end
   */
  public T removeLast() throws DummyNodeException {
    if (length == 0) {
      out.println("Nothing to be removed!");
      return null;
    }

    ListNode<T> temp = head;
    if (temp.getNext().getData() == null) {
      return null;
    } else {
      while (temp.getNext().getData() != null)  {
        temp = temp.getNext();
      }
      length --;
      return temp.delete();
    }
  }

  /*
   *  Remove the node at certain position
   */
  public T removeAt(int position) throws DummyNodeException {
    if (position < 0 || position >= length) {
      throw new IndexOutOfBoundsException("Position " + position + " is out of bounds!");
    }

    ListNode<T> temp = head;
    int index = position;
    if (length == 0) {
      out.println("Nothing to be removed!");
      return null;
    } else if (position == 0) {
      length --;
      return temp.delete();
    } else {
      while (index >= 0){
        temp = temp.getNext();
        index --;
      }
      length --;
      return temp.delete();
    }
  }

  /*
   *  Convert the list to String
   */
  public String toString() {
    StringBuffer sBuffer = new StringBuffer("");
    if (length == 0) {
      out.println("The list is empty!");
      return sBuffer.toString();
    }

    ListNode<T> temp = head;
    while (temp.getNext().getData() != null) {
      sBuffer.append(temp.getNext());
      sBuffer.append(" ");
      temp = temp.getNext();
    }

    return sBuffer.toString();
  }

}
