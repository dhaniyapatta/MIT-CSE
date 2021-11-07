#include <sys/types.h>
   #include <sys/socket.h>
   #include <stdio.h>
   #include <stdlib.h>
   #include <sys/un.h>
   #include <unistd.h>
   #include <string.h>
   #include <arpa/inet.h>
int main()
{
	int len,result,sockfd,n=1;
	struct sockaddr_in address;
	char ch[256],buf[256];
	sockfd = socket(AF_INET, SOCK_STREAM, 0);
	address.sin_family=AF_INET;
	address.sin_addr.s_addr=inet_addr("172.16.57.106");
	address.sin_port=htons(10200);
	
	len = sizeof(address);
	result=connect(sockfd,(struct sockaddr *)&address,len);
	if(result==-1)			
	{
		perror("\nCLIENT ERROR");
		exit(1);
	}

	printf("Enter number of  elements\n");
	int size;
	scanf("%d",&size);
	int arr[size];
	printf("Enter elements\n");
	for(int i=0;i<size;i++)
	  scanf("%d",&arr[i]);
	
	write(sockfd,&size,sizeof(int));
	write(sockfd,arr,sizeof(arr));
	n=read(sockfd,arr,sizeof(arr));
	
	printf("Sorted elements recieved from server\n");
	for(int i=0;i<size;i++)
	  printf("%d\t",arr[i]);

	printf("\n");
	return 0;

}