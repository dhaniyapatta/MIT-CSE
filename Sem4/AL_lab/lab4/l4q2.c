#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#define MAX 5

struct Vertex {
   char label;
   bool visited;
};


int stack[MAX]; 
int top = -1; 


struct Vertex* lstVertices[MAX];

int adjMatrix[MAX][MAX];

int vertexCount = 0;


void push(int item) { 
   stack[++top] = item; 
} 

int pop() { 
   return stack[top--]; 
} 

int peek() {
   return stack[top];
}

bool isStackEmpty() {
   return top == -1;
}

//graph functions

//add vertex to the vertex list
void addVertex(char label) {
   struct Vertex* vertex = (struct Vertex*) malloc(sizeof(struct Vertex));
   vertex->label = label;  
   vertex->visited = false;     
   lstVertices[vertexCount++] = vertex;
}

void addEdge(int start,int end) {
   adjMatrix[start][end] = 1;
   adjMatrix[end][start] = 1;
}

//display the vertex
void displayVertex(int vertexIndex) {
   printf("%c ",lstVertices[vertexIndex]->label);
}       

//get the adjacent unvisited vertex
int getAdjUnvisitedVertex(int vertexIndex) {
   int i;

   for(i = 0; i < vertexCount; i++) {
      if(adjMatrix[vertexIndex][i] == 1 && lstVertices[i]->visited == false) {
         return i;
      }
   }

   return -1;
}

void depthFirstSearch() {
   int i;

   //mark first node as visited
   lstVertices[0]->visited = true;

   //display the vertex
   displayVertex(0);   

   //push vertex index in stack
   push(0);

   while(!isStackEmpty()) {
      //get the unvisited vertex of vertex which is at top of the stack
      int unvisitedVertex = getAdjUnvisitedVertex(peek());

      //no adjacent vertex found
      if(unvisitedVertex == -1) {
         pop();
      } else {
         lstVertices[unvisitedVertex]->visited = true;
         displayVertex(unvisitedVertex);
         push(unvisitedVertex);
      }
   }

   //stack is empty, search is complete, reset the visited flag        
   for(i = 0;i < vertexCount;i++) {
      lstVertices[i]->visited = false;
   }        
}

int main() {
   int i,f=0,j,start,end;

   for(i = 0; i < MAX; i++)    // set adjacency {
      for(j = 0; j < MAX; j++) // matrix to 0
         adjMatrix[i][j] = 0;
   

   printf("Add Vertex:       (press [ to stop adding) \n");
   char c;
   scanf("%c", &c);
  
   

   while(c!='[')
   {
      f++;
      addVertex(c);
      scanf("%c", &c);


   }
   printf("%d\n",f );

   printf("\nAdd edge:\n");

   for(i=0;i<=f;i++)
   {
      scanf("%d",&start);
      scanf("%d",&end);
      addEdge(start,end);

   }



   printf("Depth First Search: ");
   depthFirstSearch(); 

   return 0;   
}