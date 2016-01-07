/**
 * Class: ListNode
 * Author: Chang LIU
 */

package linkedlist;

public class ListNode<T> {

  private ListNode<T> next = null;
  private T data = null;

  // Create an empty node
  public ListNode() { }

  // Create an node with data specified
  public ListNode(T data) {
    this.data = data;
  }

  // Obtain the next node
  public ListNode<T> getNext() {
    return next;
  }

  // Set the next node
  public void setNext(ListNode<T> next) {
    this.next = next;
  }

  // Obtian the data of current node
  public T getData() {
    return data;
  }

  // Set data of current node
  public void setData(T data) {
    this.data = data;
  }

  // Convert the node data into String
  public String toString() {
    return (String)data;
  }


}
