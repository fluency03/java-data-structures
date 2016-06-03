/**
 * Class: CircularDoubleList
 * Author: Chang LIU
 */

package linkedlist;

import static java.lang.System.out;

public class CircularDoublyList<T> {

  private DoubleListNode<T> head = null; // the sentinel of the circular list
  private int length = 0; // the length of the circular list

  public CircularDoubleList() { }

  public CircularDoubleList(T data) {
    DoubleListNode<T> newNode = new DoubleListNode<>(data);
    newNode.setNext(newNode);
    newNode.setPrev(newNode);
    head = newNode;
    length = 1;
  }

  /*
   *  Return the head of list
   */
  public DoubleListNode<T> getHead() {
    if (length == 0) {
      out.println("The list is empty");
    }
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
    return (length == 0);
  }

  /*
   *  Clear the whole list
   */
  public void clearList() {
    head = null;
    length = 0;
  }

  /*
   *  Look at the data at certain position
   */
  public T peekAt(int position) {
    if (position < 0 || position >= length) {
      out.println("The postion " + position + " is out of range! " + "The length is " + this.length + "!");
      return null;
    }

    DoubleListNode<T> temp = head;
    if (length == 0) {
      out.println("The list is empty");
      return null;
    } else {
      for (int i=0; i<position; i++){
        temp = temp.getNext();
      }
      return temp.getData();
    }
  }

  /*
   *  Return the position of first data appeared.
   */
  public int getPosition(T data) {
    DoubleListNode<T> temp = head;
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

    /*
     *  Return Integer.MIN_VALUE if not found
     */
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
    DoubleListNode<T> newNode = new DoubleListNode<>(data);

    if (length == 0) {
      newNode.setNext(newNode);
      newNode.setPrev(newNode);
      head = newNode;
    } else {
      newNode.setNext(head);
      newNode.setPrev(head.getPrev());
      head.getPrev().setNext(newNode);
      head.setPrev(newNode);
      head = newNode;
    }
    length ++;

  }

  /*
   *  Insert a node at the end of the list
   */
  public void insertAtEnd(T data) {
    DoubleListNode<T> newNode = new DoubleListNode<>(data);

    if (length == 0) {
      newNode.setNext(newNode);
      newNode.setPrev(newNode);
      head = newNode;
    } else {
      newNode.setNext(head);
      newNode.setPrev(head.getPrev());
      head.getPrev().setNext(newNode);
      head.setPrev(newNode);
    }
    length ++;

  }

  /*
   *  Insert a node at certain position
   */
  public boolean insert(T data, int position) {
    // Check the position
    if (position < 0 || position >= length) {
      out.println("The position " + position +" is out of range! " + "The length is " + this.length + "!");
      return false;
    }

    DoubleListNode<T> temp = head;
    DoubleListNode<T> newNode = new DoubleListNode<>(data);
    if (length == 0) {
      newNode.setNext(newNode);
      newNode.setPrev(newNode);
      head = newNode;
    } else {
      for (int i=0; i<position; i++){
        temp = temp.getNext();
      }
      newNode.setNext(temp);
      newNode.setPrev(temp.getPrev());
      temp.getPrev().setNext(newNode);
      temp.setPrev(newNode);
      if (position == 0) {
        head = newNode;
      }
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
   *  Remove a node from the beginning of the list
   */
  public T removeFirst() {
    if (length == 0) {
      out.println("Nothing to be removed!");
      return null;
    } else if (length == 1) {
      DoubleListNode<T> temp = head;
      head = null;
      length --;
      return temp.getData();
    }

    DoubleListNode<T> temp = head;
    head.getNext().setPrev(head.getPrev());
    head.getPrev().setNext(head.getNext());
    head = head.getNext();
    length --;
    return temp.getData();
  }

  /*
   *  Remove a node from the end of the list
   */
  public T removeLast() {
    if (length == 0) {
      out.println("Nothing to be removed!");
      return null;
    } else if (length == 1) {
      DoubleListNode<T> temp = head;
      head = null;
      length --;
      return temp.getData();
    }

    DoubleListNode<T> temp = head.getNext();
    head.setPrev(temp.getPrev());
    temp.getPrev().setNext(head);
    length --;
    return temp.getData();
  }


  /*
   *  Remove a node from certain position
   */
  public T removeFrom(int position) {
    if (position < 0 || position >= length) {
      out.println("The position " + position +" is out of range! " + "The length is " + this.length + "!");
      return null;
    }

    DoubleListNode<T> temp = head;
    if (length == 0) {
      out.println("Nothing to be removed!");
      return null;
    } else if (length == 1) {
      head = null;
      length --;
      return temp.getData();
    } else {
      for (int i=0; i<position; i++) {
        temp = temp.getNext();
      }
      temp.getPrev().setNext(temp.getNext());
      temp.getNext().setPrev(temp.getPrev());
      if (position == 0) {
        head = temp.getNext();
      }
      length --;
      return temp.getData();
    }
  }

  /*
   * Convert the list into a String
   */
  public String toString() {
    String str = "";
    if (length == 0) {
      out.println("The list is empty!");
      return str;
    }

    DoubleListNode<T> temp = head;
    DoubleListNode<T> p;
    str = str + temp.getData();
    while ((p = temp.getNext()) != head) {
      str = str + "," + p.getData();
      temp = temp.getNext();
    }
    return str;
  }

}
