/**
 * Class: BinaryTreeNode
 * Author: Chang LIU
 */

package tree;

import static java.lang.System.out;

public class BinaryTreeNode<T> {

  private BinaryTreeNode<T> left = null;
  private BinaryTreeNode<T> right = null;
  private T data = null;
  
  public BinaryTreeNode() { }
  
  public BinaryTreeNode(T data) {
    this.data = data;
  }
  
  public BinaryTreeNode(T data, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
    this.data = data;
    this.left = left;
    this.right = right;
  }
  
  public T getData() {
    return data;
  }
  
  public void setData(T data) {
    this.data = data;
  }
  
  public BinaryTreeNode<T> getLeft() {
    return left;
  }
  
  public void setLeft(BinaryTreeNode<T> left) {
    this.left = left;
  }
  
  public BinaryTreeNode<T> getRight() {
    return right;
  }
  
  public void setRight(BinaryTreeNode<T> right) {
    this.right = right;
  }
  
  // Convert the data into String
  public String dataToString() {
    String str = "";
    str = str + data;
    return str;
  }
  
  // Check whether this node is leaf
  public boolean isLeaf() {
    return (left == null && right == null);
  }
  
  // Check whether the left is empty
  public boolean leftEmpty() {
    return (left == null);
  }
  
  // Check whether the right is empty
  public boolean rightEmpty() {
    return (right == null);
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
