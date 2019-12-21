package cs2321;

public class PostfixExpression {
	
	/**
	 * Evaluate a postfix expression. 
	 * Postfix expression notation has operands first, following by the operations.
	 * For example:
	 *    13 5 *           is same as 13 * 5 
	 *    4 20 5 + * 6 -   is same as 4 * (20 + 5) - 6  
	 *    
	 * In this homework, expression in the argument only contains
	 *     integer, +, -, *, / and a space between every number and operation. 
	 * You may assume the result will be integer as well. 
	 * 
	 * @param exp The postfix expression
	 * @return the result of the expression
	 */
	public static int evaluate(String exp) {
		// Variables
		//
		DLLStack<Integer> stack = new DLLStack<>();
		String[] expression = exp.split(" ");
		Integer num, num1, num2;
		
		for(String e : expression) {
			// If e is an operator, perform equation with top two numbers on stack
			if (e.equals("+") || e.equals("-") || e.equals("*") || e.equals("/")) {
				num2 = stack.pop();
				num1 = stack.pop();
				switch (e) {
				case "+":
					stack.push(num1 + num2);
					break;
				case "-":
					stack.push(num1 - num2);
					break;
				case "*":
					stack.push(num1 * num2);
					break;
				case "/":
					stack.push(num1 / num2);
					break;
				}
			} else { // If e is a number, add to stack
				num = Integer.parseInt(e);
				stack.push(num);
			}
		}
		
		return stack.pop();
	}
				
	
}
