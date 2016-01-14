/**
 * Class: ArrayStack
 * Author: Chang LIU
 */

package stack;

import java.util.EmptyStackException;
import static java.lang.System.out;

public class ArrayStack<T> {

  private T[] array;
  private int top = -1;;
  
  public ArrayStack(int size) {
  	// @SuppressWarnings("unchecked")
  	array = (T[])new Object[size];
  }
  
  /*
   * Push data x into the stack
   */
  public void push(T data) {
  	if (top == (array.length - 1)) {
  		throw new RuntimeException("Overflow");
  	}
  	array[++top] = data;
  }
  
  /*
   * Pop the data from the top of the stack
   */
  public T pop() {
  	if (top == -1) {
  		throw new EmptyStackException();
  	}
  	return array[top--];
  }
  
  /*
   * Peek the data at certain position
   */
  public T peek(int position) {
  	if (top == -1) {
  		throw new EmptyStackException();
  	} else if (position < 0 || position > array.length) {
  		out.println("Position is out of range!");
  		return null;
  	}
  	
  	return array[position];
  }
  
  /*
   * Check whether the ArrayStack is empty
   */
  public boolean isEmpty() {
  	return (top == -1);
  }
  
  /*
   * Get the length of the current stack
   */
  public int getLength() {
  	return (top + 1);
  }
  
  /*
   * Get the data at certain position
   */
  public String toString() {
    String str = "";
    if (top == -1) {
      out.println("The list is empty!");
      return str;
    }
  	
    int i = 1;
    str = str + array[0];
    while(i <= top) {
    	str = str + ", " + array[i];
    }
  	return str;  	
  }
  
}
