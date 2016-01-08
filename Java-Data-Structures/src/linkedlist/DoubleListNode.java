/**
 * Class: DoubleListNode
 * Author: Chang LIU
 */

package linkedlist;

public class DoubleListNode<T> {

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
  
  public T getData(){
    return data;
  }
  
  public void setData(T data) {
    this.data = data;
  }
  
  public DoubleListNode<T> getPrev(){
    return prev;
  }
  
  public void setPrev(DoubleListNode<T> prev) {
    this.prev = prev;
  }
  
  public DoubleListNode<T> getNext(){
    return next;
  }
  
  public void setNext(DoubleListNode<T> next) {
    this.next = next;
  }
  
  public String toString() {
    String str = "";
    return str + data;
  }
  
  
}
