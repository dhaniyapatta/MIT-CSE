#include <stdio.h>
#include <stdlib.h>
#include <string.h>


int max(int num1, int num2)
{
    return (num1 > num2 ) ? num1 : num2;
}

void stringMatch(char *p, char *s)
{
	int lp=strlen(p);
	int ls=strlen(s);
	printf("%d  %d\n",lp,ls);

	int i,j;
	int opcount1 =0,opcount2=0;



    for (i = 0;i<ls-lp+1; i++) 
    {
    	++opcount1;
    	int j=0;
        for (j = 0; j<lp; j++)
        {
         	if (s[i + j]!= p[j])
         	{
                break;
         	}

            ++opcount2;
        }

        if (j == lp) 
            printf("Pattern found at index %d \n", i);
      
    }
    printf("\nOpcount: %d\n",max(opcount1,opcount2));
    


}


int main()
{
    

    /* Best case scenario when no letter matches
     Worsr case scenario 1.when pattern and letters all same
						2. When all same except last letter in pattern */

    printf("\nBest case scenario:");
   char s1[]="AAAAAAAAAAAAA";
   char p1[]="BBBB";
	stringMatch(p1, s1);
	printf("\nWorst case Scenario 1:");
	char s2[]="AAAAAAAAAAAAA";
  	char  p2[]="AAAA";
    stringMatch(p2, s2);
    printf("\nWorst case Scenario 2:");
	char s3[]="RRRRRRRRRRRRRRRRRRRRRRRRS";
   char p3[]="RRRRS";
    stringMatch(p3, s3);





    return 0;
}