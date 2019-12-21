/**
 * 
 */
package cs2321;

import net.datastructures.Queue;
import net.datastructures.CircularQueue;

/**
 * @author ruihong-adm
 * @param <E>
 *
 */

public class CircularArrayQueue<E> implements Queue<E>, CircularQueue<E> {

	// Variables
	//
	private static final int CAPACITY = 16;
	private E[] data;
	private int frontIndex = 0;
	private int size = 0;
	
	// Constructors
	//
	// Instantiate CircularArrayQueue with default CAPACITY
	public CircularArrayQueue() {
		this(CAPACITY);
	}
	
	// Instantiate CircularArrayQueue with given capacity
	// queueSize: length of CircularArrayQueue
	@SuppressWarnings("unchecked")
	public CircularArrayQueue(int queueSize) {
		data = (E[]) new Object[queueSize];
	}
	
	// Functions
	//
	// Return size of CircularArrayQueue 
	@Override
	public int size() {
		return size;
	}

	// Returns true if CircularArrayQueue  is empty
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	// Adds element to end of queue
	// e: element to add
	@Override
	public void enqueue(E e) {
		if (size == data.length) {
			resize(data.length * 2);
		}
		int index = (frontIndex + size) % data.length;
		data[index] = e;
		size++;
	}

	// Return first element in queue, do not remove it
	@Override
	public E first() {
		if (isEmpty()) {
			return null;
		}
		return data[frontIndex];
	}

	// Return first element in queue, remove it from queue
	@Override
	public E dequeue() {
		if (isEmpty()) {
			return null;
		}
		E value = data[frontIndex];
		data[frontIndex] = null;
		frontIndex = (frontIndex + 1) % data.length;
		size--;
		return value;
	}

	// Rotate element in front of queue to the back of the queue
	@Override
	public void rotate() {
		if (size != 0) {
			E value = dequeue();
			enqueue(value);
		}
	}
	
	// Utility
	//
	// Increase size of queue while maintaining queue order
	// capacity: capacity of new queue
	public void resize(int capacity) {
		@SuppressWarnings("unchecked")
		E[] newData = (E[]) new Object[capacity];
		for(int n = 0; n < data.length; n++) {
			int i = (n + frontIndex) % data.length;
			newData[n] = data[i]; 
		}
		frontIndex = 0;
	}
    
}
