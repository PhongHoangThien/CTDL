package lab10;

import java.rmi.server.Operation;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class MyLIFO_App {
	/* Stack */
	
	// This method reserves the given array
	public static <E> void reserve(E[] array) {
		Stack<E> st = new Stack<E>();
		
		for (E e : array) {
			st.push(e);
		}
		
		for (int i = 0; i < array.length; i++) {
			array[i] = st.pop();
		}
	}

	// This method checks the correctness of the given input
	// i.e. ()(())[]{(())} ==> true, ){[]}() ==> false
	public static boolean isCorrect(String input) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			
			if (c == '(' || c == '[' || c == '{') {
				stack.push(c);
			}
			
			if (c == ')' || c == ']' || c == '}') {
				if (stack.isEmpty()) {
					return false;
				}
				else {
					char cs = stack.pop();
					boolean isPaired =(cs == '(' && c == ')' 
									|| cs == '[' && c == ']' 
									|| cs == '{' && c == '}');
					if (stack.isEmpty() && !isPaired) {
						System.out.println(i);
						return false;
					}
				}
			}
		}
		return true;
	}

	// This method evaluates the value of an expression
	// i.e. 51 + (54 *(3+2)) = 321
	public static int evaluateExpression(String expression) throws Exception {
		Stack<Integer> operandStack = new Stack<Integer>();
		Stack<Character> operatorStack = new Stack<Character>();
		String exp = insertBlank(expression);
		
		/* phase 1 */
		StringTokenizer tokens = new StringTokenizer(exp, " ");

		while (tokens.hasMoreTokens()) {
			String token = tokens.nextToken();
			
			//1.1
			if (checkToken(token).equals("number")) {
				operandStack.push(Integer.parseInt(token));
				
				// multiply and divide first
				if (operandStack.size() >= 2 && 
						(operatorStack.peek() == '*' || operatorStack.peek() == '/')) {
					int op2 = operandStack.pop();
					int op1 = operandStack.pop();
					operandStack.push((int) process(op1, op2, operatorStack.pop()));
					
				}
			}
			
			//1.2
			if (checkToken(token).equals("plus-sub")){
				operatorStack.push(token.charAt(0));
			} 
			
			//1.3
			if (checkToken(token).equals("mul-div")) {
				operatorStack.push(token.charAt(0));
			}
			
			//1.4
			if (checkToken(token).equals("open-bracket")) {
				operatorStack.push(token.charAt(0));
			} 
			
			//1.5
			if (checkToken(token).equals("close-bracket")) {
				if (operatorStack.peek() == '(' || operatorStack.peek() == '[') {
					/*
					if multiply or divide operator inside a bracket,
					process it in 1.1 will leave 1 open bracket in operatorStack
					using stack.pop to remove blank bracket: ()
					*/
					operatorStack.pop();
				}
				else if (!operatorStack.isEmpty()) {
					int op2 = operandStack.pop();
					int op1 = operandStack.pop();
					operandStack.push((int) process(op1, op2, operatorStack.pop()));
						
					//remove open bracket
					operatorStack.pop();
				}
			}
		}
		
		/* phase 2 */
		while (!operatorStack.isEmpty()) {
			int op2 = operandStack.pop();
			int op1 = operandStack.pop();
			operandStack.push((int) process(op1, op2, operatorStack.pop()));
		}
		return operandStack.pop();
	}
	
	public static double process(int op1, int op2, char operator) throws Exception{
		switch (operator) {
		case '+': return op1 + op2;
		case '-': return op1 - op2;
		case '*': return op1 * op2;
		case '/': return op1 / op2;
		}
		throw new Exception("missing operator");
	}
	
	public static String insertBlank(String str) {
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == '(' || c == ')' || c == '[' || c == ']' || 
					c == '+' || c == '-' || c == '*' || c == '/') {
				result += " " + c + " ";
			}
			else if (Character.isDigit(c)) result += c;
		}
		return result;
	}
	
	public static String checkToken(String token) {
		if (token.length() == 1) {
			char c = token.charAt(0);
			if (Character.isDigit(c)) {
				return "number";
			}
			if (c == ' ') {
				return "space";
			}
			if (c == '+' || c == '-') {
				return "plus-sub";
			}
			if (c == '*' || c == '/') {
				return "mul-div";
			}
			if (c == '(' || c == '[') {
				return "open-bracket";
			}
			if (c == ')' || c == ']') {
				return "close-bracket";
			}
		} else if (token.length() > 1) {
			return "number";
		}
		return " ";
	}
	
	/* Queue */
	
	// method stutter that accepts a queue of integers as a parameter and replaces
	// every element of the queue with two copies of that element
	// front [1, 2, 3] back
	// becomes
	// front [1, 1, 2, 2, 3, 3] back
	public static <E> void stutter(Queue<E> input) {
		Queue<E> queue = new LinkedList<E>();
		
		while (!input.isEmpty()) {
			queue.offer(input.poll());
		}
		
		while (!queue.isEmpty()) {
			input.offer(queue.peek());
			input.offer(queue.poll());
		}
	}
	
	// Method mirror that accepts a queue of strings as a parameter and appends the
	// queue's contents to itself in reverse order
	// front [a, b, c] back
	// becomes
	// front [a, b, c, c, b, a] back
	public static <E> void mirror(Queue<E> input) {
		Stack<E> stack = new Stack<E>();
		
		for(E e : input) {
			stack.push(e);
		}
		
		while (!stack.isEmpty()) {
			input.offer(stack.pop());
		}
	}
	
	public static void main(String[] args) throws Exception {
		/* Stack */
		Integer[] arr1 = {1,2,3,4};
		reserve(arr1);
		System.out.println(Arrays.toString(arr1));
		
		System.out.println(isCorrect("()(())[]{(())}"));
		System.out.println(isCorrect("){[]}()"));
		System.out.println(isCorrect("([((){{}})])"));
		
		System.out.println(evaluateExpression("(1+2)*4-3"));
		System.out.println(evaluateExpression("51+(54*(3+2))"));
		System.out.println(evaluateExpression("(4/2)*(3+2)"));
		System.out.println(evaluateExpression("(4/2)*(6*(10/5+1))"));
		System.out.println(evaluateExpression("[6+4/2]+(10/5+1)"));
		
		/* Queue */
		Queue<String> queue = new LinkedList<String>();
		queue.add("a");
		queue.add("b");
		queue.add("c");
		
		stutter(queue);
		System.out.println(queue);
		
		mirror(queue);
		System.out.println(queue);
	}
}
