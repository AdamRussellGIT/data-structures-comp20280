package projectCode20280;

public class Collatz 
{
	public static void CollatzAlg(int n)
	{
		if (n == 1)
		{
			return;
		}
		
		if (n%2 == 0)
		{
			System.out.println(n/2);
			CollatzAlg(n/2);
		}
		
		if (n%2 == 1)
		{
			System.out.println(n*3 + 1);
			CollatzAlg(n*3 + 1);
		}
	}
	
	public static void main(String[] args)
	{
		CollatzAlg(10000);
	}
}
