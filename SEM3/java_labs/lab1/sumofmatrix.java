import java.util.*; 

class Matrix {

	static int[][] matrixSum (int [][]a, int [][]b){
       int n = a.length; 
       int m = a[0].length;
       int[][] c = new int[n][m];  
		for(int i=0; i<n;i++){
			for(int j=0; j<m;j++){
				c[i][j]= a[i][j] + b[i][j]; 
			}
		}
		return c; 
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in); 
		System.out.println("Enter n and m"); 
		int n = sc.nextInt(); 
		int m = sc.nextInt(); 
		int[][] a = new int[n][m];
		int[][] b = new int[n][m];
		System.out.println("Enter first matrix");
		for(int i=0; i<n;i++){
			for(int j=0; j<m;j++){
				a[i][j] = sc.nextInt(); 
			}
		}

		System.out.println("Enter second matrix");
		for(int i=0; i<n;i++){
			for(int j=0; j<m;j++){
				b[i][j] = sc.nextInt(); 
			}
		}
		int[][] c = new int[n][m];
		c = matrixSum(a,b);
		System.out.println("Sum of Matrix is:");
		for(int i=0; i<n;i++){
			System.out.println(); 
			for(int j=0; j<m;j++){
				System.out.print(" "+c[i][j]+" ");
			}
		}
 
	}
}
