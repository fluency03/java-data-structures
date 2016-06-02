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
  public T peekAt(int position) {
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
  public int getPosition(T data) {
    ListNode<T> temp = head;
    int position = 0;

    if (length == 0) {
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
   *  Insert a node at beginning of the list
   */
  public void insertAtBegin(T data) {
    ListNode<T> newNode = new ListNode<>(data);

    if (length == 0) {
      head = newNode;
    } else {
      newNode.setNext(head);
      head = newNode;
    }
    length ++;
  }

  /*
   *  Insert a node at the end of the list
   */
  public void insertAtEnd(T data) {
    ListNode<T> newNode = new ListNode<>(data);

    if (length == 0) {
      head = newNode;
    } else {
      ListNode<T> temp = head;
      while (temp.getNext() != null)  {
        temp = temp.getNext();
      }
      temp.setNext(newNode);
    }
    length ++;
  }

  /*
   *  Insert a data at a specified position
   */
  public boolean insert(T data, int position) throws IndexOutOfBoundsException {
    // Check the position
    if (position < 0 || position >= length) {
      throw new IndexOutOfBoundsException("Position " + position + " is out of bounds!");
    }

    ListNode<T> newNode = new ListNode<>(data);
    if (length == 0) {
      head = newNode;
    } else if (position == 0) {
      newNode.setNext(head);
      head = newNode;
    } else {
      ListNode<T> temp = head;
      for (int i=1; i<position; i++) {
        temp = temp.getNext();
      }
      newNode.setNext(temp.getNext());
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
  /*
   *  Remove a node from the begin
   */
  public T removeFirst() {
    if (length == 0) {
      out.println("Nothing to be removed!");
      return null;
    }

    ListNode<T> temp = head;
    head = head.getNext();
    length --;
    return temp.getData();
  }

  /*
   *  Remove a node from the end
   */
  public T removeLast() {
    if (length == 0) {
      out.println("Nothing to be removed!");
      return null;
    }

    ListNode<T> temp = head;
    ListNode<T> next = temp.getNext();
    ListNode<T> q = temp;
    if (next == null) {
      head = null;
      length --;
      return temp.getData();
    } else {
      while ((next = temp.getNext()) != null)  {
        q = temp;
        temp = next;
      }
      q.setNext(null);
      length --;
      return temp.getData();
    }
  }

  /*
   *  Remove the node at certain position
   */
  public T removeFrom(int position) {
    if (position < 0 || position >= length) {
      throw new IndexOutOfBoundsException("Position " + position + " is out of bounds!");
    }

    ListNode<T> temp = head;
    ListNode<T> removedNode = temp.getNext();
    if (length == 0) {
      out.println("Nothing to be removed!");
      return null;
    } else if (position == 0) {
      head = head.getNext();
      length --;
      return temp.getData();
    } else {
      for (int i=1; i<position; i++){
        temp = temp.getNext();
        removedNode = temp.getNext();
      }
      temp.setNext(removedNode.getNext());
      length --;
      return removedNode.getData();
    }
  }

  /*
   *  Convert the list to String
   */
  public String toString() {
    String str = "";
    if (length == 0) {
      out.println("The list is empty!");
      return str;
    }

    ListNode<T> temp = head;
    ListNode<T> p;
    str = str + temp.getData();
    while ((p = temp.getNext()) != null) {
      str = str + ", " + p.getData();
      temp = temp.getNext();
    }

    return str;
  }

}
