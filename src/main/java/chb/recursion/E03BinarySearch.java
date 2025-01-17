package chb.recursion;

/**
 * 递归操作之递归二分查找法
 */

public class E03BinarySearch {
    public static int search(int[] a,int target){
       return f(a,target,0,a.length-1);
    }

    private static int f(int[] a,int target,int i,int j){
        if(i>j){
            return -1;
        }
        int m=(i+j)>>>1;
        if(target<a[m]){
            return f(a,target,i,m-1);
        }else if(a[m]<target){
            return f(a,target,m+i,j);
        }else {
            return m;
        }
    }

    public static void main(String[] args) {
        int[] arry={1,6,9,70,80,90};
        System.out.println(search(arry, 70));
        System.out.println(search(arry, 90));
        System.out.println(search(arry, 6));

    }
}
