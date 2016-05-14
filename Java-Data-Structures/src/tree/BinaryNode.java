/**
 * Class: BinaryNode
 * Author: Chang LIU
 */

package tree;

import java.util.*;

public class BinaryNode<T> {

  private T data;
  private BinaryNode<T> left;
  private BinaryNode<T> right;
  private boolean visited;

  BinaryNode (T data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }

  public T getData() {
    return data;
  }

  public BinaryNode<T> getLeft() {
    return left;
  }

  public BinaryNode<T> getRight() {
    return right;
  }

  public boolean isVisited() {
    return visited;
  }

  public void setVisited(boolean visited) {
    this.visited = visited;
  }

  public void bfs() {
    Queue<BinaryNode<T>> queue = new LinkedList<>();
    queue.add(this);
    this.setVisited(true);
    while(!queue.isEmpty()) {
      BinaryNode<T> node = queue.remove();
      BinaryNode<T> left_node = node.getLeft();
      BinaryNode<T> right_node = node.getLeft();
      if (left_node != null && left_node.isVisited() == false) {
        left_node.setVisited(true);
        queue.add(left_node);
      }
      if (right_node != null && right_node.isVisited() == false) {
        right_node.setVisited(true);
        queue.add(right_node);
      }
    }
  }


  public void dfs() {
    Stack<BinaryNode<T>> stack = new Stack<>();
    stack.push(this);
    this.setVisited(true);
    while(!stack.isEmpty()) {
      BinaryNode<T> node = stack.pop();
      BinaryNode<T> left_node = node.getLeft();
      BinaryNode<T> right_node = node.getLeft();
      if (left_node != null && left_node.isVisited() == false) {
        left_node.setVisited(true);
        stack.push(left_node);
      }
      if (right_node != null && right_node.isVisited() == false) {
        right_node.setVisited(true);
        stack.push(right_node);
      }
    }
  }

}
