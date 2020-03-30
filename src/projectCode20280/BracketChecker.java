package projectCode20280;
import java.util.*;

public class BracketChecker<E> extends LinkedStack<E> {	
	public BracketChecker()
	{
		;
	}
	
	public static boolean checkParentheses(String in)
	{
		boolean b = true;
		
		char[] brackets = new char[in.length()];
		
		LinkedStack<Character> stack = new LinkedStack<Character>();
		
		for (int i = 0; i < in.length(); i++)
		{
			brackets[i] = in.charAt(i);
		}
		
		for (int j = 0; j < in.length(); j++)
		{
			if (brackets[j] == '[' || brackets[j] == '{' || brackets[j] == '(')
			{
				stack.push(brackets[j]);
			}
			
			else if (brackets[j] == ']')
			{
				if (stack.top().equals('['))
				{
					stack.pop();
				}
				
				else
				{
					b = false;
					break;
				}
			}
			
			else if (brackets[j] == '}')
			{
				if (stack.top().equals('{'))
				{
					stack.pop();
				}
				
				else
				{
					b = false;
					break;
				}
			}
			
			else if (brackets[j] == ')')
			{
				if (stack.top().equals('('))
				{
					stack.pop();
				}
				
				else
				{
					b = false;
					break;
				}
			}
			
			else
			{
				b = false;
				break;
			}
		}
		
		return b; 
	}
	
	public static void main(String[] args)
	{
		Scanner readIn = new Scanner(System.in);
		
		System.out.println("Enter your string of parentheses: ");
		
		String p = readIn.next();
		
		System.out.println("Was this a fully closed system?: " + checkParentheses(p));
	}
}
