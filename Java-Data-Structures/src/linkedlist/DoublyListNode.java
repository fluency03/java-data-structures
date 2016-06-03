/**
 * Class: DoubleListNode
 * Author: Chang LIU
 */

package linkedlist;

public class DoublyListNode<T> {

  private DoubleListNode<T> prev = null;
  private DoubleListNode<T> next = null;
  private T data = null;

  public DoubleListNode () { }

  public DoubleListNode (T data) {
    this.data = data;
  }

  public DoubleListNode(T data, DoubleListNode<T> prev, DoubleListNode<T> next) {
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
  public DoubleListNode<T> getPrev(){
    return prev;
  }

  /*
   *  Set previous node
   */
  public void setPrev(DoubleListNode<T> prev) {
    this.prev = prev;
  }

  /*
   *  Return the next node
   */
  public DoubleListNode<T> getNext(){
    return next;
  }

  /*
   *  Set the next node
   */
  public void setNext(DoubleListNode<T> next) {
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
