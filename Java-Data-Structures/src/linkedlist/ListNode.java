/**
 * Class: ListNode
 * Author: Chang LIU
 */

package linkedlist;

public class ListNode<T> {

  private ListNode<T> next = null;
  private T data;

  public ListNode(T data) {
    this.data = data;
  }

  /*
   * Add a new node after the current node
   * Time Complexity: O(1)
   */
  public void add(T data) {
    ListNode<T> newNode = new ListNode<T>(data);
    newNode.next = this.next;
    this.next = newNode;
  }

  /*
   * Delete the next node of current node
   * Time Complexity: O(1)
   */
  public T delete() throws DummyNodeException {
    if (data == null) { /* The current node is the last node. */
      throw new DummyNodeException("This is a dummy node.");
    }

    ListNode<T> nextNode = this.next;
    T thisData = this.data;
    this.data = nextNode.data;
    this.next = nextNode.next;
    return thisData;
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
