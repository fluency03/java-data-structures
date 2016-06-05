/**
 * Class:  SingleLinkedList
 * Author: Chang LIU
 */

package linkedlist;

import java.util.Iterator;

public interface LinkedList<T> {

  /*
   *  Return the head of list
   */
  public ListNode<T> getHead();

  /*
   *  Return the size of list
   */
  public int size();

  /*
   *  Check Empty
   */
  public boolean isEmpty();

  /*
   *  Clear the whole list
   */
  public void clearList();

  /*
   *  Return the head of list
   */
  public T peek();

  /*
   * Look at the data at certain position
   */
  public T get(int position);

  /*
   * Set at the data at certain position
   */
  public void set(int position, T data);

  /*
   *  Return the position of first data appeared.
   */
  public int indexOf(T data);

  /*
   * Check whether the linked list contains the specific element
   */
  public boolean contains(T data);

  /**
   * --------------------------------
   * Insert node with several methods
   * --------------------------------
   */
  /*
   *  Insert a node at beginning of the list
   */
  public void insertAtBegin(T data);

  /*
   *  Insert a node at the end of the list
   */
  public void insertAtEnd(T data);

  /*
   *  Insert a node at the end of the list
   */
  public void add(T data);

  /*
   *  Insert a data at a specified position
   */
  public void insert(T data, int position);


  /**
   * --------------------------------
   * Remove node with several methods
   * --------------------------------
   */
  /*
   *  Remove a node from the begin
   */
  public T removeFirst();

  /*
   *  Remove a node from the begin
   */
  public T pop();

  /*
   *  Remove a node from the end
   */
  public T removeLast();

  /*
   *  Remove the node at certain position
   */
  public T removeAt(int position);

  /*
   * Return the iterator()
   */
  // @Override
  public Iterator<T> iterator();

  /*
   *  Convert the list to String
   */
  public String toString();

}
