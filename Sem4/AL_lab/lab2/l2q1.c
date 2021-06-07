
#include <stdio.h>
#include <stdlib.h>
#include <math.h>

/* Euclid’s algorithm for computing gcd(m, n)
Step 1 If n = 0, return the value of m as the answer and stop; otherwise,
proceed to Step 2.
Step 2 Divide m by n and assign the value of the remainder to r.
Step 3 Assign the value of n to m and the value of r to n. Go to Step 1
*/


static int euclid_opcount=0;

int Euclid(int a,int b)
{
	euclid_opcount++;
    if (a == 0)
        return b;
    return Euclid(b % a, a);
}




/*Consecutive integer checking algorithm for computing gcd(m, n)
Step 1 Assign the value of min{m, n} to t.
Step 2 Divide m by t. If the remainder of this division is 0, go to Step 3;
otherwise, go to Step 4.
Step 3 Divide n by t. If the remainder of this division is 0, return the value of
t as the answer and stop; otherwise, proceed to Step 4.
Step 4 Decrease the value of t by 1. Go to Step 2 */

static int consec_opcount=0;

int consecGCD(int a, int b)
{
	int t;
	if(a<b)
		t=a;
	else t=b;

	while(t!=0)
	{
		consec_opcount++;
		if(a%t==0)
		{
			if(b%t==0)
			{
				return t;
			}

		}
		t--;
	}
	return t;
}



int Isprime(int a)
{
	for(int i=2;i <= a/2;i++)
	{
	if(a%i == 0){
	return 0;
	}
}
return 1;
}
 
int* prime(int a, int* count,int* opcount)
{
	*count =0;
	int* arr = (int*)malloc((a+1)*sizeof(int));
	for(int i=0;i<=a;i++){
	arr[i] = 1;
}
	for(int i=2;i<=a;i++)
	{
		(*opcount)++;
		if(arr[i] == 1)
		{
			for(int j = i*i;j<=a;j += i)
			{
				arr[j] = 0;
			}
		}
	}
	int* arr1 = (int*)malloc((a+1)*sizeof(int));

	for(int i=2;i<(a+1);i++)
	{
		(*opcount)++;
		if(arr[i] == 1)
		{
			while(a%i == 0)
			{
				arr1[*count] = i;
				*count = *count +1;
				a /= i;
 
			}
		}
	}
	return arr1;
}



void middleschool(int m,int n)
{
	int opcount = 0;
	int count1,count2;
	int* arrm = (int*)malloc(sizeof(int)*m);
	int* arrn = (int*)malloc(sizeof(int)*n);
	arrm = prime(m,&count1,&opcount);
	arrn = prime(n,&count2,&opcount);

	int gcd = 1;

	int i=0,j=0;
	while(i<count1 && j<count2)
	{
		if(arrn[j] == arrm[i])
		{
			gcd = gcd * arrn[j];
			i++;
			j++;
		}
		else if(arrn[j] > arrm[i])
		{
			i++;
		}
		else
		{
			j++;
		}
	}
	printf("opcount for middleschool = %d\n",opcount );
	printf("GCD through middleschool method = %d\n",gcd);
 
}





int main()
{
	int m, n;
	printf("Enter two numbers whose GCD has to be calculated\n");
	scanf("%d%d",&m,&n);
	printf("EuclidGCD =%d \nEuclid’s opcount= %d",Euclid(m,n),euclid_opcount );
	printf("\nConsecGCD =%d \nConsec opcount= %d",consecGCD(m,n),consec_opcount);
	middleschool(m,n);

}


















