#include<stdlib.h>
#include<stdio.h>

int sum(int n)
{
	static int s;
if(n==0)
return 0;
return sum(n-1)+s;
return s;
}


int main()
{
int r=sum(5);
printf("%d ",r);
return 0;
}