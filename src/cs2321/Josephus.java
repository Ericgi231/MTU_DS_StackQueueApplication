package cs2321;

public class Josephus {
	/**
	 * All persons sit in a circle. When we go around the circle, initially starting
	 * from the first person, then the second person, then the third... 
	 * we count 1,2,3,.., k-1. The next person, that is the k-th person is out. 
	 * Then we restart the counting from the next person, go around, the k-th person 
	 * is out. Keep going the same way, when there is only one person left, she/he 
	 * is the winner. 
	 *  
	 * @parameter persons  an array of string which contains all player names.
	 * @parameter k  an integer specifying the k-th person will be kicked out of the game
	 * @return return a doubly linked list in the order when the players were out of the game. 
	 *         the last one in the list is the winner.  
	 */
	public DoublyLinkedList<String> order(String[] persons, int k ) {
		// Circular Queue used to store the people involved in the game
		CircularArrayQueue<String> alivePeople = new CircularArrayQueue<>();
		
		// Doubly Linked List used to store the output
		// As people fail the game they will be placed at the end of the List
		// The person at the end of the list is the winner
		DoublyLinkedList<String> deadPeople = new DoublyLinkedList<>();
		
		// Translate people from array to Circular Queue
		for(String p: persons) {
			alivePeople.enqueue(p);
		}
		
		// While people remain in game
		while (!alivePeople.isEmpty()) {
			// Rotate queue k times
			for (int n = 0; n < k-1; n++) {
				alivePeople.rotate();
			}
			// Remove person from front of queue and place them at the end of the List
			deadPeople.addLast(alivePeople.dequeue());
		}
		
		return deadPeople;
	}	
}
