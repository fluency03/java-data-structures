/**
 * Class: ListTest
 * Author: Chang LIU
 */

package linkedlist;

public class ListTest {

	public static void main(String[] args) {

	  // ListNode test
		ListNode<Integer> ln1 = new ListNode<>(5);
		ListNode<Integer> ln2 = new ListNode<>();
		ln2.setData(15);
		System.out.println("The data of the node: " + ln1.getData() + " " + ln2.toString());
		
		
		// SingleLinkedList test
		SingleLinkedList<Integer> sll = new SingleLinkedList<>(); 
		System.out.println( "Empty: " + sll.isEmpty() );
		for (int i = 0; i < 10; i++) {
		  sll.insertAtBegin(i);
    }
    for (int i = 10; i < 20; i++) {
      sll.insertAtEnd(i);
    }
    
    ListNode<Integer> p;
    // Print the list
    for (p=sll.getHead(); p != null; p=p.getNext()) {
      System.out.println( p.getData() + ", Next: " + p.getNext() );
    }
    System.out.println( "Empty: " + sll.isEmpty() );
		
    sll.insert(100, 5);
    sll.insert(100, 0);
    sll.insert(100, 55);

     // Test removeFirst() and removeLast()
    System.out.println( "Removed first: " + sll.removeFirst() );
    System.out.println( "Removed last: " + sll.removeLast() );
    
    // Test getLength()
    System.out.println( "The length of the list: " + sll.getLength() );
    
    // Test toString()
    System.out.println( "Convert to String: " + sll.toString() );
    
    // Test getPosition(T data)
    System.out.println( "9 From: " + sll.getPosition(9) + ", 4 From: " +  sll.getPosition(4) + ", 19 From: " + sll.getPosition(19) );
    System.out.println( "101 From: " + sll.getPosition(101) );
		
    // Test peekAt(int position)
    System.out.println( "@0: " + sll.peekAt(0) + ", @10: " + sll.peekAt(10) + ", @20: " + sll.peekAt(20) );
    System.out.println( "@50: " + sll.peekAt(50) );
    
    
		
		
		
		
		
		
	}

}
