/*Write a program to construct a binary tree to 
support the following operations.          
Assume no duplicate elements while constructing the tree.             
i.Given a key, perform a search in the binary search tree. 
If the key is found then display “key found” else insert the key in the binary search tree.            
ii.Display the tree using inorder, preorder and post order traversal methods */

#include <stdio.h>
#include <stdlib.h>

struct Node {
	struct Node *lchild;
	struct Node *rchild;
	int data;

}*root=NULL;

struct Node * Search(struct Node *root, int key)
{
	struct Node *r=NULL,*p;

	if(root==NULL)
	{
		p=(struct Node *)malloc(sizeof(struct Node));
		p->data=key;
		p->rchild=p->lchild=NULL;
		printf("Element insert\n");
		return p;
	}

	if(root->data==key)
	{
		printf("Element Found\n");
	}

	else if(root->data > key)
		root->lchild= Search(root->lchild,key);

	else if(root->data < key)
		root->rchild= Search(root->rchild,key);

	return root;

}


void preorder(struct Node * root) 
{
	if (root) 
	{
		printf("%d ", root->data); 
		preorder(root->lchild); 
		preorder(root->rchild);
	} 
}

void inorder(struct Node * root) 
{
	if (root) 
	{
		inorder(root->lchild); 
		printf("%d ", root->data); 
		inorder(root->rchild);
	} 
}


void postorder(struct Node * root) 
{
	if (root) 
	{
		postorder(root->lchild); 
		postorder(root->rchild);
		printf("%d ", root->data); 
	} 
}



int main()
{
	int ch,f=1;
	struct Node *root=NULL;
	while(f)
	{
		printf("Enter the choice\n");
		printf("1 - enter key, 2 - preorder, 3 - inorder, 4 - postorder\n");
		scanf("%d",&ch);
		switch(ch)
		{
			case 1: printf("Enter the key\n");
			int a;
			scanf("%d",&a);
			root=Search(root,a);
			break;


			case 2:	printf("Preorder:\n"); 
					preorder(root);
					printf("\n");
					break;

			case 3:	printf("Inorder:\n");
					inorder(root); 		
					printf("\n"); 
					break;

			case 4:	printf("Postorder:\n"); 	
					postorder(root);
					printf("\n");
					break;

			default: f=0;
		}

	}

}


