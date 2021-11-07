#include <sys/types.h>
   #include <sys/socket.h>
   #include <stdio.h>
   #include <stdlib.h>
   #include <sys/un.h>
   #include <unistd.h>
   #include <string.h>
   #include <arpa/inet.h>
#define PORTNO 10200

void swap(int *xp, int *yp)
{
    int temp = *xp;
    *xp = *yp;
    *yp = temp;
}

int main()
{

	int sockfd,newsockfd;
	int portno,clilen,n=1;
	int buff[256];
	struct sockaddr_in seraddr,cliaddr;
	int i,values;
	sockfd=socket(AF_INET,SOCK_STREAM,0);
    seraddr.sin_family=AF_INET;
    seraddr.sin_addr.s_addr=inet_addr("172.16.57.106");
    seraddr.sin_port=htons(PORTNO);

    bind(sockfd,(struct sockaddr *)&seraddr,sizeof(seraddr));

    listen(sockfd,5);
   int st;

    while(1)
    {
    	//accept the connection
    	clilen=sizeof(clilen);
    	newsockfd=accept(sockfd,(struct sockaddr*)&cliaddr,&clilen);

    	if(fork()==0)
    	{
        	n=read(newsockfd,&st,sizeof(st));
    		n = read(newsockfd,buff,sizeof(buff));
    		printf(" array received from client");

			for(int i=0; i < st-1; i++)     
			   {
				for (int j = 0; j < st-i-1; j++)
				  {
					if (buff[j] > buff[j+1])
					  {
						swap(&buff[j], &buff[j+1]);
					  }
				  }
			   }
           

    		n = write(newsockfd,buff,sizeof(buff));
    		close(newsockfd);
    		exit(0);
    	}
    	else
    	{
    		close(newsockfd);
    	}
    }
	return 0;
}
