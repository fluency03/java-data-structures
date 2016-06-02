/**
 * Class: PriorityNode
 * Author: Chang LIU
 */

package priorityqueue;

import linkedlist.ListNode;

public class PriorityNode<T> extends ListNode<T> {

  private PriorityNode<T> next = null;
  private T data = null;
  private int priority = 0;

  public PriorityNode() { }

  public PriorityNode(T data) {
    this.data = data;
  }

  public PriorityNode(T data, PriorityNode<T> next) {
    this.data = data;
    this.next = next;
  }

  public PriorityNode(T data, int priority) {
    this.data = data;
    this.priority = priority;
  }

  public PriorityNode(PriorityNode<T> next, int priority) {
    this.next = next;
    this.priority = priority;
  }

  public PriorityNode(T data, PriorityNode<T> next, int priority) {
    this.data = data;
    this.next = next;
    this.priority = priority;
  }



}
