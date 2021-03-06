package kumar.coding.exercises.dataStructures.LinkedList;

/**
 * This exercise is to reverse a linked list
 * @author Kumar
 *
 */

public class ReverseLinkedList {
	Node head; // head of list
	static Node a, b;

	/* Node Class */
	public static class Node {

		Integer data;
		Node next;

		// Constructor to create a new node
		Node(int d) {
			data = d;
			next = null;
		}
		Node() {
			data = null;
			next = null;
		}
	}
	
	static void printlist(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}
	
	public static void main(String[] args) {
		ReverseLinkedList.a = new Node(1);
		ReverseLinkedList.a.next = new Node(2);
		ReverseLinkedList.a.next.next = new Node(3);
		ReverseLinkedList.a.next.next.next = new Node(4);
		ReverseLinkedList.a.next.next.next.next = new Node(5);
		printlist(ReverseLinkedList.a);
		System.out.println( "\nAfter reversing the List");
		printlist(approach2(ReverseLinkedList.a));
	}

	private static Node reverseList(Node current) {
		System.out.println(current.data + "--1");
		if(current == null) {
			System.out.println(current.data);
			return null;
		}else if (current.next == null) {
			System.out.println(current.data + "--2");
			return current;
		}else {
			System.out.println(current.data + "--3");
			Node nextNode = current.next;
			current.next = null;
			Node result = reverseList(nextNode);
			System.out.println(nextNode.data + "--4");
			nextNode.next = current;
			System.out.println(nextNode.next.data + "--5");
			System.out.println(result.data + "--6");
			return result;
		}
	}
	
	private static Node approach2(Node head){
		if(head == null){
			return null;
		}
		
		Node prev = null;
		Node current = head;
		
		while(current != null){
			Node temp = current.next;
			current.next = prev;
			prev = current;
			current = temp;
		}
		
		return prev;
		
	}
}
