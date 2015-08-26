package two_examples;

public class Node {
	Node next = null;
	int data;
	
	public Node(int d){
		data = d;
	}
	
	void appendToAll(int d){
		Node end = new Node(d);
		Node n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}
	
	static Node deleteNode(Node head, int d){
		Node n = head;
		
		if (n.data == d) {
			return head.next;
		}
		
		while (n.next != null) {
			if (n.next.data == d) {
				n.next = n.next.next;
				return head;
			}
			n = n.next;
		}
		return head;
	}
	
	void printList() {
		Node n = this;
		while (n.next != null){
			System.out.println(n.data);
			n = n.next;
		}
		System.out.println(n.data);
	}
	
	public static void main(String[] args) {
		Node head = new Node(1);
		for (int i = 2; i < 6; i++) {
			head.appendToAll(i);
		}
		Node n = head;
		n.printList();
		Node shorterList = deleteNode(n, 5);
		shorterList.printList();
	}
}
