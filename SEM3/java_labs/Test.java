
import java.util.Arrays; 
import java.util.List;
class Test
{
public static final <T> void swap (T[] a, int i, int j) {
T t = a[i]; a[i] = a[j]; a[j] = t;
}
public static void main(String[] args)
{
Integer []a = {1,2,4,5,6,4,7,8};
System.out.println("a:"+Arrays.toString(a)); 
swap(a, 0, 4);
System.out.println("after swap:"+Arrays.toString(a)); }
}