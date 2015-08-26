/*
 * Implement an algorithm to find the kth to last element of a singly linked list.
 */

package two_one;

public class Nodey {
	Nodey next = null;
	int data;
	
	public Nodey(int d){
		data = d;
	}
	
	void appendToAll(int d){
		Nodey end = new Nodey(d);
		Nodey n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}
	
	static int getListLength(Nodey n) {
		int counter = 1;
		while (n.next != null) {
			n = n.next;
			counter++;
		}
		return counter;
	}
	
	static int findNodeAtK(Nodey n, int k) {
		int counter = getListLength(n);
		int index = counter - k;
		int stop = 1;
		while (stop <= index) {
			if (stop == index) {
				return n.data;
			}
			stop++;
			n = n.next;
		}
		return n.data;
	}
	
	public static int nthToLast(Nodey head, int k) {
		if (head == null) {
			return 0;
		}
		int i = nthToLast(head.next, k) + 1;
		if (i == k) {
			System.out.println(head.data);
		}
		return i;
	}
	
	/*
	 * Implement an algorithm to delete a node in the middle of a singly linked list, given
		only access to that node.
	 */
	public boolean deleteNode(Nodey n){
		Nodey next = n.next;
		n.data = next.data;
		n.next = next.next;
		return true;
	}
	
	public static void main(String[] args){
		Nodey head = new Nodey(5);
		head.appendToAll(1);
		head.appendToAll(7);
		head.appendToAll(3);
		head.appendToAll(7);
		head.appendToAll(4);
		head.appendToAll(3);
		int n = findNodeAtK(head, 3);
		System.out.println(n);
		System.out.println(nthToLast(head, 3));
	}
}