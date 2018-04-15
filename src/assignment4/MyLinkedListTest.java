package assignment4;

import java.util.Iterator;
import java.util.Scanner;


public class MyLinkedListTest {

	public static void main(String[] args) {
		
		MyLinkedList<Integer> j = new MyLinkedList<Integer>();
		for (int i =0; i<8; i++)
		{
			j.add(i);
		}
		
		//iterator test
		Iterator<Integer> it = j.iterator();
		while(it.hasNext())
		{
			Object x = it.next();
			System.out.println(x);
		}
		//test for isbalanced
		System.out.println("Enter your string:");
		Scanner scan = new Scanner(System.in);
		String test = scan.nextLine();
		System.out.println(Stack.isBalanced(test));
		
		//test for postfixnotation
		System.out.println("Enter your string for postfix:");
		String test2 = scan.nextLine();
		System.out.println(Stack.PostFixEval(test2));
		
		
	}

}
