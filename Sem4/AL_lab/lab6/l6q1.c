#include <stdio.h>
#include <stdlib.h>

struct binarytree
{
    int data;
    struct binarytree * right;
    struct binarytree * left;
};

typedef struct binarytree node;

void insert(node ** tree, int val)
{
    node *temp = NULL;
    if(!(*tree))
    {
        temp = (node *)malloc(sizeof(node));
        temp->left = temp->right = NULL;
        temp->data = val;
        *tree = temp;
        return;
    }

    if(val < (*tree)->data)
    {
        insert(&(*tree)->left, val);
    }
    else if(val > (*tree)->data)
    {
        insert(&(*tree)->right, val);
    }
}

static int opcount=0;

int count(node *tree)
{
    int c =  1;
    opcount ++;
    if (tree ==NULL)
        return 0;
    else
    {
        c += count(tree->left);
        c += count(tree->right);
        return c;
    }
}

int main()
{

    node *root;
    node *tmp;
    int c,num=0;

    root = NULL;

    printf("Enter nodes of tree : (-1 to stop) \n");
    while (num!=-1){
        scanf("%d", &num);
        if (num == -1)break;
        insert(&root, num);
    }

    c = count(root);
    printf("Number of nodes %d \n",c);
    printf("Opcount is %d\n", opcount);
}