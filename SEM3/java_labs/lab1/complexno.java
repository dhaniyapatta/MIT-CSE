import java.util.*; 
import java.math.*; 
class Complex {

	private int real,img; 

	void assign(int a, int b){
		this.real = a; 
		this.img = b; 
	}

	void display(){
		System.out.println(real+"+ i"+img); 
	}

 Complex add(Complex b) {
   Complex c = new Complex();
   c.real = this.real + b.real; 
   c.img = this.img + b.img;

   return c; 
 }

  Complex sub(Complex b) {
 Complex c = new Complex();
   c.real = Math.abs(this.real - b.real); 
   c.img = Math.abs(this.img - b.img);

   return c; 
 }
}

class ComplexNum {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int a1,b1,a2,b2; 
		Complex c1 = new Complex(); 
		Complex c2 = new Complex(); 
		System.out.println("Enter real and complex part of first complex number:");
		
		a1 = sc.nextInt();
		b1 = sc.nextInt(); 

		System.out.println("Enter real and complex part of second complex number:");
		
		a2 = sc.nextInt();
		b2 = sc.nextInt(); 

		c1.assign(a1,b1);
		c2.assign(a2,b2); 


		System.out.println("First Complex number:");

		c1.display(); 


		System.out.println("second Complex number:");


		c2.display(); 

		Complex c3 = new Complex(); 

		c3 = c1.add(c2);
		 System.out.println("Addition of both complex num:" + c3.real + "+" + "i" + c3.img);

		 c3 = c1.sub(c2);
		 System.out.println("Subtraction of both complex num:" + c3.real + "+" + "i" + c3.img);


	}
}



