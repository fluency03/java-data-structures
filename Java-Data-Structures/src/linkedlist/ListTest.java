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
		for (int i = 0; i < 10; i++) {
		  ListNode<Integer> ln = new ListNode<>(i);
		  sll.insertAtBegin(ln);
    }
		
    for (int i = 10; i < 20; i++) {
      ListNode<Integer> ln = new ListNode<>(i);
      sll.insertAtEnd(ln);
    }
		
    sll.insert(100, 5);
    
    ListNode<Integer> p;
    /**
     * This condition of for-statement is not correct
     */
//    for (p=sll.getHead(); (q = p.getNext()) != null; p=q) {
//      System.out.println( p.getData() + " " + (p.getNext()==null) );
//    }

    for (p=sll.getHead(); p != null; p=p.getNext()) {
      System.out.println( p.getData() + " " + (p.getNext()==null) );
    }
    
    System.out.println( sll.getLength() );
    
    System.out.println( sll.toString() );
    
    System.out.println( sll.getPosition(4) );
		
		
		
		
		
		
		
		
		
	}

}
