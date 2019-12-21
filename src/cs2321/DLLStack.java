package cs2321;

import net.datastructures.Stack;

public class DLLStack<E> implements Stack<E> {

	// Variables
	//
	public int size = 0;
	public DoublyLinkedList<E> list = new DoublyLinkedList<>();
	
	// Return size of stack
	@Override
	public int size() {
		return size;
	}

	// Returns true if stack is empty
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	// Adds element to top of stack
	// e: element
	@Override
	public void push(E e) {
		list.addFirst(e);
		size++;
	}

	// Returns top of stack but does not remove it from stack
	@Override
	public E top() {
		if (!this.isEmpty()) {
			return list.first().getElement();
		} else {
			return null;
		}
	}

	// Returns and removes top of stack
	@Override
	public E pop() {
		if (!this.isEmpty()) {
			size--;
			return list.removeFirst();
		} else {
			return null;
		}
	}

}
