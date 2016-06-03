/**
 * Class: CircularSingleList
 * Author: Chang LIU
 */

package linkedlist;

import static java.lang.System.out;

public class CircularSinglyList<T> extends LinkedList<T> {

  public CircularSinglyList() {
    head = null;
  }

  /*
   *  Clear the whole list
   */
  public void clearList() {
    head = null;
    size = 0;
  }

  /*
   *  Look at the data at certain position
   */
  public T get(int position) {
    if (position < 0 || position >= size) {
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
    if (position < 0 || position >= size) {
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
    ListNode<T> temp = head;
    int position = 0;

    if (size == 0) {
      out.println("The list is empty");
      return -1;
    }

    while (temp.getNext() != head) {
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
   *  Insert a node at the begin of the list
   */
  public void insertAtBegin(T data) {
    ListNode<T> newNode = new ListNode<>(data);

    if (size == 0) {
      head = newNode;
      newNode.setNext(newNode);
    } else {
      ListNode<T> temp = head;
      while (temp.getNext() != head)  {
        temp = temp.getNext();
      }
      temp.setNext(newNode);
      newNode.setNext(head);
      head = newNode;
    }
    size ++;
  }

  /*
   *  Insert a data at the end of the list
   */
  public void insertAtEnd(T data) {
    ListNode<T> newNode = new ListNode<>(data);

    if (size == 0) {
      head = newNode;
      newNode.setNext(newNode);
    } else {
      ListNode<T> temp = head;
      while (temp.getNext() != head)  {
        temp = temp.getNext();
      }
      temp.setNext(newNode);
      newNode.setNext(head);
    }
    size ++;
  }

  /*
   *  Insert a data at a specified position
   */
  public boolean insert(T data, int position ) {
    // Check the position
    if (position < 0 || position >= size) {
      out.println("The position " + position +" is out of range! " + "The size is " + this.size + "!");
      return false;
    }

    ListNode<T> newNode = new ListNode<>(data);
    if (size == 0) {
      head = newNode;
      newNode.setNext(newNode);
    } else if (position == 0) {
      ListNode<T> temp = head;
      while (temp.getNext() != head)  {
        temp = temp.getNext();
      }
      temp.setNext(newNode);
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

    size ++;
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
    if (size == 0) {
      out.println("Nothing to be removed!");
      return null;
    }

    ListNode<T> temp = head;
    if (temp.getNext() == head) {
      head = null;
      size --;
      return temp.getData();
    } else {
      ListNode<T> stored = head;
      while (temp.getNext() != head)  {
        temp = temp.getNext();
      }
      temp.setNext(head.getNext());
      head = temp.getNext();
      size --;
      return stored.getData();
    }

  }

  /*
   *  Remove a node from the end
   */
  public T removeLast() {
    if (size == 0) {
      out.println("Nothing to be removed!");
      return null;
    }

    ListNode<T> temp = head;
    ListNode<T> next = temp.getNext();
    ListNode<T> q = temp;
    if (next == head) {
      head = null;
      size --;
      return temp.getData();
    } else {
      while ((next = temp.getNext()) != head)  {
        q = temp;
        temp = next;
      }
      q.setNext(head);
      size --;
      return temp.getData();
    }
  }

  /*
   *  Remove the node at certain position
   */
  public T removeFrom(int position) {
    if (position < 0 || position >= size) {
      out.println("The position " + position +" is out of range! " + "The size is " + this.size + "!");
      return null;
    }

    ListNode<T> temp = head;
    ListNode<T> removedNode = temp.getNext();
    if (size == 0) {
      out.println("Nothing to be removed!");
      return null;
    } else if (position == 0) {
      head = head.getNext();
      size --;
      return temp.getData();
    } else {
      for (int i=1; i<position; i++){
        temp = temp.getNext();
        removedNode = temp.getNext();
      }
      temp.setNext(removedNode.getNext());
      size --;
      return removedNode.getData();
    }
  }

  /*
   *  Convert the list to String
   */
  public String toString() {
    String str = "";
    if (size == 0) {
      out.println("The list is empty!");
      return str;
    }

    ListNode<T> temp = head;
    ListNode<T> p;
    str = str + temp.getData();
    while ((p = temp.getNext()) != head) {
      str = str + ", " + p.getData();
      temp = temp.getNext();
    }

    return str;
  }




}
