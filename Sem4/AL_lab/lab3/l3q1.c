#include <stdio.h>
#include <stdlib.h>

/*Bubble sort Algorithm:
Best case scenario O(n) when the array is already sorted
Worst case scenario O(n2) when in reverse order */

int max(int num1, int num2)
{
    return (num1 > num2 ) ? num1 : num2;
}

void sort(int *a, int n)
{
	int i,j;
	int temp;
	int opcount1=0,opcount2=0;
	for (i=0;i<n-1;i++)
	{
		++opcount1;
		for(j=0;j<n-1-i;j++)
		{
			
			if(a[j+1]<a[j])
			{
				++opcount2;
				temp= a[j+1];
				a[j+1]=a[j];
				a[j]=temp;
			}
		}
	}



	printf("\nSorted Array:");
	for(i=0;i<n;i++)
		printf("%d ",a[i]);
	printf("\nOpcount: %d\n",max(opcount1,opcount2));
}


int main()
{
	int *a;
	int i,n=5;
 	printf("Best case :\n");
	for(int j=0; j<4; j++)
	{
		a= (int *)malloc(sizeof(int)*n);
		for(i=0;i<n;i++)
			a[i]=i;
		sort(a,n);
		free(a);
		n=n+5;

	}

    n=5;
	printf("\n\nWorst case :\n");
	for(int j=0; j<4; j++)
	{
		a= (int *)malloc(sizeof(int)*n);
		for(i=0;i<n;i++)
			a[i]=n-i;
		sort(a,n);
		free(a);
		n=n+5;

	}

	return 0;


}