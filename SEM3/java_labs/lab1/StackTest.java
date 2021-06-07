import java.util.*; import java.lang.*;
class PushException extends Exception
{
     private int code;
     public PushException(int c)
     {
this.code = c; }
     public int getCode()
     {
          return code;
     }
}
class PopException extends Exception
{
     private int code;
     public PopException(int c)
     {
this.code = c; }
     public int getCode()
     {
          return code;
     }
}
class Stack
{
     private char item[];
     private int top;
     private int size;
     public Stack()
{
this.item = new char[0]; this.top = ­1; this.size =0;
     }
     public Stack(int size)
     {
this.size = size; this.item = new char[size]; this.top = ­1;
     }
     public boolean isEmpty()
     {
if(this.top == ­1) return (true);
          return (false);
     }
     public boolean isFull()
     {
if(this.top == this.size ­1) return (true);
          return (false);
     }
     public boolean push(char elem) throws PushException
     {
if(this.isFull())
throw new PushException(1);
this.item[++this.top] = elem;
          return (true);
     }
     public char pop() throws PopException
     {
if(this.isEmpty())
throw new PopException(1);
char x= this.item[top­­];
return x; }
     public void display()
     {
for(int i=0; i<this.size;i++) System.out.println(this.item[i]);
} }
class StackTest
{
     public static void main(String[] args)
     {
Scanner sc=new Scanner(System.in); System.out.println("Enter the size of the Stack"); int size= sc.nextInt();
Stack s = new Stack(size);

int n=1;
System.out.println( "­­­­­­­­Created a stack that can store "+size+" elements­­­­­­­­­­");
do{
System.out.println("­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­"); System.out.println("1­Push");
System.out.println("2­Pop"); System.out.println("3­Display"); System.out.println("4­Exit");
System.out.println("­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­"); System.out.println("Enter the choice : ");
");
int choice = sc.nextInt(); switch (choice)
{
case 1:
System.out.print("Enter the char to be pushed:
char pp=sc.next().charAt(0); try
{
System.out.println("Trying to push
s.push(pp);
             }
             catch(PushException e)
             {
System.out.print("Caught
"+pp+" in the stack");
PushException with code ");
+ el);
with code ");
         }
         catch(PopException e)
         {
System.out.print("Caught PopException
System.out.println(e.getCode()); }
    break;
case 3:
    break;
case 2:
try
{
System.out.println(e.getCode()); }
char el = s.pop(); System.out.println("Popped element: "
System.out.println("Displaying Stack :");

s.display();
                    break;
                case 4:
n=0;
                    break;
                default:
System.out.println("Invalid choice !"); }while(n!=0);
} }