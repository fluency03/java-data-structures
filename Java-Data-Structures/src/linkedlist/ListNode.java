/**
 * Class: ListNode
 * Author: Chang LIU
 */

package linkedlist;

import static java.lang.System.out;

public class ListNode<T> {

  private static final Object DUMMY = new Object();

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
    newNode.next = this.next;
    this.next = newNode;
  }

  /*
   * Delete the next node of current node
   * Time Complexity: O(1)
   */
  public T delete() throws DummyNodeException {
    if (isDummy()) { /* The current node is the last node. */
      throw new DummyNodeException("This is a dummy node.");
    }

    ListNode<T> nextNode = this.next;
    T thisData = this.data;
    this.data = nextNode.data;
    this.next = nextNode.next;
    return thisData;
  }

  /*
   * Check whether this node is dummy node
   */
  public boolean isDummy() {
    return data == DUMMY;
  }

  /*
   * Check whether this node is dummy node
   */
  @SuppressWarnings("unchecked")
  public void setDummy() {
    data = (T)DUMMY;
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

  /**
   * Main function
   */
  public static void main(String[] args) {
    ListNode<Integer> testNode1 = new ListNode<Integer>(1);
    ListNode<Integer> testNode2 = new ListNode<Integer>(2);
    ListNode<Integer> testNode3 = new ListNode<Integer>(3);
    ListNode<Integer> testNode4 = new ListNode<Integer>(4);
    ListNode<Integer> testNode5 = new ListNode<Integer>(5);
    ListNode<Integer> testNodeD = new ListNode<Integer>();
    testNodeD.setDummy();

    // try {
    out.println(testNode1.toString());
    out.println(testNode2.toString());
    out.println(testNode3.toString());
    out.println(testNode4.toString());
    out.println(testNode5.toString());
    out.println(testNodeD.toString());
    // } catch (DummyNodeException e) {

    // }

  }

}
