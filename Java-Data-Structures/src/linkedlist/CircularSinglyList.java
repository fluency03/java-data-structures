/**
 * Class: CircularSingleList
 * Author: Chang LIU
 */

package linkedlist;

import static java.lang.System.out;

public class CircularSinglyList<T> extends LinkedList<T> {

  public CircularSinglyList() {
    super();
    dummy.setNext(head);
  }

}
