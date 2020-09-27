
/**
 * This program transform an infix notation to postfix notation and evaluate postfix notation
 * @author Jiaxi Tang
 *
 */
public class Notation {


	private static NotationStack<String> stack = new NotationStack<String>(30);
	private static NotationQueue<String> queue = new NotationQueue<String>(30);

	/**
	 * evaluate the postfix expression 
	 * @param postfixExpr string containing postfix expression 
	 * @return the output of the postfix expression 
	 * @throws InvalidNotationFormatException thrown when the format of postfixExpr is incorrect 
	 */
	public static double evaluatePostfixExpression(java.lang.String postfixExpr)
			throws InvalidNotationFormatException{
		double output = 0;
		double one = 0, two = 0;
		char current;
		for(int i =0; i<postfixExpr.length(); i++) {
			current = postfixExpr.charAt(i);
			// if current char is digit
			if (Character.isDigit(current)) {
				stack.push(""+current);
			}
			// if current char is operator
			else if(current == '+' || current == '-' || current == '*' || current == '/') {
				try {
					two = Double.parseDouble((String)stack.pop());
					one = Double.parseDouble((String)stack.pop());
					switch (current) {
					case '+':
						output = one + two;
						stack.push(""+output); break;

					case '-':
						output = one - two;
						stack.push(""+output); break;

					case '*':
						output = one * two;
						stack.push(""+output); break;

					case '/':
						output = one / two;
						stack.push(""+output); break;
					}
				}
				catch(Exception e) {
					throw new InvalidNotationFormatException();
				}
			}
		}
		output = Double.parseDouble((String)stack.pop());
		if(stack.isEmpty()) {
			stack = new NotationStack<String>(30);
			queue = new NotationQueue<String>(30);
			return output;
		}
		else
			throw new InvalidNotationFormatException();
	}


	/**
	 * convert postfix expression to infix expression
	 * @param postfix string containing postfix expression
	 * @return string containing infix expression
	 * @throws InvalidNotationFormatException thrown when the format of postfix is incorrect 
	 */
	public static java.lang.String convertPostfixToInfix(java.lang.String postfix)
			throws InvalidNotationFormatException{
		char current;
		String one, two;
		for(int i =0; i<postfix.length(); i++) {
			current = postfix.charAt(i);
			switch(current) {
			case '0': case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9':
				stack.push(""+current); break;
			case '+': case '-': case '*': case '/':
				try {
					two = (String)stack.pop();
					one = (String)stack.pop();
					stack.push("("+one+""+current+two+")");
				}
				catch(Exception e) {
					throw new InvalidNotationFormatException();
				}
			}
		}
		String str = (String)stack.pop();
		if(stack.isEmpty()) {
			stack = new NotationStack<String>(30);
			queue = new NotationQueue<String>(30);
			return str;
		}
		else 
			throw new InvalidNotationFormatException();
	}

	/**
	 * convert infix expression to postfix expression 
	 * @param infix string containing infix expression
	 * @return string containing postfix expression
	 * @throws InvalidNotationFormatException thrown when the format of postfix is incorrect
	 */ 
	public static java.lang.String convertInfixToPostfix(java.lang.String infix)
			throws InvalidNotationFormatException{
		char current; 
		String currentStr,temp;
		for (int i =0; i<infix.length(); i++) {
			current= infix.charAt(i);
			currentStr = Character.toString(current);
			switch(current) {
			case '0': case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9':
				queue.enqueue(currentStr); 
				break;

			case '+': case '-':
				if((((String)stack.peek()).equals("*")) || (((String)stack.peek()).equals("/")) || (((String)stack.peek()).equals("+")) || (((String)stack.peek()).equals("-"))) {
					temp = (String)stack.pop();
					queue.enqueue(temp);
				}
				stack.push(currentStr); break;

			case '*': case '/':
				if((!stack.isEmpty()) && ((((String)stack.peek()).equals("*")) || (((String)stack.peek()).equals("/"))))
				{
					temp = (String)stack.pop();
					queue.enqueue(temp);
				}
				stack.push(currentStr); break;

			case '(':
				stack.push(currentStr); 
				break;

			case ')':
				while(!(stack.isEmpty()) && !(((String)stack.peek()).equals("("))) {
					queue.enqueue(stack.pop());
				}
				if(stack.isEmpty()) {
					throw new InvalidNotationFormatException();
				}
				stack.pop(); break;
			}
		}
		while(!stack.isEmpty()) {
			if(!(((String)stack.peek()).equals("("))) {
				queue.enqueue(stack.pop());
			}
			else if(((String)stack.peek()).equals("("))
				throw new InvalidNotationFormatException();
		}
		String returning = queue.toString();
		stack = new NotationStack<String>(30);
		queue = new NotationQueue<String>(30);
		return returning;
	}
}
