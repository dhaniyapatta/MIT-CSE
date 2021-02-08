import java.util.*; 
import java.math.*; 

class Time {

	private int hrs, mins, secs; 

	void assign(int h, int m, int s){
		this.hrs = h; 
		this.mins = m; 
		this.secs = s; 
	}

	void display() {
		System.out.println(hrs+":"+mins+":"+secs);
	}

 	Time add(Time b) {
   Time c = new Time();
   long int sec1 = this.hrs*60*60 + this.mins*60 + this.sec; 
   long int sec2 = b.hrs*60*60 + b.mins*60 + b.sec; 
   long int sec3 = sec1 + sec2; 

if (sec3/(60*60)>24)
	{ c.hrs = 24;}
else
{
	c.hrs = sec3/(60*60);
}

if (sec3/(60*60)>60)
	{ c.mins = 59;}
else
{
	c.mins = sec3/(60);
}

if (sec3>60)
	{ c.secs = 59;}
else
{
	c.secs = sec3;
}

   return c; 
 }

 Time sub(Time b) {
   Time c = new Time();
   c.hrs = Math.abs(this.hrs - b.hrs); 
   c.mins = Math.abs(this.mins - b.mins);
   c.secs = Math.abs(this.secs - b.secs);

   return c; 
 }

 void compare(Time b){
 	if(this.hrs == b.hrs && this.mins == b.mins && this.secs == b.secs){
 		System.out.println("They are equal"); 
 	}
 	else if (this.hrs > b.hrs ){
 		System.out.println("First is greater than second"); 
 	}
 	else if (this.hrs < b.hrs){
 		System.out.println("First is lesser than second"); 
 	}

 }
}

class TimeQ {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int a1,b1,c1,a2,b2,c2; 
		Time t1 = new Time(); 
		Time t2 = new Time(); 
		System.out.println("Enter hrs, mins, and secs of first time:");
		
		a1 = sc.nextInt();
		b1 = sc.nextInt(); 
		c1 = sc.nextInt();

		System.out.println("Enter hrs, mins, and secs of second time:");
		
		a2 = sc.nextInt();
		b2 = sc.nextInt(); 
		c2 = sc.nextInt(); 

		t1.assign(a1,b1,c1);
		t2.assign(a2,b2,c2); 


		System.out.println("First time:");

		t1.display(); 


		System.out.println("Second Time:");

		t2.display(); 

		Time t3 = new Time(); 

		t3 = t1.add(t2);
		 System.out.println("Addition of both time:");
		 t3.display();

		 t3 = t1.sub(t2);
		 System.out.println("Subtraction of both time:");
		 t3.display();

		 t1.compare(t2);

	}
