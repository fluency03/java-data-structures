/**
 * Class: BinaryTreeNode
 * Author: Chang LIU
 */

package tree;

//import static java.lang.System.out;

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
  
  public void insertLeft(BinaryTreeNode<T> left) {
    left.setLeft(this.getLeft().getLeft());
    left.setRight(this.getLeft().getRight());
    this.setLeft(left);
  }
  
  public BinaryTreeNode<T> getRight() {
    return right;
  }
  
  public void setRight(BinaryTreeNode<T> right) {
    this.right = right;
  }
  
  public void insertRight(BinaryTreeNode<T> right) {
    right.setLeft(this.getRight().getLeft());
    right.setRight(this.getRight().getRight());
    this.setRight(right);
  }
  
  /*
   *  Convert the data into String
   */
  public String dataToString() {
    String str = "";
    str = str + data;
    return str;
  }
  
  /*
   *  Convert the tree with root of current node into String
   */
  public String toString() {
    String str = "";
    if (left == null && right == null) {
      str = str + data;
    } else {
      String left = "";
      String right = "";
      if (left != null) {
        left = getLeft().dataToString();
      }
      if (right != null) {
        right = getRight().dataToString();
      }
      str = "(" + left + "," + data + "," + right + ")";
    }
    
    return str;
  }
  
  /*
   *  Check whether this node is leaf
   */
  public boolean isLeaf() {
    return (left == null && right == null);
  }
  
  /*
   *  Check whether the left is empty
   */
  public boolean leftEmpty() {
    return (left == null);
  }
  
  /*
   *  Check whether the right is empty
   */
  public boolean rightEmpty() {
    return (right == null);
  }
  
  /*
   * Find the data rooted from this node
   */  
  public static <T> boolean findData(BinaryTreeNode<T> root, T data) {
    if (root == null) {
      return false;
    } else if (root.getData() == data) {
      return true;
    } else {
      return ( findData(root.getLeft(), data) || findData(root.getRight(), data));
    }    
  }
  
  /*
   * Return the hash code for binary tree root from this node
   */
//  public int hashCode() {
//    TODO
//  }
  
  
  
  
  /*
   * Check the number of the nodes rooted from this node
   */
  public int numberOfNodes() {
    int leftCount = (this.left == null? 0:this.left.numberOfNodes());
    int rightCount = (this.right == null? 0:this.right.numberOfNodes());
    return (1 + leftCount + rightCount);
  }
  
  
  /*
   * Return a new node as same as this node
   */
  public BinaryTreeNode<T> copy() {
    BinaryTreeNode<T> left = null;
    BinaryTreeNode<T> right = null;
    if (this.left != null) {
      left = this.left.copy();
    }
    if (this.right != null) {
      right = this.right.copy();
    }
    return new BinaryTreeNode<T>(this.data, left, right);
  }
  
  /*
   * Reverse the binary tree rooted from this node to a new tree
   */
  public BinaryTreeNode<T> reverse() {
    BinaryTreeNode<T> left = null;
    BinaryTreeNode<T> right = null;
    if (this.left != null) {
      left = this.left.reverse();
    }
    if (this.right != null) {
      right = this.right.reverse();
    }
    return new BinaryTreeNode<T>(this.data, right, left);
  }
  
  /*
   * Reverse the binary tree rooted from this node by revising original tree
   */
  public void reverseInPlace() {
    if (this.left != null) {
      this.left.reverseInPlace();
    }
    if (this.right != null) {
      this.right.reverseInPlace();
    }
    BinaryTreeNode<T> temp = this.left;
    this.setLeft(this.right);
    this.setRight(temp);
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
