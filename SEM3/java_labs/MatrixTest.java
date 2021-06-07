
//2.Write and execute a java program to create 
//and initialize a matrix of integers. 
//Create n threads( by implementing Runnable interface) 
//where n is equal to the number of rows in the matrix. 
//Each of these threads should compute a distinct row sum. 
//The main thread computes the complete sum by 
//looking into the partial sums given by the threads.
import java.util.*;

class Matrix
{
	private int a[][];

	public Matrix(int n, int m)
	{
		a= new int [n][m];
	}

	public int [] getRow(int i)
	{
		return a[i];
	}


	public void input()
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the Matrix");

		for(int i=0;i<a.length;i++)
			for(int j=0;j<a[i].length;j++)
				a[i][j]=sc.nextInt();

	}
}

class RowSum implements Runnable
{
	private int arr[];
	private int sum;
	Thread thrd;
	RowSum(int []a)
	{
		thrd= new Thread(this);
		arr=a;
		sum=0;
		thrd.start();
	}

	public int getSum()
	{
		return sum;
	}

	public void run()
	{
		try{
		for(int i=0;i<arr.length;i++)
			sum+=arr[i];
		thrd.join();
		}
		catch(InterruptedException e)
				{
					e.printStackTrace();
				}


	}
}


class MatrixTest
{
	public static void main(String[] args) 
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("enter the dimension");
		int m=sc.nextInt();
		int n=sc.nextInt();


		Matrix mat=new Matrix(m,n);

		mat.input();

		RowSum []row=new RowSum[n];

		for(int i=0; i<n; i++)
		{
			row[i]=new RowSum(mat.getRow(i));
			
		}
		

		int sum=0;
		
			for(int i=0;i<n;i++)
			{
				try
				{
				System.out.println("Individual RowSum= "+row[i].getSum());
				Thread.sleep(100);
				sum=sum+row[i].getSum();
				}
				catch(InterruptedException e)
				{
					e.printStackTrace();
				}

			}
		
		
		System.out.println("Total sum = "+sum);

	}
}










