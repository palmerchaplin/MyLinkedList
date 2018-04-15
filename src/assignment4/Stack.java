package assignment4;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.List;

/**
 * E is the type of the items in the stack.
 */
public class Stack<E>
{
	//	the items in the stack
	private List<E> items;

	public Stack()
	{
		this.items = new LinkedList<>();
	}

	public void push(E item)
	{
		//	add item to front of items list
		this.items.add(0, item);
	}

	public E pop()
	{
		//	returns the first item and deletes it from the list
		return this.items.remove(0);
	}

	public E peek()
	{
		//	returns the first item but does not delete it
		return this.items.get(0);
	}

	public boolean isEmpty()
	{
		return this.items.isEmpty();
	}
	
	//check if a string of parentheses and brackets is balanced
	//prints false if not balanced, prints true if it is
	public static boolean isBalanced(String input)
	{
		//normal brackets [] not included
		//if string has odd length, cannot be balanced
		if(input.length()%2 == 1)
		{
			System.out.println("Enter a string with even parentheses and only curly brackets and parentheses.");
			return false;
		}
		else
		{
			Stack <Character> values = new Stack<Character>();
			//iterate through string and compare values
			for(int i = 0; i < input.length(); i++)
			{
				//if character at i is opening, push to stack
					if(input.charAt(i) == '{' || input.charAt(i) == '(')
					{
						values.push(input.charAt(i));
					}
					//checks if opposite facing brackets. Must do at separate time than ()
					else if(input.charAt(i) == '}')
					{
						try
						{
							if(!values.pop().equals('{'))
							{
								return false;
							}
						}
						catch(IndexOutOfBoundsException ex)
						{
							System.out.println("Must start with an opening bracket or parenthese");
							return false;
						}
					}
					else if(input.charAt(i) == ')')
					{
						try
						{
							if(!values.pop().equals('('))
							{
								return false;
							}
						}
						catch(EmptyStackException ex)
						{
							System.out.println("Must start with an opening bracket or parenthese");
							return false;
						}
					}
					else
					{
						System.out.println("Invalid String input");
						return false;
					}
				}
			//returns true if input is "   " because it is still balanced. 0 curly, 0 parentheses.
			return values.isEmpty();
		}
	}
	
	public static double PostFixEval(String exp)
	{
		double result = 0;
		double operand1 = 0;
		double operand2 = 0;
		//get rid of white space
		String[] splits = exp.split("\\s+");
		
		//input must have odd length because there will be n+1 operands for n operators. n + (n+1) is always odd.
		//assuming there is always expression to be evaluated
		if(splits.length % 2 != 1)
		{
			System.out.println("Invalid entry");
			return 0.0;
		}
		
		Stack <Double> list = new Stack<Double>();
		
		for(int i = 0; i < splits.length; i++)
		{
			try
			{
				//convert to double
				double current = Double.parseDouble(splits[i]);
				list.push(current);
			}
			//catches if not a double and is an operand. default is if not valid entry
			catch(NumberFormatException ex)
			{
				//checks for operator being in first in expression
				if(list.isEmpty())
				{
					System.out.println("Invalid entry");
					return 0.0;
				}
				operand2 = list.pop();
				operand1 = list.pop();
				switch (splits[i]) 
				{
				case "+":
					list.push(operand1 + operand2);
					break;
				case "-":
					list.push(operand1 - operand2);
					break;
				case "*":
					list.push(operand1 * operand2);
					break;
				case "/":
					list.push(operand1 / operand2);
					break;
				default:
					System.out.println("Invalid entry");
					return 0.0;
				}
			}
			
		}
		
		//result should be last value in stack and popping it will return the result		
		result = list.pop();
		//if operator is in between operands, this loop will see extra value at beginning after incorrect result is popped
		if(!list.isEmpty())
		{
			System.out.println("Invalid entry");
			return 0.0;
		}
		return result;
	}
	
}