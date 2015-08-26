/*
 * You have two numbers represented by a linked list, where each node contains a
single digit. The digits are stored in reverse order, such that the 1 's digit is at the head
of the list. Write a function that adds the two numbers and returns the sum as a
linked list.
 */

public class Node {
	int data;
	Node next = null;
	
	public Node(int d) {
		data = d;
	}
	
	void appendToAll(int d){
		Node n = this;
		Node end = new Node(d);
		while (n.next != null){
			n = n.next;
		}
		n.next = end;
	}
	
	void printList() {
		Node n = this;
		while (n.next != null){
			System.out.println(n.data);
			n = n.next;
		}
		System.out.println(n.data);
	}
	
	static Node sumLists(Node l1, Node l2, int carry){
		if (l1 == null && l2 == null && carry == 0) {
			return null;
		}
		Node result = new Node(carry);
		int value = carry;
		if (l1 != null) {
			value += l1.data;
		}
		if (l2 != null) {
			value += l2.data;
		}
		result.data = value % 10;
		if (l1 != null || l2 != null) {
			Node more = sumLists(l1 == null ? null : l1.next, l2 == null ? null : l2.next, value >= 10 ? 1: 0);
		result.appendToAll(more.data);
		}
		return result;
	}
	
	public static void main(String[] args){
		Node l1 = new Node(7);
		l1.appendToAll(1);
		l1.appendToAll(6);
		Node l2 = new Node(5);
		l2.appendToAll(9);
		l2.appendToAll(2);
		Node solution = sumLists(l1, l2, 0);
		solution.printList();
	}
}
