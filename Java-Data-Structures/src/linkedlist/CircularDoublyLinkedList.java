/**
 * Class: CircularDoubleList
 * Author: Chang LIU
 */

package linkedlist;

import static java.lang.System.out;

public class CircularDoublyLinkedList<T> extends DoublyLinkedList<T>{

  public CircularDoublyLinkedList() {
    super();
    dummy.setNext(dummy);
  }

  /*
   *  Clear the whole list
   */
  @Override
  public void clearList() {
    head = dummy;
    dummy.setNext(dummy);
    size = 0;
  }

  /*
   *  Insert a node at beginning of the list
   */
  @Override
  public void insertAtBegin(T data) {
    if (data == null) {
      throw new NullPointerException("The data is null!");
    }

    DoublyListNode<T> newNode = new DoublyListNode<T>(data);
    newNode.setNext(head);
    dummy.setNext(newNode);
    head = newNode;
    size ++;
  }

  /*
   *  Remove a node from the begin
   */
  @Override
  public T removeFirst() throws DummyNodeException {
    if (isEmpty()) {
      return null;
    }

    DoublyListNode<T> tempNode = head;
    head = head.getNext();
    dummy.setNext(head);
    size --;
    return tempNode.getData();
  }

}
