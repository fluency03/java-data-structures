/**
 * Class: DoublyListNode
 * Author: Chang LIU
 */

package linkedlist;

public class DoublyListNode<T> {

  private DoublyListNode<T> prev = null;
  private DoublyListNode<T> next = null;
  private T data = null;

  public DoublyListNode () { }

  public DoublyListNode (T data) {
    this.data = data;
  }

  /*
   * Add a new node after the current node
   * Time Complexity: O(1)
   */
  public void add(T data) {
    DoublyListNode<T> newNode = new DoublyListNode<T>(data);
    if (next == null) {
      this.next = newNode;
      newNode.setPrev(this);
    } else {
      DoublyListNode<T> nextNode = this.next;
      this.next = newNode;
      newNode.setPrev(this);
      newNode.setNext(nextNode);
      nextNode.setPrev(newNode);
    }
  }

  /*
   * Delete the next node of current node
   * Time Complexity: O(1)
   */
  public T delete() {
    if (this.prev == null && this.next == null) {
      throw new UnsupportedOperationException("Prev and Next are both null.");
    } else if (this.prev == null) {
      this.next.setPrev(null);
    } else if (this.next == null) {
      this.prev.setNext(null);
    } else {
      this.next.setPrev(this.prev);
      this.prev.setNext(this.next);
    }

    return this.data;
  }

  /*
   *  Obtain the node's data
   */
  public T getData(){
    return data;
  }

  /*
   *  Set the node's data
   */
  public void setData(T data) {
    this.data = data;
  }

  /*
   *  Return the previous node
   */
  public DoublyListNode<T> getPrev(){
    return prev;
  }

  /*
   *  Set previous node
   */
  public void setPrev(DoublyListNode<T> prev) {
    this.prev = prev;
  }

  /*
   *  Return the next node
   */
  public DoublyListNode<T> getNext(){
    return next;
  }

  /*
   *  Set the next node
   */
  public void setNext(DoublyListNode<T> next) {
    this.next = next;
  }

  /*
   *  Convert the data into String
   */
  public String toString() {
    String str = "";
    return str + data;
  }


}
