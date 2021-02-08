
import java.io.*; 
import java.util.*;


class Prime { 

	static boolean isPrime(int n) 
	{ 
		if (n <= 1) 
			return false; 
		if (n <= 3) 
			return true; 

		if (n % 2 == 0 || n % 3 == 0) 
			return false; 

		for (int i = 5; i * i <= n; i = i + 6) 
			if (n % i == 0 || n % (i + 2) == 0) 
				return false; 

		return true; 
	} 

	public static void main(String args[]) 
	{ 
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the range of prime terms");
		int n= sc.nextInt();
		for(int i=1;i<=n;i++)
		{
			if(isPrime(i)==true)
				System.out.print(i+" ");
		} 
	} 
} 
