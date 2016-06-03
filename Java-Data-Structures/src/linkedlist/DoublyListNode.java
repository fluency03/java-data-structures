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

  public DoublyListNode(T data, DoublyListNode<T> prev, DoublyListNode<T> next) {
    this.data = data;
    this.prev = prev;
    this.next = next;
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
