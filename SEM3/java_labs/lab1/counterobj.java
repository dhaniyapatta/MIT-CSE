class Counter {

	private static int count=0; 

	Counter () {
		count++; 
	}

	static void showCount() {
		System.out.println("Number of objects created: " + count);
	}
}

class Counternum {

	public static void main(String[] args) {
		Counter c1 = new Counter(); 
		Counter c2 = new Counter(); 
		Counter c3 = new Counter(); 
		Counter c4 = new Counter(); 

		Counter.showCount(); 

	}
}
