#include <stdlib.h> 
#include <stdio.h>
int small(int *a, int n){
     int min = 999999;
     for(int i = 0; i < n; i++){
          if(min > *(a+i)){
               min = *(a+i);
          }
}
return min; }
int main(){
     int n;
     printf("Enter size: ");
     scanf("%d", &n);
     int* arr;
     arr = malloc(n*sizeof(int));
     printf("Enter elements\n");
     for(int i =0; i < n; i++){
          scanf("%d", arr+i);
     }
     int ans = small(arr, n);
     printf("The Smallest number is = %d\n", ans);
free(arr);
return 0; }