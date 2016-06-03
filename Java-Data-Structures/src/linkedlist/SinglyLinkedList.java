/**
 * Class:  SingleLinkedList
 * Author: Chang LIU
 *
 */

package linkedlist;

import static java.lang.System.out;

public class SinglyLinkedList<T>  extends LinkedList<T>{

  // @SuppressWarnings("unchecked")
  public SinglyLinkedList() {
    super();
  }

  /*
   *  Clear the whole list
   */
  public void clearList() {
    head = dummy;
    size = 0;
  }

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
    size ++;
  }

  /*
   *  Remove a node from the begin
   */
  public T removeFirst() throws DummyNodeException {
    if (isEmpty()) {
      return null;
    }

    ListNode<T> tempNode = head;
    head = head.getNext();
    size --;
    return tempNode.getData();
  }

}
