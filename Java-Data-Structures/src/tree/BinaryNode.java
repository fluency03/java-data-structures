/**
 * Class: BinaryNode
 * Author: Chang LIU
 */

package tree;

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

  







}
