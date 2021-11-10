#include<stdio.h>
#include<stdlib.h>

int H[50];
int size = -1;


int parent(int i)
{

	return (i - 1) / 2;
}

int leftChild(int i)
{

	return ((2 * i) + 1);
}

int rightChild(int i)
{

	return ((2 * i) + 2);
}

void shiftUp(int i)
{
	while (i > 0 && H[parent(i)] < H[i]) {
	    
	    int temp = H[i];
	    H[i] = H[parent(i)];
	    H[parent(i)] = temp;
		i = parent(i);
	}
}

void shiftDown(int i)
{
	int maxIndex = i;

	int l = leftChild(i);

	if (l <= size && H[l] > H[maxIndex]) {
		maxIndex = l;
	}

	int r = rightChild(i);

	if (r <= size && H[r] > H[maxIndex]) {
		maxIndex = r;
	}

	if (i != maxIndex) {
	    int temp = H[i];
	    H[i] = H[maxIndex];
	    H[maxIndex] = temp;
		shiftDown(maxIndex);
	}
}

void insert(int p)
{
	size = size + 1;
	H[size] = p;

	shiftUp(size);
}

int extractMax()
{
	int result = H[0];

	H[0] = H[size];
	size = size - 1;

	shiftDown(0);
	return result;
}

void changePriority(int i, int p)
{
	int oldp = H[i];
	H[i] = p;

	if (p > oldp) {
		shiftUp(i);
	}
	else {
		shiftDown(i);
	}
}

int getMax()
{

	return H[0];
}
void removee(int i)
{
	H[i] = getMax() + 1;

	shiftUp(i);

	extractMax();
}

int main()
{
	printf("Enter number of element to insert:\n ");
	int N = 0;
	scanf("%d",&N);
	while(N!=0){
	    int val;
	    scanf("%d",&val);
	    insert(val);
	    N--;
	}

	int i = 0;
	printf("Priority Queue : ");
	
	while (i <= size) {
		printf("%d",H[i]);
		i++;
	}

	printf("\n");
	printf("Node with maximum priority : %d",extractMax());
	printf("Priority queue after extracting maximum : ");
	int j = 0;
	while (j <= size) {
		printf("%d\t",H[j]);
		j++;
	}

	printf("\n");
	changePriority(2, 49);
	printf("Priority queue after priority change : ");
	int k = 0;
	while (k <= size) {
		printf("%d \t",H[k]);
		k++;
	}
    printf("\n");
    int rem;
    printf("Enter priority to remove:");
    scanf("%d",&rem);
	removee(rem);
    printf("Priority queue after removing the element : \n");
	int l = 0;
	while (l <= size) {
		printf("%d \t",H[l]);
		l++;
	}
	return 0;
}