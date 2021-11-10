#include <stdio.h>
#include <stdlib.h>

int opcount = 0;

void topDown(int arr[], int currIndex)
{
    int parent = (currIndex - 1)/2;
    while(parent >= 0)
    {
	    opcount++;
        if(arr[parent]<arr[currIndex])
        {
            int temp = arr[parent];
            arr[parent] = arr[currIndex];
            arr[currIndex] = temp;

            currIndex = parent;
            parent = (currIndex - 1)/2;
        }
        else
            return;
    }
}

int main()
{
    int a[40], n;
    printf("Enter no. of elements:\n");
    scanf("%d", &n);
    printf("Enter Elements:\n");

    for(int i = 0; i<n; i++)
    {
        scanf("%d", &a[i]);
        topDown(a, i);
		for(int k = 0; k<=i; k++)
			printf("%d ", a[k]);
		printf("\n");
    }

    printf("Heapified array:\n");

    for(int i = 0; i<n; i++)
        printf("%d ", a[i]);

    printf("\n");
    printf("opcount: %d\n", opcount);
    exit(0);

    return 0;
}
