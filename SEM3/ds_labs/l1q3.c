#include <stdlib.h> 
#include <stdio.h>
struct DOB {
     int day, month, year;
};
struct ADRS {
     int house_no;
     long zipcode;
     char state[20];
};
struct EMPLOYEE {
     char name[20];
     struct DOB dob;
     struct ADRS address;
};

int main(){
     int n;
     //store data
     printf("Enter number of employees\n");
     scanf("%d", &n);
     
     struct EMPLOYEE *ptr = (struct EMPLOYEE *)malloc(n*sizeof(struct EMPLOYEE));
     for(int i = 0; i < n; i++){
          printf("Name: \n");
scanf("%s", ptr[i].name);
printf("DOB: Day Month Year ");
scanf("%d %d %d", &ptr[i].dob.day, &ptr[i].dob.month,
&ptr[i].dob.year);
          printf("Address:House     No, Zip, State:  ");
scanf("%d %li %s", &ptr[i].address.house_no, &ptr[i].address.zipcode, ptr[i].address.state);
     }
     //display
     printf("\n\n DISPLAYING INFORMATION  ");
     for(int i = 0; i < n; i++){
printf("Employee %d: \n", i+1);
printf("%s\n", ptr[i].name);
printf("DOB: ");
printf("%d/%d/%d\n", ptr[i].dob.day, ptr[i].dob.month,
ptr[i].dob.year);
          printf("Address: ");
printf("House Number:%d, Zip:%li, State:%s\n", ptr[i].address.house_no, ptr[i].address.zipcode, ptr[i].address.state);
}
return 0; }