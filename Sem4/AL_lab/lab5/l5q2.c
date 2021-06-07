#include<stdio.h>
#include <stdlib.h>


typedef struct node{
  int data;
  struct node *left;
  struct node *right;
} node;

node *root;
node *create(){
  node *p;
  int x;
  printf("Enter data(0 for no data):");
  scanf("%d",&x);
  if(!x)
  return NULL;
  p=(node*)malloc(sizeof(node));
  p->data=x;
  printf("Enter left child of %d:\n",x);
  p->left=create();

  printf("Enter right child of %d:\n",x);
  p->right=create();
  return p;
}

void preorder(node *t){
  if(t!=NULL){
    printf("\n%d",t->data);
    preorder(t->left);
    preorder(t->right);
  }
}

void bt(){
  root=create();
}



int max(int a, int b){
  return a>b?a:b;
}


int getDiameter(node* root, int diameter){
    if (root == NULL) {
        return 0;
    }

    int left_height = getDiameter(root->left, diameter);
    int right_height = getDiameter(root->right, diameter);

    int max_diameter = left_height + right_height + 1;
    diameter = max(diameter, max_diameter);


    return max(left_height, right_height) + 1;
}

int Diameter(node* root)
{
    int diameter = 0;
    diameter=getDiameter(root, diameter);

    return diameter;
}



int main(){
  bt();
  printf("The diameter of the tree is %d", Diameter(root)+2);
  return 0;
}
