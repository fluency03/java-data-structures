/**
 * Class: ListNode
 * Author: Chang LIU
 */

package linkedlist;

public class ListNode<T> {

  private ListNode<T> next = null;
  private T data = null;

  public ListNode() { }

  public ListNode(T data) {
    this.data = data;
  }

  /*
   * Add a new node after the current node
   * Time Complexity: O(1)
   */
  public void add(T data) {
    ListNode<T> newNode = new ListNode<T>(data);
    newNode.setNext(this.getNext().getNext());
    this.setNext(newNode);
  }

  /*
   * Delete the next node of current node
   * Time Complexity: O(1)
   */
  public T delete() {
    ListNode<T> nextNode = next;
    T nextData = nextNode.getData();
    this.setData(nextData);
    this.setNext(this.getNext().getNext());
    return nextData;
  }

  /*
   *  Obtain the next node
   */
  public ListNode<T> getNext() {
    return next;
  }

  /*
   *  Set the next node
   */
  public void setNext(ListNode<T> next) {
    this.next = next;
  }

  /*
   *  Obtain the data of current node
   */
  public T getData() {
    return data;
  }

  /*
   *  Set data of current node
   */
  public void setData(T data) {
    this.data = data;
  }

  /*
   *  Convert the node data into String
   */
  public String toString() {
    String str = "";
    return str + data;
  }


}
