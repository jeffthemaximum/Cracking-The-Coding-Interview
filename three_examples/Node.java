
public class Node {
	Object data;
	Node next = null;
	
	public Node(Object item){
		data = item;
	}
}

class Stack {
	Node top;
	
	Object pop() {
		if (top != null) {
			Object item = top.data;
			top = top.next;
			return item;
		}
		return null;
	}
	
	void push(Object item) {
		Node t = new Node(item);
		t.next = top;
		top = t;
	}
	
	Object peek() {
		return top.data;
	}
}

class Queue {
	Node first, last;
	
	void enqueue(Object item) {
		if (first == null) {
			first = new Node(item);
			first = last;
		} else {
			last.next = new Node(item);
			last = last.next;
		}
	}
	
	Object dequeue(){
		if (first != null) {
			Object item = first.data;
			first = first.next;
			return item;
		}
		return null;
	}
	
    /* returns index of the top of the stack "stackNum", in absolute terms */
    static int absTopOfStack(int stackNum, int stackSize, int[] stackPointer) {
        return stackNum * stackSize + stackPointer[stackNum];
    }
	
	static int stackSize = 100;
	static int[] buffer = new int[stackSize * 3];
	static int[] stackPointer = {-1, -1, -1};
	
	static void push (int stackNumber, int value) throws Exception {
		if (stackPointer[stackNumber] + 1 >= stackSize) {
			throw new Exception("out of space, newb");
		}
		stackPointer[stackNumber]++;
		//add int value to buffer
		buffer[absTopOfStack(stackNumber, stackSize, stackPointer)] = value;
	}
	
	public static void main (String[] args) throws Exception {
		for (int i = 0; i < 10; i++) {
			push(0, i);
		}
		for (int i = 0; i < 10; i ++) {
			System.out.println(buffer[i]);
		}
	}
}


