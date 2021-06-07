package p2.p1;
class Employee
{
	public int age,id;
	private int salary;

	Employee()
	{
		this.age=0;
		this.id=0;
		this.salary=0;
	}

	Employee(int a, int i, int sal)
	{
		this.age=a;
		this.id=i;
		this.salary=sal;
	}

	public int getAge()
	{
		return age;
	}
	public int getID()
	{
		return id;
	}
	public int getSalary()
	{
		return salary;
	}


}