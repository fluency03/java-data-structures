/**
 * Class: ListTest
 * Author: Chang LIU
 */

package linkedlist;

import static java.lang.System.out;

public class ListTest {

	public static void main(String[] args) {

    out.println("----------------------");
    out.println("   LinkedList TEST!   ");
    out.println("----------------------");
	  // ListNode test
		ListNode<Integer> ln1 = new ListNode<>(5);
		ListNode<Integer> ln2 = new ListNode<>();
		ln2.setData(15);
		out.println("The data of the node: " + ln1.getData() + " " + ln2.toString());
		
		
    out.println("----------------------");
    out.println("SingleLinkedList TEST!");
    out.println("----------------------");

		SingleLinkedList<Integer> sll = new SingleLinkedList<>(); 
    ListNode<Integer> p;
		System.out.println( "Empty: " + sll.isEmpty() );
		// Insert at begin
		for (int i = 0; i < 10; i++) {
		  sll.insertAtBegin(i);
    }
    System.out.println( "Empty: " + sll.isEmpty() );
    // Print the list
    for (p=sll.getHead(); p != null; p=p.getNext()) {
      System.out.println( p.getData() + ", Next: " + p.getNext() );
    }
    // Remove first
    for (int i = 0; i < 10; i++) {
      sll.removeFirst();
    }
		
    // -------------------------------------------------------------
    // Insert at the end
    for (int i = 10; i < 20; i++) {
      sll.insertAtEnd(i);
    }
    System.out.println( "Empty: " + sll.isEmpty() );
    // Print the list
    for (p=sll.getHead(); p != null; p=p.getNext()) {
      System.out.println( p.getData() + ", Next: " + p.getNext() );
    }
    // Remove the last
    for (int i = 0; i < 10; i++) {
      sll.removeLast();
    }
    System.out.println( "Empty: " + sll.isEmpty() );
    
    // -------------------------------------------------------------
    System.out.println( "peekAt 0: " + sll.peekAt(0) );
    for (int i = 0; i < 10; i++) {
      sll.insertAtBegin(i);
    }
    System.out.println( "peekAt 0: " + sll.peekAt(0) );
    sll.insert(100, 5);
    sll.insert(100, 0);
    sll.insert(100, 55);
    System.out.println( "peekAt 0: " + sll.peekAt(0) );
    
    // Print the list
    for (p=sll.getHead(); p != null; p=p.getNext()) {
      System.out.println( p.getData() + ", Next: " + p.getNext() );
    }
    
    
    // -------------------------------------------------------------
    // Test getPosition(T data)
    System.out.println( "9 From: " + sll.getPosition(9) + ", 4 From: " +  sll.getPosition(4) + ", 19 From: " + sll.getPosition(19) );
    System.out.println( "101 From: " + sll.getPosition(101) );
    
     // Test removeFirst() and removeLast()
    System.out.println( "Removed first: " + sll.removeFirst() );
    System.out.println( "Removed last: " + sll.removeLast() );
    
    // Test getLength()
    System.out.println( "The length of the list: " + sll.getLength() );
    
    // Test toString()
    System.out.println( "Convert to String: " + sll.toString() );
		
    // Test peekAt(int position)
    System.out.println( "@0: " + sll.peekAt(0) + ", @10: " + sll.peekAt(10) + ", @20: " + sll.peekAt(20) );
    System.out.println( "@50: " + sll.peekAt(50) );
    
    
    out.println("----------------------");
    out.println("DoubleLinkedList TEST!");
    out.println("----------------------");
		
    
    // TODO
		
		
		
		
		
	}

}
