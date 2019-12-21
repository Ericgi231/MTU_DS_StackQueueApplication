package cs2321;

public class InfixToPostfix {
	/* Convert an infix expression and to a postfix expression
	 * infix expression : operator is between operands. Ex. 3 + 5
	 * postfix Expression: operator is after the operands. Ex. 3 5 +
	 * 
	 * The infixExp expression includes the following
	 *      operands:  integer or decimal numbers 
	 *      and operators: + , - , * , /
	 *      and parenthesis: ( , )
	 *      
	 *      For easy parsing the expression, there is a space between operands and operators, parenthesis. 
	 *  	Ex: "1 * ( 3 + 5 )"
	 *      Notice there is no space before the first operand and after the last operand/parentheses. 
	 *  
	 * The postExp includes the following 
	 *      operands:  integer or decimal numbers 
	 *      and operators: + , - , * , /
	 *      
	 *      For easy parsing the expression, there should have a space between operands and operators.
	 *      Ex: "1 3 5 + *"
	 *      Notice there is space before the first operand and last operator. 
	 *      Notice that postExp does not have parenthesis. 
	 */
	public static String convert(String infixExp) {
		// Variables
		//
		String[] elements = infixExp.split(" ");
		DLLStack<String> storage = new DLLStack<>();
		DoublyLinkedList<String> preOut = new DoublyLinkedList<>();
		String out = "";
		String e;
		
		// Main loop
		//
		// For each element in elements
		for (int n = 0; n < elements.length; n++) {
			
			// Set e to string value of current operator/operative/bracket
			e = elements[n];
			
			if (e.equals("+") || e.equals("-") || e.equals("*") || e.equals("/") || e.equals("(") || e.equals(")")) { // e is not number
				if (storage.isEmpty() || storage.top().equals("(")) { // operator storage is empty
					storage.push(e);
				} 
				else { // operator storage is not empty
					switch (e) {
					case "+":
					case "-":
						// While top of storage is not empty or (
						// Pop top of storage onto end of preOut
						while (!(storage.isEmpty() || storage.top().equals("("))) {
							preOut.addLast(storage.pop());
						}
						// add e to top of storage
						storage.push(e);
						break;
					case "*":
					case "/":
						// While top of storage is * or / AND not empty or (
						// Pop top of storage onto end of preOut
						while (!(storage.isEmpty() || storage.top().equals("(")) && (storage.top().equals("*") || storage.top().equals("/"))) { 
							preOut.addLast(storage.pop());
						} 
						// add e to top of storage
						storage.push(e);
						break;
					case "(":
						// Add left bracket to storage
						storage.push(e);
						break;
					case ")":
						// Empty storage until a left bracket is hit
						while (!storage.top().equals("(")) {
							preOut.addLast(storage.pop());
						}
						// Delete left bracket from storage
						storage.pop();
						break;
					}
				}
			} 
			else { // e is number
				// Add number to output
				preOut.addLast(e);
			}
		}
		
		// Pop all operators from storage onto preOut
		while (!storage.isEmpty()) {
			preOut.addLast(storage.pop());
		}
		
		// Convert preOut to String
		for (String s : preOut) {
			out += s + " ";
		}
		out = out.trim();
		
		return out;
	}	
}
