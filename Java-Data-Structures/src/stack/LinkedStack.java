/**
 * Class: LinkedStack
 * Author: Chang LIU
 */

package stack;

import linkedlist.ListNode;
import static java.lang.System.out;

public class LinkedStack<T> {

  private ListNode<T> top = null; // the top of the stack
  private int length = 0; // the length of the stack

  public LinkedStack() { };

  public LinkedStack(T data) {
    top = new ListNode<>(data, null);
    length = 1;
  }

  /*
   *  Push a data into the top of the stack
   */
  public void push(T data) {
    ListNode<T> newNode = new ListNode<>(data);
    newNode.setNext(top);
    top = newNode;
    length ++;
  }

  /*
   *  Pop out the top of the stack
   */
  public T pop() {
    if (length == 0) {
      out.println("The stack is empty!");
      return null;
    }

    ListNode<T> temp = top; // the top of the stack
    top = top.getNext();
    length --;

    return temp.getData();
  }

  /*
   *  Peek the top of the stack
   */
  public T peek() {
    if (length == 0) {
      out.println("The stack is empty!");
      return null;
    }

    return top.getData();
  }

  /*
   *  Return whether the stack is empty
   */
  public boolean isEmpty() {
    return (length == 0);
  }

  /*
   *  Get the length of the stack
   */
  public int getLength() {
    return length;
  }

  /*
   *  Convert the stack into a String
   */
  public String toString() {
    String str = "";
    if (length == 0) {
      out.println("The list is empty!");
      return str;
    }

    ListNode<T> temp = top;
    ListNode<T> p;
    str = str + temp.getData();
    while ((p = temp.getNext()) != null) {
      str = p.getData() + ", "+ str;
      temp = temp.getNext();
    }

    return str;
  }

}
