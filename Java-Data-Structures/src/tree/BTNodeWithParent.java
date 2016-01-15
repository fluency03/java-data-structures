/**
 * Class: BTNodeWithParent with Parent
 * Author: Chang LIU
 */

package tree;

//import static java.lang.System.out;

public class BTNodeWithParent<T> {

  private BTNodeWithParent<T> parent = null;
  private BTNodeWithParent<T> left = null;
  private BTNodeWithParent<T> right = null;
  private T data = null;
  
  public BTNodeWithParent() { }
  
  public BTNodeWithParent(T data) {
    this.data = data;
  }
  
  public BTNodeWithParent(T data, BTNodeWithParent<T> parent, BTNodeWithParent<T> left, BTNodeWithParent<T> right) {
    this.data = data;
    this.parent = parent;
    this.left = left;
    this.right = right;
  }
  
  public T getData() {
    return data;
  }
  
  public void setData(T data) {
    this.data = data;
  }
  
  public BTNodeWithParent<T> getParent() {
    return left;
  }
  
  public void setParent(BTNodeWithParent<T> parent) {
    this.parent = parent;
  }
  
  public BTNodeWithParent<T> getLeft() {
    return left;
  }
  
  public void setLeft(BTNodeWithParent<T> left) {
    this.left = left;
  }
  
  public void insertLeft(BTNodeWithParent<T> left) {
    left.setLeft(this.getLeft().getLeft());
    left.setRight(this.getLeft().getRight());
    left.setParent(this);
    left.getLeft().setParent(left);
    left.getRight().setParent(left);
    this.setLeft(left);
  }
  
  public BTNodeWithParent<T> getRight() {
    return right;
  }
  
  public void setRight(BTNodeWithParent<T> right) {
    this.right = right;
  }
  
  public void insertRight(BTNodeWithParent<T> right) {
    right.setLeft(this.getRight().getLeft());
    right.setRight(this.getRight().getRight());
    right.setParent(this);
    right.getLeft().setParent(right);
    right.getRight().setParent(right);
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
   *  Check whether this node is root
   */
  public boolean isRoot() {
    return (parent == null);
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
   * Find the data downwards from the node specified
   */  
  public static <T> boolean findData(BTNodeWithParent<T> root, T data) {
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
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
