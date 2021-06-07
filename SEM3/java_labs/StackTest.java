//Define a simple generic stack class and show the use 
//of the generic class for two different class types 
//Student and Employee class objects.

import java.util.*;

class Stack <T>
{
	private T[] arr;
	private int size;
	private int top;

	public Stack(int l)
	{
		this.size=l;
		this.arr= (T[]) new Object[size];
		this.top=-1;
	}

	public boolean isEmpty()
	{
		if(this.top==-1)
			return true;
		else 
			return false;

	}

	public boolean isFull()
	{
		if(this.top==size-1)
			return true;
		else 
			return false;
	}


	public void push(T item)
	{
		if(!this.isFull())
			this.arr[++this.top]=item;
	}

	public T pop() 
     {
		if(this.isEmpty()) {
				System.out.println("Empty");
			}
			return(this.arr[this.top­­--]); 
		}


	public void display()
	{
		for(int i=0;i<=this.top;i++)
			System.out.println(this.arr[i]);	
	}

}



class Student
{
	int reg;
	String name;

	public Student(String name, int reg)
	{
		this.name=name;
		this.reg=reg;
	}

     @Override
    public String toString() {
return "Student [reg no=" + this.reg + ", name=" + this.name + "] ";
}


}


class Employee
{
	int id;
	String name;

	public Employee(String name, int id)
	{
		this.name=name;
		this.id=id;
	}




}





class StackTest
{
 public static void main(String[] args) 
 {
 	Scanner sc=new Scanner(System.in);
 	

 	Stack <Student> s1=new Stack <Student>(3);
 	Stack <Employee> e1=new Stack <Employee>(3);

 	s1.push(new Student("ankit",100));
 	s1.push(new Student("pahala",200));
 	s1.push(new Student("jaja",100));

 	s1.display();
 

 	

 	
 }
}


